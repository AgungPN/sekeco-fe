package dtos.purchase;

import dtos.ApiResponse;
import dtos.product.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDTOs extends ApiResponse {
    List<Product> data;
}
