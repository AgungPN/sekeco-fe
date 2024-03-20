package dtos.purchase;

import dtos.supplier.Supplier;
import java.util.Date;
import lombok.Data;

@Data
public class Purchase {
    private Long purchaseId;
    private Supplier supplier;
    private Integer totalItems;
    private Long totalPrice;
    private Integer discount = 0;
    private Long amount;
    private Date createdAt;
    private Date updatedAt;
}
