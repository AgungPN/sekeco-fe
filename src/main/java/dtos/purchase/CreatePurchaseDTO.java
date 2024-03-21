package dtos.purchase;

import dtos.purchase.product.ExistingProductRequest;
import dtos.purchase.product.NewProductRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePurchaseDTO {
    private Long supplierId;
    private Long amount;
    private List<NewProductRequest> newProducts;
    private List<ExistingProductRequest> existingProducts;
}
