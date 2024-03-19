package dtos;

import dtos.supplier.Supplier;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class UniverseResponse extends ApiResponse {
    private List<Supplier> content;
}
