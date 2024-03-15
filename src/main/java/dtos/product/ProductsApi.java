package dtos.product;

import dtos.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductsApi extends ApiResponse {
    private Product data;
}
