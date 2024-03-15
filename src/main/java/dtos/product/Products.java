/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.product;

import dtos.PaginateResponse;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Rosemary
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class Products extends PaginateResponse{
    private List<Product> content;
}

