
import java.util.*;

/**
 *
 * @author HNH
 */
public class Management {

    public final Scanner sc;
    ArrayList<Fruit> fruitList;
    HashMap<String, ArrayList<Fruit>> customer;

    public Management() {
        sc = new Scanner(System.in);
        customer = new HashMap<>();
        fruitList = new ArrayList<>();
    }

    public void createFruit(String value) {
        do {
            String fruitId;
            if (value == null) {
                fruitId = getIDFruit("Enter the fruit ID: ");
            } else {
                fruitId = value;
            }

            String fruitName = getFruitName("Enter the fruit name: ");
            String origin = Validation.getString("Enter the origin of fruit: ");
            int quantity = Validation.getInt("Enter the quantity of fruit", 0, Integer.MAX_VALUE);
            double price = Validation.getDouble("Enter the price of fruit: ", 0, Double.MAX_VALUE);
            //add
            Fruit f = new Fruit(fruitId, fruitName, price, quantity, origin);
            fruitList.add(f);
        } while (Validation.isContinue("Do you want to continue (Y/N)? "));
    }

    public void updateFruit() {
        String id = Validation.getString("Enter the fruit id: ");

        int index = checkID(fruitList, id);

        if (index >= 0) {
            int newQuantity = Validation.getInt("Enter new quantity: ", 0, Integer.MAX_VALUE);
            fruitList.get(index).setQuantity(newQuantity);
            System.out.println("Successfully");
        } else {
            System.out.println("Fruit id is not exist.");
            if (Validation.isContinue("Do you want to create a new fruit?(Y/N):")) {
                createFruit(id);
            }
        }
    }

    public void viewOrders() {
        if (customer.isEmpty()) {
            System.out.println("Nothing is in the list!");
        } else {
            for (String key : customer.keySet()) {
                System.out.println("Customer: " + key.trim());
                displayAnOrder(customer.get(key));
            }
        }
    }

    public void shopping() {
        ArrayList<Fruit> order = new ArrayList<>();
        ArrayList<Fruit> filterList = filterFruit();
        do {
            if (filterList.isEmpty()) {
                System.out.println("The list is empty");
                break;
            }
            //choose fruit
            displayFruitList(filterList);

            int item = Validation.getInt("Enter your choice: ", 1, filterList.size());
            Fruit f = filterList.get(item - 1);

            System.out.println("You selected: " + f.getFruitName());
            int quantity = Validation.getInt("Please enter the quantity:", 0, f.getQuantity());

            //add to order
            int indexInOrder = checkID(order, f.getFruitID());
            if (indexInOrder < 0) {
                Fruit newF = new Fruit(f.getFruitID(), f.getFruitName(), f.getPrice(), quantity, f.getOrigin());
                order.add(newF);
            } else {
                order.get(indexInOrder).setQuantity(order.get(indexInOrder).getQuantity() + quantity);
            }

            //update quantity
            f.setQuantity(f.getQuantity() - quantity);
            if (f.getQuantity() == 0) {
                filterList.remove(f);
            }
        } while (Validation.isContinue("Do you want to order continue (Y/N): "));

        if (!order.isEmpty()) {
            displayAnOrder(order);
            String name = Validation.getString("Input your name: ");
            while (customer.containsKey(name)) {
                name += " ";
            }
            customer.put(name, order);
        }
    }
//============================...====================================

    private int checkID(ArrayList<Fruit> list, String fruitId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFruitID().equalsIgnoreCase(fruitId)) {
                return i;
            }
        }
        return -1;
    }

    private int checkFruitName(String fruitName) {
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitName.equalsIgnoreCase(fruitList.get(i).getFruitName())) {
                return i;
            }
        }
        return -1;
    }

    //return the fruit id that satisfies the request
    private String getIDFruit(String msg) {
        while (true) {
            String fruitId = Validation.getString(msg);
            if (checkID(fruitList, fruitId) >= 0) {
                System.out.println("Fruit ID is existed.");
            } else {
                return fruitId;
            }
        }
    }

    //return the fruit name that satisfies the request
    private String getFruitName(String msg) {
        while (true) {
            String fruitName = Validation.getString(msg);
            if (checkFruitName(fruitName) >= 0) {
                System.out.println("Fruit name is existed.");
            } else {
                return fruitName;
            }
        }
    }

    //display a customer's order
    private void displayAnOrder(ArrayList<Fruit> list) {
        double total = 0;
        System.out.println("        Product    |    Quantity    |    Price    |    Amount");
        for (Fruit f : list) {
            System.out.format("\t%-20s", f.getFruitName());
            System.out.format("%-11d", f.getQuantity());
            System.out.format("%-15.2f", f.getPrice());
            double amount = f.getQuantity() * f.getPrice();
            System.out.format("%.2f", amount);
            total += amount;
            System.out.println();
        }
        System.out.println("Total: " + total);
    }

    public ArrayList<Fruit> filterFruit() {
        ArrayList<Fruit> arr = new ArrayList<>();
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getQuantity() > 0) {
                arr.add(fruitList.get(i));
            }
        }
        return arr;
    }

    //display fruit list 
    public void displayFruitList(ArrayList<Fruit> t) {    
            System.out.println(" | + + Item + + |  | + + Fruit Name + + |  | + + Origin + + |  | + + Price + + |");
            for (int i = 0; i < t.size(); i++) {
                System.out.format("\t%-15d", i + 1);
                System.out.format("%-25s", t.get(i).getFruitName());
                System.out.format("%-20s", t.get(i).getOrigin());
                System.out.format("%.4f$", t.get(i).getPrice());
                System.out.println();
            }
    }
}
