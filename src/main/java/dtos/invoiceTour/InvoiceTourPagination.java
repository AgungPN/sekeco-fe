package dtos.invoiceTour;

import dtos.PaginateResponse;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvoiceTourPagination extends PaginateResponse{
    private List<InvoiceTour> content;
}
