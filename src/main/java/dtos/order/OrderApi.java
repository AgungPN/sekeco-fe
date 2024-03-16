package dtos.order;

import dtos.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderApi extends ApiResponse{
    private OrderResponse data;
}
