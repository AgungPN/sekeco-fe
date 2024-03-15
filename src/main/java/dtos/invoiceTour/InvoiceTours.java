package dtos.invoiceTour;

import dtos.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvoiceTours extends ApiResponse {
    private List<InvoiceTour> data;
}
