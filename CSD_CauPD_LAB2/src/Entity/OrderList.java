package Entity;

import Entity.*;
import MyLinkedList.*;
import MyBinaryTree.*;
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
        TreeNode<Product> p = pl.searchPCode(pcode);
        if (p == null || cl.searchCCode(ccode) == null || search(new Ordering(pcode, ccode)) != null) {
            System.out.println("Input isn't accepted");
            return;
        }
        System.out.println("Input is accepted.");
        int checkQuantity = p.getInfor().getQuantity() - p.getInfor().getSaled();
        if (checkQuantity == 0) {
            System.out.println("The product is exhausted.");
        } else if (quantity <= checkQuantity) {
            this.addLast(new Ordering(pcode, ccode, quantity));
            p.getInfor().setSaled(p.getInfor().getSaled() + quantity);
            System.out.println("Successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    public void display() {
        System.out.printf("%6s | %6s | %6s\n", "Product", "Customer", "Quantity");
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

    public void book(String pcode, String ccode, int quantity) {
        input(pcode, ccode, quantity);
    }

    public void displayProduct() {
        pl.inorderTraverse(pl.getRoot());
    }

    public void displayCustomer() {
        cl.display();
    }

    public void displayOrdering() {
        display();
    }

    public void loadProduct(String pathname) {
        pl.loadFromFile(pathname);
    }

    public void loadCustomer(String pathname) {
        cl.loadFromFile(pathname);
    }
    public void breadthProduct(){
        pl.breadthTraverse(pl.getRoot());
    }
    void inorderProduct(){
        pl.inorderTraverse(pl.getRoot());
    }
    void traverse(){
        displayOrdering();
    }
    public static void main(String[] args) {
        OrderList t = new OrderList();
        t.loadProduct("product.txt");
        t.loadCustomer("customer.txt");
        t.breadthProduct();
        t.inorderProduct();
        t.book("P9", "C1", 1); 
        t.book("P4", "C1", 1); 
        t.book("P4", "C2", 1); 
        t.breadthProduct();
        t.travese();
        System.out.println();
    }
}
