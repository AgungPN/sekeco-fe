/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.product;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author Rosemary
 */
@Data
public class Product {
    
    private int productId;
    private String barcode;
    private String name;
    private String brand;
    private int profitSharingAmount;
    private int price;
    private Integer stock;
    private Date createdAt;
    private Date updatedAt;
}
