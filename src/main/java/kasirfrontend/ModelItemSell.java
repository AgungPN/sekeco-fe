/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirfrontend;

import java.text.DecimalFormat;

/**
 *
 * @author Lenovo
 */
public class ModelItemSell {

    /**
     * @return the product
     */
    public int getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(int product) {
        this.product = product;
    }

    /**
     * @return the prodyctName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param prodyctName the prodyctName to set
     */
    public void setProductName(String prodyctName) {
        this.productName = prodyctName;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public ModelItemSell() {
    }

    public ModelItemSell(int product, String productName, int qty, double price, double total) {
        this.product = product;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }
    
    
    private int product;
    private String productName;
    private int qty;
    private double price;
    private double total;
    
   public Object[] toTableRow(int rowNum) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return new Object[]{this, df.format(rowNum), productName, df.format(qty), "Rp " + df.format(price), "Rp " + df.format(total)};
    }
    
}
