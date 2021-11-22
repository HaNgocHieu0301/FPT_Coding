
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class CarList extends ArrayList<Car> {
    
    BrandList brandlist;
    
    public String frameID_format = "F\\d{5}";
    public String engineID_format = "E\\d{5}";
    Scanner sc = new Scanner(System.in);
    
    public CarList(BrandList bList) {
        brandlist = bList;
    }
    
    public boolean loadFromFile(String path) {
        try {
            File f = new File(path);
            if (!f.exists() || !f.canRead()) {
                System.err.println("Loading Cars.txt if fail!");
                System.exit(0);
            } else {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(line, ",:");
                    String[] component = new String[stk.countTokens()];
                    int i = 0;
                    while (stk.hasMoreTokens()) {
                        component[i] = stk.nextToken();
                        i++;
                    }
                    String carID = component[0].trim();
                    String brandID = component[1].trim();
                    String color = component[2].trim();
                    String frameID = component[3].trim();
                    String engineerID = component[4].trim();
                    int pos = brandlist.searchID(brandID);
                    Brand b = brandlist.get(pos);
                    Car c = new Car(carID, b, color, frameID, engineerID);
                    this.add(c);
                }
                br.close();
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return true;
    }
    
    public boolean saveToFile(String path) {
        try {
            PrintWriter pw = new PrintWriter(path);
            for (Car x : this) {
                pw.println(x);
            }
            System.err.println("Save Succesfully!");
            pw.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return true;
    }
    
    public int searchID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equals(eID)) {
                return i;
            }
        }
        return -1;
    }

    public void checkDupAndBlank(int pos, String characteristic, String word ) {
        if (pos >= 0) {
            System.err.println(word + " is duplicated.");
        }
        if (characteristic.length() < 1) {
            System.err.println(word + " is not blank");
        }
    }
    
    public void addCar() {
        String carID;
        String color;
        String engineerID;
        String frameID;
        Menu menu = new Menu();
        
        //carID
        do {
            System.out.print("Enter ID's car: ");
            carID = sc.nextLine();
            checkDupAndBlank(searchID(carID), carID, "Car ID");
        } while (searchID(carID) >= 0 || carID.length() < 1);
        
        //brand
        System.out.println("Choose brand's car: ");
        Brand b = brandlist.getUserChoice();
        
        //color
        do {
            System.out.print("Enter color's car: ");
            color = sc.nextLine();
            checkDupAndBlank(-1, color, "Color");
        } while (color.length() < 1);
        
        //frameID
        do {
            System.out.print("Enter ID's frame: ");
            frameID = sc.nextLine();
            checkDupAndBlank(searchFrame(frameID), frameID, "Frame ID");
            if (!frameID.matches(frameID_format)) {
                System.err.println("Frame ID must have format F00000.");
            }
        } while ((searchFrame(frameID) >= 0) || !frameID.matches(frameID_format) || frameID.length() < 1);
        
        //engineerID
        do {
            System.out.print("Enter ID's engineer: ");
            engineerID = sc.nextLine();
            checkDupAndBlank(searchEngine(engineerID), engineerID, "Engineer ID");
            if (!engineerID.matches(engineID_format)) {
                System.err.println("Engineer ID must have format E00000.");
            }
        } while (searchEngine(engineerID) >= 0 || !engineerID.matches(engineID_format) || engineerID.length() < 1);
        Car c = new Car(carID, b, color, frameID, engineerID);
        this.add(c);
        System.err.println("Car is added.");
    }
    
    public void printBasedBrandName() {
        System.out.print("Enter word(s): ");
        String word = sc.nextLine();
        int count = 0;
        for (Car c : this) {
            if (c.getBrand().getBrandName().contains(word)) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.err.println("No car is detected!");
        }
    }
    
    public boolean removeCar() {
        String carID;
        System.out.print("Enter ID's car: ");
        carID = sc.nextLine();
        if (searchID(carID) < 0) {
            System.err.println("Not Found!");
        } else {
            int pos = searchID(carID);
            this.remove(pos);
            System.err.println("Remove successfully!");
        }
        return true;
    }
    
    public boolean updateCar() {
        System.out.print("Enter ID's car: ");
        String carID;
        carID = sc.nextLine();
        if (searchID(carID) < 0) {
            System.err.println("Not Found!");
        } else {
            int pos = searchID(carID);
            String color;
            String engineerID;
            String frameID;
            Menu menu = new Menu();
            //brand
            System.out.println("Enter brand's car: ");
            Brand b = brandlist.getUserChoice();
            
            //color
            do {
                System.out.print("Enter color's car: ");
                color = sc.nextLine();
                checkDupAndBlank(-1, color, "Color");
            } while (color.length() < 1);
            
            //frameID
            int posF;
            do {
                System.out.print("Enter ID's frame: ");
                frameID = sc.nextLine();
                posF = searchFrame(frameID);
                if (pos == posF) {
                    checkDupAndBlank(-1, frameID, "Frame ID");
                }else{
                    checkDupAndBlank(posF, frameID, "Frame ID");
                }
                if (!frameID.matches(frameID_format)) {
                    System.err.println("Frame ID must have format F00000.");
                }
            } while ((searchFrame(frameID) >= 0 && posF != pos) || !frameID.matches(frameID_format) || frameID.length() < 1);
            
            //engineerID
            int posE;
            do {
                System.out.print("Enter ID's Engineer: ");
                engineerID = sc.nextLine();
                posE = searchEngine(engineerID);
                if (pos == posE) {
                    checkDupAndBlank(-1, engineerID, "Engineer ID");
                }else{
                    checkDupAndBlank(posE, engineerID, "Engineer ID");
                }
                if (!engineerID.matches(engineID_format)) {
                    System.err.println("Engineer ID must have format E00000.");
                }
            } while ((searchEngine(engineerID) >= 0 && pos != posE) || !engineerID.matches(engineID_format) || engineerID.length() < 1);
            this.get(pos).setBrand(b);
            this.get(pos).setColor(color);
            this.get(pos).setEngineID(engineerID);
            this.get(pos).setFrameID(frameID);
            System.err.println("Updated successfully!");
        }
        return true;
    }
    
    public void listCars() {
        Collections.sort(this);
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).screenString());
        }
    }
}
