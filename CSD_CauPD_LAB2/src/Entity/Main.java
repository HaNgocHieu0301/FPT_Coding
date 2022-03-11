package Entity;

import java.util.*;

/**
 *
 * @author ADMIN
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    public static ProducList pl = new ProducList();
    public static CustomerList cl = new CustomerList();
    public static OrderList ol = new OrderList();

    public static int mainMenu() {
        System.out.println("1. Product List.");
        System.out.println("2. Customer List.");
        System.out.println("3. Order List.");
        System.out.println("4. Exit.");
        return Validation.getInt("Enter your choice: ", 1, 4);
    }

    public static int productListMenu() {
        System.out.println("1.1. Load data from file");
        System.out.println("1.2. Input & insert data ");
        System.out.println("1.3. Inorder traverse");
        System.out.println("1.4. Breadth-first traverse");
        System.out.println("1.5. In-order traverse to file");
        System.out.println("1.6. Search by pcode");
        System.out.println("1.7. Delete by pcode by copying");
        System.out.println("1.8. Simply balancing");
        System.out.println("1.9. Count number of products");   
        System.out.println("1.10 Exit product list menu");
        return Validation.getInt("Enter your choice: ", 1, 10);
    }

    public static int customerListMenu() {
        System.out.println("2.1. Load data from file");
        System.out.println("2.2. Input & add to the end");
        System.out.println("2.3. Display data");
        System.out.println("2.4. Save customer list to file");
        System.out.println("2.5. Search by ccode");
        System.out.println("2.6. Delete by ccode");
        System.out.println("2.7 Exit customer list menu");
        return Validation.getInt("Enter your choice: ", 1, 7);
    }

    public static int orderListMenu() {
        System.out.println("3.1.      Input data");
        System.out.println("3.2.      Display data with total value");
        System.out.println("3.3.      Sort  by pcode + ccode");
        System.out.println("3.4       Exit order list menu.");
        return Validation.getInt("Enter your choice: ", 1, 4);
    }

    public static void main(String[] args) {
        while (true) {
            switch (mainMenu()) {
                case 1:
                    productlist();
                    break;
                case 2:
                    customerList();
                    break;
                case 3:
                    orderList();
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }

    private static void productlist() {
        label:
        while (true) {
            switch (productListMenu()) {
                case 1:
                    pl.loadFromFile("product.txt");
                    break;
                case 2:
                    pl.addProduct();
                    break;
                case 3:
                    pl.inorderTraverse(pl.getRoot());
                    break;
                case 4:
                    pl.breadth(pl.getRoot());
                    break;
                case 5:
                    pl.saveToFile("product.txt");
                    break;
                case 6:
                    pl.searchByPcode();
                    break;
                case 7:
                    pl.deleteByCopying();
                    break;
                case 8:
                    pl.balance();
                    break;
                case 9:
                    pl.count();
                    break;
                case 10:
                    break label;
            }
        }
    }

    private static void customerList() {
        label:
        while (true) {
            switch (customerListMenu()) {
                case 1:
                    cl.loadFromFile("customer.txt");
                    break;
                case 2:
                    cl.addCustomer();
                    break;
                case 3:
                    cl.display();
                    break;
                case 4:
                    cl.saveToFile();
                    break;
                case 5:
                    cl.searchByCCode();
                    break;
                case 6:
                    cl.delByCCode();
                    break;
                case 7:
                    break label;
            }
        }
    }

    private static void orderList() {
        label:
        while(true){
            switch(orderListMenu()){
                case 1:
                    ol.input(null, null,0);
                    break;
                case 2:
                    ol.display();
                    break;
                case 3:
                    ol.sortByCCodeAndPCode();
                    ol.display();
                    break;
                case 4:
                    break label;
            }
        }
    }
    /*
    (1)
1, A , 6 , 2 , 1
3, B , 2 , 1 , 1
2, C , 5 , 4 , 1
4, D , 4 , 3 , 1

(2)
1, A , 6 , 2 , 1
3, B , 2 , 1,  1
4, D , 4 , 3 , 1

(3)
1, A , 6 , 2 , 1
3, B , 9 , 1,  1
2, C , 5 , 4 , 1
4, D , 4 , 3 , 1

(4)
1, A , 6 , 2 , 1
3, B , 2 , 1,  1
2, C , 5 , 4 , 1
4, D , 4 , 3 , 1
6,  E , 3,  2,  1

(5)
3, B , 2 , 1,  1
1, A , 6 , 2 , 1
6, E , 3,  2,  1
4, D , 4 , 3 , 1
2, C , 5 , 4 , 1
    */
}
