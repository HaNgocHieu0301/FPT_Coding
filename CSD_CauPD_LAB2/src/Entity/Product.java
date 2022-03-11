package Entity;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 *
 * @author ADMIN
 */
public class Product implements Comparable<Product>{

    private String pcode;
    private String pro_name;
    private int quantity;
    private int saled;
    private double price;

    public Product() {
    }

    public Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        //return String.format("%-5s|%-10s|  %-10d|  %-6d|  %-7.1f|  %-7.1f\n", pcode, pro_name, quantity, saled, price, price*saled);
        return String.format("%-5s|%-10s|  %-10d|  %-6d|  %-7.1f", pcode, pro_name, quantity, saled, price);
    }

    @Override
    public int compareTo(Product o) {
        return this.pcode.compareTo(o.pcode);
    }
}
