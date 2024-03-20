package dtos.order;

import dtos.PaginateResponse;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderPagination extends PaginateResponse{
    private List<OrderResponse> content;
}
