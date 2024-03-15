package dtos.product;

import dtos.PaginateResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductsPagination extends PaginateResponse{
    private List<Product> content;
}
