package Entity;

import Entity.*;
import MyLinkedList.*;
import MyBinaryTree.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author ADMIN
 */
public class ProducList extends BTree<Product> {

    /**
     * function 1: Load data from file
     *
     * @param filename
     * @return void
     */
    public void loadFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split("\\|");
                if (data.length == 5) {
                    insert(new Product(
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

    /**
     * function 2: Input & insert data: add a new product to list
     *
     * @param void
     * @return void
     */
    public void addProduct() {
        String pCode = getPCode();
        String pro_name = Validation.getString("Enter product name: ");
        int quantity = Validation.getInt("Enter quantity: ", 0, Integer.MAX_VALUE);
        int saled = Validation.getInt("Enter saled: ", 0, Integer.MAX_VALUE);
        double price = Validation.getDouble("Enter product price: ", 0, quantity);

        Product p = new Product(pCode, pro_name, quantity, saled, price);
        insert(p);
        System.out.println("Add successful!");
    }

    public String getPCode() {
        while (true) {
            String pCode = Validation.getString("Enter product code: ");
            if (!pCode.matches("P\\d{3}")) {
                System.out.println("Product code format is P+++");
                continue;
            }
            if (searchPCode(pCode) == null) {
                System.out.println("Product name is available. Please enter again.");
                continue;
            }
            return pCode;
        }
    }

    /**
     * function 3: display product information by in-order traverse
     *
     * @param p
     */
    public void inorderTraverse(TreeNode<Product> p) {
        inorder(p);
    }

    /**
     * function 4: display product information by breadth-first traverse
     *
     * @param p
     */
    public void breadthTraverse(TreeNode<Product> p) {
        breadth(p);
        System.out.println("==========================================================================");
    }
//
//    public void displayData() {
//        System.out.format("%-5s|%-10s|  %-10s|  %-6s|  %-7s|  %-7s", "Code", "Pro_name", "Quantity", "Saled", "Price", "Value");
//        System.out.println("\n---------------------------------------------------------");
//    }

    /**
     * function 5: In-order traverse to file: save data to file by in-order
     * traverse
     *
     * @param filename
     * @return void
     */
    public void saveToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            inorderTraverseToFile(getRoot(), fw);
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void inorderTraverseToFile(TreeNode<Product> p, FileWriter fw) throws IOException {
        if (p == null) {
            return;
        }
        inorderTraverseToFile(p.getLeft(), fw);
        fw.write(p.getInfor().toString() + "\n");
        inorderTraverseToFile(p.getRight(), fw);
    }

    /**
     * function 6: search a product by pcode
     *
     * @param void
     * @return void
     */
    public void searchByPcode() {
        String xCode = Validation.getString("Enter product code: ");
        TreeNode<Product> p = searchPCode(xCode);
        if (p == null) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found!");
            System.out.println(p.getInfor());
        }
    }

    //find and return Node having PCode = xCode
    public TreeNode<Product> searchPCode(String xCode) {
        if (getRoot() == null) {
            System.out.println("Cannot found.");
            return null;
        }
        TreeNode<Product> prev = null;
        TreeNode<Product> tmp = getRoot();
        while (tmp != null) {
            int check = xCode.compareTo(tmp.getInfor().getPcode());
            if (check == 0) {
                return tmp;
            } else if (check > 0) {
                tmp = tmp.getRight();
            } else {
                tmp = tmp.getLeft();
            }
        }
        return null;
    }

    /**
     * function 7: delete a product in list
     *
     * @param void
     * @return void
     */
    public void deleteByCopying(String xCode) {
//        String xCode = Validation.getString("Enter product code: ");
        TreeNode<Product> p = searchPCode(xCode);
        if (p == null) {
            System.out.println("Not Found!");
        } else {
            delete(p.getInfor());
            System.out.println("Delete Successfully!");
        }
    }

    /**
     * function 8: simply balancing
     *
     * @param void
     * @return void
     */
//    public void balance() {
//        balance();
//    }
    /**
     * function 9: count number of products in list
     *
     * @param void
     * @return void
     */
    public void count() {
        if (getSize() == 0) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("There are " + getSize() + " products in list.");
        }
    }

    @Override
    public void visit(TreeNode<Product> p) {
        super.visit(p);
        System.out.format("|  %-7.1f\n", p.getInfor().getPrice() * p.getInfor().getSaled());
    }

    public void clearAndLoad() {
        clear();
        loadFromFile("product2.txt");
    }

    /*
    modification (code, name, quantity, saled, price)
    BR = Breadth-first traversal, IN = In-order traversal. 
    f1():  Thực hiện BR (1A) và IN (1B).
    f2():  Tìm bản ghi có code = 6, sửa lại quantity=9 và BR (2).
    f3():  Xóa bản ghi có code = 2 (by copying), và BR (3).
    f4():  Không nhập dữ liệu thêm bản ghi (7,G,3,2,1) và BR (4).
    f5():  Cân bằng (simple balance) cây con gốc 3 và BR (5).
     */
    public void f1() {
        clearAndLoad();
        breadthTraverse(getRoot());
        inorder(getRoot());
        System.out.println("===================================================================");
    }

    public void f2() {
        clearAndLoad();
        TreeNode<Product> tmp = searchPCode("6");
        tmp.getInfor().setQuantity(9);
        breadthTraverse(getRoot());
    }

    public void f3() {
        clearAndLoad();
        deleteByCopying("2");
        breadthTraverse(getRoot());
    }

    public void f4() {
        clearAndLoad();
        Product newProduct = new Product("7", "G", 3, 2, 1);
        insert(newProduct);
        breadthTraverse(getRoot());
    }

    public void f5() {
        clearAndLoad();
        TreeNode<Product> balanceNode = searchPCode("3");
//        rotateRight(tmp);
        TreeNode<Product> tmp = getRoot();
        TreeNode<Product> prev = null;
        while (tmp != null) {
            if (tmp == balanceNode) {
                break;
            }
            prev = tmp;
            if (tmp.getInfor().getPcode().compareTo("3") < 0) {
                tmp = tmp.getRight();
            } else {
                tmp = tmp.getLeft();
            }
        }
        TreeNode<Product> afterBalance = balance(balanceNode);
        if (prev.getLeft() == balanceNode) {
            prev.setLeft(afterBalance);
        } else {
            prev.setRight(afterBalance);
        }
        breadthTraverse(getRoot());
    }

    public static void main(String[] args) {
        ProducList pl = new ProducList();
//        pl.f1();
//        pl.f2();
//        pl.f3();
//        pl.f4();
        pl.f5();
    }
}
