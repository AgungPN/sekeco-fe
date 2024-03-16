package dtos.order;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {
    private Long userId;
    private Long invoiceTourId;
    private int totalItems;
    private Long totalPrice;
    private Long amount;
    private Long refund;
    List<OrderDetailsRequest> orderDetailsRequests;
}
