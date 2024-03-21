package dtos.supplier;

import dtos.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SupplierDTOs extends ApiResponse {
    private List<Supplier> data;
}
