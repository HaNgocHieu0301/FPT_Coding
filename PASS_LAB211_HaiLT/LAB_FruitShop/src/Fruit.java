
/**
 *
 * @author ADMIN
 */
public class Fruit {

    private String fruitID;
    private String fruitName;
    private double price;
    private int quantity;
    private String Origin;

    public Fruit() {
    }
    
    public Fruit(String fruitID, String fruitName, double price, int quantity, String Origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.Origin = Origin;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    @Override
    public String toString() {
        return (fruitID+", "+fruitName+", " + Origin+", "+price +", "+ quantity);
    }
    
}
