
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class CarManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String brandpath = "brands.txt";
        String carpath = "cars.txt";
        ArrayList<String> opts = new ArrayList<>();
        opts.add("List all brands");
        opts.add("Add a new brand");
        opts.add("Search a brand based on its ID");
        opts.add("Update a brand");
        opts.add("Save brands to the file, named brands.txt");
        opts.add("List all cars in ascending order of brand names");
        opts.add("List cars based on a part of an input brand name");
        opts.add("Add a car");
        opts.add("Remove a car based on its ID");
        opts.add("Update a car based on its ID");
        opts.add("Save cars to file, named cars.txt");
        opts.add("Exit.");

        BrandList brandList = new BrandList();
        brandList.loadFromFile(brandpath);
        CarList carList = new CarList(brandList);
        carList.loadFromFile(carpath);
        int choice;
        Menu menu = new Menu();
        do{
            System.out.println("==========Menu===========");
            choice = menu.int_getChoice(opts);
            switch(choice){
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    brandList.displayBySearchID();
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile(brandpath);
                    break;
                case 6:             
                    carList.listCars();
                    break;
                case 7:
                    carList.printBasedBrandName();
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                    carList.removeCar();
                    break;
                case 10:
                    carList.updateCar();
                    break;
                case 11:
                    carList.saveToFile(carpath);
                    break;
                case 12:
                    System.exit(0);
            }
        }while(true);

    }

}
