package helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;

public class Helpers {

    public static Date date() {
        return new Date(System.currentTimeMillis());
    }

    public static String currency(int money) {
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        decimalFormatSymbols.setMonetaryDecimalSeparator(',');
//        decimalFormatSymbols.setGroupingSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

        return "Rp. " + decimalFormat.format(money);
    }

    public static int toInt(String stringNum) {
        // untuk konversi dari currency() ke int
        if (stringNum.endsWith(",00")) {
            stringNum = stringNum.replace(",", "");
            // start from 4 for remove "Rp. "
            stringNum = stringNum.substring(4, stringNum.length() - 2);
        }
        try {
            return Integer.parseInt(stringNum);
        } catch (NumberFormatException e) {
            Message.error(stringNum + " bukan angka", "Error");
        }
        return -1;
    }

    public static Long convertToLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String mapToQueryString(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }

        return result.toString();
    }
}
