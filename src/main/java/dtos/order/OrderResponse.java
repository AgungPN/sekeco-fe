package dtos.order;

import dtos.invoiceTour.InvoiceTour;
import java.util.Date;
import dtos.user.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private Long orderId;
    private User userId;
    private InvoiceTour invoiceTourId;
    private int totalItems;
    private Long totalPrice;
    private Long amount;
    private Long refund;
    private List<OrderDetailsResponse> orderDetails;
    private Date createdAt;
    private Date lastModifiedAt;
}
