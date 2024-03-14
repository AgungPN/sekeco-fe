package dtos.supplier;

import lombok.Data;

import java.util.Date;

@Data
public class Supplier {
    private Long supplierId;
    private String name;
    private String address;
    private String phone;
    private Date createdAt;
    private Date updatedAt;
}
