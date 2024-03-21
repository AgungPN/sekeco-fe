package dtos.purchase.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewProductRequest {
    private String barcode;
    private String name;
    private String brand;
    private Long priceBuy;
    private Long priceSell;
    private Integer quantity;
    private Long profitSharingAmount;
}
