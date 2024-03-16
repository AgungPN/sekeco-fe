package dtos.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetailsRequest {
    private Long productId;
    private Long profitSharingAmount;
    private Long price;
    private int quantity;
    private Long subtotal;
}
