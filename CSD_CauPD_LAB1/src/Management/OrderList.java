package Management;

import Entity.*;
import MyLinkedList.*;
import java.io.File;

/**
 *
 * @author ADMIN
 */
public class OrderList extends MyLinkedList<Ordering> {

    ProducList pl;
    CustomerList cl;

    public OrderList() {
        pl = new ProducList();
        cl = new CustomerList();
    }

    public void input(String pcode, String ccode, int quantity) {
        //quantity = 0;
        if (pcode == null && ccode == null) {
            pcode = Validation.getString("Enter product code: ");
            ccode = Validation.getString("Enter customer code: ");
            quantity = Validation.getInt("Enter quantity: ", 0, Integer.MAX_VALUE);
        }
        Node<Product> p = pl.searchPCode(pcode);
        if (p == null || cl.searchCCode(ccode) == null || search(new Ordering(pcode, ccode)) != null) {
            System.out.println("Input isn't accepted");
            return;
        }
        System.out.println("Input is accepted.");
        int checkQuantity = p.getElement().getQuantity() - p.getElement().getSaled();
        if (checkQuantity == 0) {
            System.err.println("The product is exhausted.");
        } else if (quantity <= checkQuantity) {
            this.addLast(new Ordering(pcode, ccode, quantity));
            p.getElement().setSaled(p.getElement().getSaled() + quantity);
            System.err.println("Successfully!");
        } else {
            System.err.println("Failed!");
        }
    }

    public void display() {
        System.out.printf("%6s | %6s | %6s\n", "Customer", "Product", "Quantity");
        this.travese();
    }

    public void sortByCCodeAndPCode() {
        Node<Ordering> pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.getNext();
            while (pj != null) {
                if (pi.getElement().getCcode().compareTo(pj.getElement().getCcode()) > 0) {
                    Ordering tmp = pi.getElement();
                    pi.setElement(pj.getElement());
                    pj.setElement(tmp);
                }
                if (pi.getElement().getCcode().equals(pj.getElement().getCcode()) && pi.getElement().getPcode().compareTo(pj.getElement().getPcode()) < 0) {
                    Ordering tmp = pi.getElement();
                    pi.setElement(pj.getElement());
                    pj.setElement(tmp);
                }
                pj = pj.getNext();
            }
            pi = pi.getNext();
        }
    }

    @Override
    public Node<Ordering> search(Ordering element) {
        Node<Ordering> p = head;
        while (p != null) {
            if (element.getCcode().equals(p.getElement().getCcode())
                    && element.getPcode().equals(p.getElement().getPcode())) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }

    public void loadFiles(String pathName1, String pathName2) {
        pl.loadFromFile(pathName1);
        cl.loadFromFile(pathName2);
    }

    public void sell(String pcode, String ccode, int quantity) {
        input(pcode, ccode, quantity);
    }

    public void displayProduct() {
        pl.displayData();
    }

    public void displayOrdering() {
        display();
    }

    public static void main(String[] args) {
        OrderList t = new OrderList();
        t.loadFiles("product1.txt", "customer.txt");
        t.sell("P1", "C1", 1); // Successful
        t.sell("P1", "C2", 1); // Not successful because quantity=selled
        t.sell("P2", "C2", 2); // Successful
        t.displayProduct();
        t.displayOrdering();
        System.out.println();
    }
}
