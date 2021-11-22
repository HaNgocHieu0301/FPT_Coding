
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class BrandList extends ArrayList<Brand> {

    Scanner sc = new Scanner(System.in);

    public BrandList() {

    }

    public boolean saveToFile(String path) {
        try {
            PrintWriter pw = new PrintWriter(path);
            for (Brand x : this) {
                pw.println(x);
            }
            pw.close();
            System.err.println("Save Succesfully!");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return true;
    }

    public boolean loadFromFile(String path) {
        try {
            File f = new File(path);
            if (!f.exists() || !f.canRead()) {
                System.err.println("Loading Brands.txt is fail!");
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
                    String brandID = component[0].trim();
                    String brandName = component[1].trim();
                    String soundBrand = component[2].trim();
                    double price = Double.parseDouble(component[3].trim());
                    Brand b = new Brand(brandID, brandName, soundBrand, price);
                    this.add(b);
                }
                br.close();
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return true;
    }

    public int searchID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void displayBySearchID() {
        System.out.print("Enter ID's brand: ");
        String ID = sc.nextLine();
        int pos = searchID(ID);
        if (pos < 0) {
            System.err.println("Not Found!");
        } else {
            System.err.println(this.get(pos).toString());
        }
    }

    public Brand getUserChoice() {
        Menu menu = new Menu();
        return menu.ref_getChoice(this);
    }

    public void addBrand() {
        String brandID;
        String brandName;
        String soundBrand;
        double price;

        //id's brand
        do {
            System.out.print("Enter ID's brand: ");
            brandID = sc.nextLine();
            if (brandID.length() < 1) {
                System.err.println("ID's brand cannot be blank");
            }
            if (searchID(brandID) >= 0) {
                System.err.println("Brand ID is duplicated");
            }
        } while (brandID.length() < 1 || searchID(brandID) >= 0);

        //brand name
        do {
            System.out.print("Enter name's brand: ");
            brandName = sc.nextLine();
            if (brandName.length() < 1) {
                System.err.println("Brand name cannot be blank");
            }
        } while (brandName.length() < 1);

        //sound brand
        do {
            System.out.print("Enter sound's brand: ");
            soundBrand = sc.nextLine();
            if (soundBrand.length() < 1) {
                System.err.println("Sound brand cannot be blank");
            }
        } while (soundBrand.length() < 1);

        //price
        do {
            System.out.print("Enter price: ");
            try {
                price = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.err.println(e.getMessage());
                price = -1;
            }
            if (price < 0) {
                System.err.println("Price must be larger than 0.");
            }
        } while (price <= 0);
        Brand br = new Brand(brandID, brandName, soundBrand, price);
        this.add(br);
        System.err.println("Brand is added.");
    }

    public void updateBrand() {
        System.out.print("Enter ID's brand: ");
        String ID = sc.nextLine();
        int pos = searchID(ID);
        if (pos < 0) {
            System.err.println("Not Found!");
        } else {
            String brandName;
            String soundBrand;
            double price;

            //update name brand
            do {
                System.out.print("Enter name's brand: ");
                brandName = sc.nextLine();
                if (brandName.length() < 1) {
                    System.err.println("Brand name cannot be blank");
                }
            } while (brandName.length() < 1);

            //update sound brand
            do {
                System.out.print("Enter sound's brand: ");
                soundBrand = sc.nextLine();
                if (soundBrand.length() < 1) {
                    System.err.println("Sound brand cannot be blank");
                }
            } while (soundBrand.length() < 1);

            //update price
            do {
                System.out.print("Enter price: ");
                try {
                    price = Double.parseDouble(sc.nextLine());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    price = -1;
                }
                if (price < 0) {
                    System.err.println("Price must be larger than 0.");
                }
            } while (price <= 0);
            this.get(pos).setBrandName(brandName);
            this.get(pos).setSoundBrand(soundBrand);
            this.get(pos).setPrice(price);
            System.err.println("Brand having ID " + ID + " is updated.");
        }
    }

    public void listBrands() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + this.get(i));
        }
    }

}
