package Entity;

import Entity.*;
import MyLinkedList.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author ADMIN
 */
public class CustomerList extends MyLinkedList<Customer> {

    /**
     * function 1: Load data from file
     *
     * @param filename
     */
    public void loadFromFile(String filename) {
        //String filename = "customer.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 3) {
                    addLast(new Customer(data[0].trim(), data[1].trim(), data[2].trim()));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * function 2: Input & add to the end: add new customer
     */
    public void addCustomer() {
        String ccode = getCCode("Enter customer code: ");
        String cus_name = Validation.getString("Enter customer name: ");
        String phone = Validation.getString("Enter customer phone: ");
        this.addLast(new Customer(ccode, cus_name, phone));
        System.out.println("Add successful!");
    }

    /**
     * function 3: Display customer information
     *
     * @param void
     * @return void
     */
    public void display() {
        System.out.println("|+++++++++++++++++++++++++++++|");
        System.out.format("|%-5s| %-10s|%-11s|", "Code", "Cus_name", "Phone");
        System.out.println("\n|-----------------------------|");
        this.travese();
        System.out.println("|+++++++++++++++++++++++++++++|");
    }

    /**
     * function 4: Save customer list to file
     *
     * @param void
     * @return void
     */
    public void saveToFile() {
        String filename = "customer.txt";
        try {
            FileWriter fw = new FileWriter(filename);
            Node<Product> p = head;
            while (p != null) {
                fw.write(p.getElement().toString() + "\n");
                p = p.getNext();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * function 5: Search by ccode
     *
     * @param void
     * @return void
     */
    public void searchByCCode() {
        String xCode = Validation.getString("Enter customer code: ");
        Node<Customer> p = searchCCode(xCode);
        if (p == null) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found!");
            System.out.println(p.getElement());
        }
    }

    /**
     * function 5: Delete by ccode
     *
     * @param void
     * @return void
     */
    public void delByCCode() {
        String xCode = Validation.getString("Enter customer code: ");
        Node<Customer> p = searchCCode(xCode);
        if (p == null) {
            System.out.println("Not Found!");
        } else {
            this.remove(p);
        }
    }

//    public void visit(Node<Customer> p) {
//        System.out.format("|%-5s| %-10s|%-11s|\n", p.getElement().getCcode(), p.getElement().getCus_name(), p.getElement().getPhone());
//    }
    //find position of node having required ccode
    public int checkCCode(String ccode) {
        if (isEmpty()) {
            return -1;
        }
        Node<Customer> p = head;
        int pos = 0;
        while (p != null) {
            if (p.getElement().getCcode().equals(ccode)) {
                return pos;
            }
            p = p.getNext();
            pos++;
        }
        return -1;
    }

    public String getCCode(String msg) {
        while (true) {
            String ccode = Validation.getString(msg);
            if (ccode.matches("^C\\d{3}")) {
                System.out.println("Customer code must be Cxxx");
                continue;
            }
            if (searchCCode(ccode) != null) {
                System.out.println("Customer code is invalid");
                continue;
            }
            return ccode;
        }
    }

    public Node<Customer> searchCCode(String xCode) {
        if (isEmpty()) {
            System.out.println("Not Found!");
            return null;
        }
        Node<Customer> p = head;
        while (p != null) {
            if (p.getElement().getCcode().equalsIgnoreCase(xCode)) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }
//
//    public static void main(String[] args) {
//        CustomerList test = new CustomerList();
//        Customer m1 = new Customer("C001", "Hieu", "0944112306");
//        Customer m2 = new Customer("C003", "Hieu", "0944112306");
//        Customer m3 = new Customer("C002", "Hieu", "0944112306");
////        test.addCustomer(m1);
////        test.addCustomer(m2);
////        test.addCustomer(m3);
//        test.loadFromFile();
//        test.display();
//        System.out.println("===============================================");
//        test.searchByCCode();
//        System.out.println("===============================================");
//        test.delByCCode();
//        test.display();
//    }

}
