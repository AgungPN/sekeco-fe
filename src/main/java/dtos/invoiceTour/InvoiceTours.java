package dtos.invoiceTour;

import lombok.Data;
import lombok.EqualsAndHashCode;
import web.ApiResponse;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvoiceTours extends ApiResponse {
    private List<InvoiceTour> content;
}
