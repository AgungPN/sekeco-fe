package web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dtos.PaginateResponse;
import lombok.Data;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
public class Http {
    private String baseURL;
    private boolean isSuccess;
    private PaginateResponse paginateResponse;

    public Http() {
        baseURL = "http://localhost:3001/"; // TODO: rubah kalau link API berubah
    }

    public <T> T post(String pathURL, Object obj, Class<T> clazz) {
        HttpClient client = HttpClient.newHttpClient();

        // convert object to JSON string
        String requestJson = new Gson().toJson(obj);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURL + pathURL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestJson))
                .build();

        return convertResponseToObject(clazz, client, request);
    }

    public <T> T sendGetRequest(String url, Class<T> clazz) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseURL + url))
                .build();

        return convertResponseToObject(clazz, client, request);
    }

    private <T> T convertResponseToObject(Class<T> clazz, HttpClient client, HttpRequest request) {
        try {
            Gson gson = new Gson();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Type responseType = TypeToken.getParameterized(clazz).getType();
            T apiResponse = gson.fromJson(response.body(), responseType);
            isSuccess = response.statusCode() >= 200 && response.statusCode() < 300;
            return apiResponse;
        } catch (Exception e) {
            isSuccess = false;
            return null;
        }
    }
}
