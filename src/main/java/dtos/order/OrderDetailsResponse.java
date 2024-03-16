package dtos.order;

import dtos.product.Product;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetailsResponse {
    
    private Long orderDetailId;
    private Long orderId;
    private Product productId;
    private Long profitSharingAmount;
    private Long price;
    private int quantity;
    private Long subtotal;
    private Date createdAt;
    private Date lastModifiedAt;
}
