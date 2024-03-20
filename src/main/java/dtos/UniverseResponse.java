package dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class UniverseResponse extends ApiResponse {
    private List<Object> content;
}
