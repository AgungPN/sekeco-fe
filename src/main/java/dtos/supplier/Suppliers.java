package dtos.supplier;

import dtos.PaginateResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Suppliers extends PaginateResponse{
    private List<Supplier> content;
}
