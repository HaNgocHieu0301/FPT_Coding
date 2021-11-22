
/**
 *
 * @author ADMIN
 */
public class Book {
    private String title;
    private int price;

    public Book() {
    }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title.toUpperCase();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }  
    
}
