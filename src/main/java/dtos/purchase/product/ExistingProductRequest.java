package dtos.purchase.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExistingProductRequest {
    private Long productId;
    private Long priceBuy;
    private Long priceSell;
    private Integer quantity;
    private Long profitSharingAmount;
}
