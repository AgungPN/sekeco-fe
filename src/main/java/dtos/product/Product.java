package dtos.product;

import java.util.Date;
import lombok.Data;

@Data
public class Product {
    private Long productId;
    private String barcode;
    private String name;
    private String brand;
    private Long profitSharingAmount;
    private Long price;
    private Integer stock;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public String toString() {
        return name;
    }
}
