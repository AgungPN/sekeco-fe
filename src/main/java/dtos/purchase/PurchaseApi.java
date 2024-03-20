package dtos.purchase;

import dtos.PaginateResponse;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PurchaseApi extends PaginateResponse{
    private List<Purchase> content; 
}
