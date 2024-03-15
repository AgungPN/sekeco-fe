package dtos.product;

import dtos.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Products extends ApiResponse{
    private Product data;
}
