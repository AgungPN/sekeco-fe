/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.mitra;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CreateSupplierDTO {
    private String name;
    private String address;
    private String phone;
}
