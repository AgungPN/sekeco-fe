package dtos;

import lombok.Data;

@Data
public class OrderDetails {
    private Long productId;
    private Long profitSharingAmount;
    private Long price;
    private int quantity;
    private Long subtotal;
}
