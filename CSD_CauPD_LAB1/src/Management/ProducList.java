package Management;

import Entity.*;
import MyLinkedList.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class ProducList extends MyLinkedList<Product> {

    //public final MyLinkedList<Product> list = new MyLinkedList<>();
    public void loadFromFile(String filename) {
//        String filename = "product1.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split("\\|");
                if (data.length == 5) {
                    addLast(new Product(
                            data[0].trim(),
                            data[1].trim(),
                            Integer.parseInt(data[2].trim()),
                            Integer.parseInt(data[3].trim()),
                            Double.parseDouble(data[4].trim())));
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Product addProduct() {
        String pCode = getPCode();
        String pro_name = Validation.getString("Enter product name: ");
        int quantity = Validation.getInt("Enter quantity: ", 0, Integer.MAX_VALUE);
        int saled = Validation.getInt("Enter saled: ", 0, Integer.MAX_VALUE);
        double price = Validation.getDouble("Enter product price: ", 0, quantity);

        Product p = new Product(pCode, pro_name, quantity, saled, price);
        this.addLast(p);
        System.out.println("Add successful!");
        //???
        return p;
    }

    public void displayData() {
        System.out.format("%-5s|%-10s|  %-10s|  %-6s|  %-7s|  %-7s", "Code", "Pro_name", "Quantity", "Saled", "Price", "Value");
        System.out.println("\n---------------------------------------------------------");
        this.travese();
    }

    public void saveToFile() {
        String filename = "product.txt";
        try {
            FileWriter fw = new FileWriter(filename);
            Node<Product> p = head;
            while (p != null) {
                fw.write(p.getElement().toString() + "\n");
                p = p.getNext();
            }
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        return;
    }

    public void searchByPcode() {
        String xCode = Validation.getString("Enter product code: ");
        Node<Product> p = searchPCode(xCode);
        if (p == null) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found!");
            System.out.println(p.getElement());
        }
    }

    public void dele() {
        String xCode = Validation.getString("Enter product code: ");
        Node<Product> p = searchPCode(xCode);
        if (p == null) {
            System.out.println("Not Found!");
        } else {
            this.remove(p);
            System.out.println("Delete Successfully!");
        }
    }

    public void sortByPcode() {
        Node<Product> pi = this.head;
        while (pi != null) {
            Node<Product> pj = pi.getNext();
            while (pj != null) {
                if (pi.getElement().getPcode().compareTo(pj.getElement().getPcode()) > 0) {
                    Product tmp = pi.getElement();
                    pi.setElement(pj.getElement());
                    pj.setElement(tmp);
                }
                pj = pj.getNext();
            }
            pi = pi.getNext();
        }
    }

    public void addAfter() {
        Product p = addProduct();
        int k = Validation.getInt("Enter the position: ", 0, size());
        Node<Product> nodeK = pos(k);
        insertAfter(nodeK, p);
    }

    public void delNodeAfter() {
        String xCode = Validation.getString("Enter product code: ");
        Node<Product> p = searchPCode(xCode);
        if (p == null) {
            System.out.println("Product code cannot found.");
            return;
        }
        remove(p.getNext());
        System.out.println("Successfully");
    }

    @Override
    public void visit(Node<Product> p) {
        super.visit(p);
        System.out.format("|  %-7.1f\n", p.getElement().getPrice() * p.getElement().getSaled());
    }

    //find position of node having required pcode
    public int checkPCode(String pcode) {
        if (isEmpty()) {
            return -1;
        }
        //Node<Product> p = new Node(this.first());
        Node<Product> p = head;
        int pos = 0;
        while (p != null) {
            if (p.getElement().getPcode().equals(pcode)) {
                return pos;
            }
            p = p.getNext();
            pos++;
        }
        return -1;
    }

    public String getPCode() {
        while (true) {
            String pCode = Validation.getString("Enter product code: ");
            if (!pCode.matches("P\\d{3}")) {
                System.out.println("Product code format is P+++");
                continue;
            }
            if (checkPCode(pCode) != -1) {
                System.out.println("Product name is available. Please enter again.");
                continue;
            }
            return pCode;
        }
    }

    //find and return Node having PCode = xCode
    public Node<Product> searchPCode(String xCode) {
        if (isEmpty()) {
            System.out.println("Not Found!");
            return null;
        }
        Node<Product> p = head;
        while (p != null) {
            if (p.getElement().getPcode().equalsIgnoreCase(xCode)) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }

    /*
    f1():  Load dữ liệu từ tệp và traverse.
    f2():  Xóa bản ghi có code = 2, và traverse.
    f3():  Tìm bản ghi có code = 3, sửa lại quantity=9 và traverse.
    f4():  Không nhập dữ liệu thêm bản ghi (6,E,3,2,1) và traverse.
    f5():  Sắp xếp theo saled và traverse (5).
     */
    public void clearAndLoad() {
        clear();
        loadFromFile("product1.txt");
    }

    public void f1() {
        clearAndLoad();
        travese();
    }

    public void f2() {
        clearAndLoad();
        Node<Product> p = searchPCode("2");
        remove(p);
        travese();
    }

    public void f3() {
        clearAndLoad();
        Node<Product> p = searchPCode("3");
        p.getElement().setQuantity(9);
        travese();
    }

    public void f4() {
        clearAndLoad();
        Product p = new Product("6", "E", 3, 2, 1);
        addLast(p);
        travese();
    }

    public void f5() {
        clearAndLoad();
        Node<Product> pi = head;
        while (pi != null) {
            Node<Product> pj = pi.getNext();
            while (pj != null) {
                if (pi.getElement().getSaled() > pj.getElement().getSaled()) {
                    Product tmp = pi.getElement();
                    pi.setElement(pj.getElement());
                    pj.setElement(tmp);
                }
                pj = pj.getNext();
            }
            pi = pi.getNext();
        }
        travese();
    }

//    public static void main(String[] args) {
//        ProducList test = new ProducList();
//        Product element1 = new Product("P002", "Sugar", 12, 3, 25.1);
//        Product element2 = new Product("P001", "Milk", 12, 3, 25.1);
//        Product element3 = new Product("P003", "Candy", 12, 3, 25.1);
//        Product element4 = new Product("P004", "Water", 12, 3, 25.1);
//        //test.inputAndAdd();
////        test.addProduct(element1);
////        test.addProduct(element2);
////        test.addProduct(element3);
//        //System.out.println(test.checkPCode("P003"));
//        test.loadFromFile();
//        test.displayData();
//        //test.searchByPcode();
////        test.dele();
////        test.displayData();
//        //System.out.println(element1);
//        // test.sortByPcode();
//        System.out.println("=========================================================");
//        //test.addAfter(2, element4);
//        //test.delNodeAfter("P001");
//        test.displayData();
//    }
}
