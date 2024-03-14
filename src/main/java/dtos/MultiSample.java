package dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MultiSample extends ApiResponse{
    private List<SingleSample> data;
}
