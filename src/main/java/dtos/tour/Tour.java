
package dtos.tour;

import java.util.Date;
import lombok.Data;

@Data
public class Tour {
    private Long tourId;
    private String name;
    private String address;
    private String phone;
    private Date createdAt;
    private Date updatedAt;
}
