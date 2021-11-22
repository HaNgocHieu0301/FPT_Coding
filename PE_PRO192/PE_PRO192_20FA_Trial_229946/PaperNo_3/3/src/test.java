
import java.util.*;


/**
 *
 * @author ADMIN
 */
public class test {
    public static void main(String[] args) {
        MyCar t = new MyCar();
        List<Car> lst = new ArrayList<>();
        Car[] lstCar = new Car[8];
        lstCar[0] = new Car("A",3);
        lstCar[1] = new Car("B",7);
        lstCar[2] = new Car("C",6);
        lstCar[3] = new Car("D",7);
        lstCar[4] = new Car("E",6);
        //lstCar[5] = new Car("F",3);
        //lstCar[6] = new Car("G",2);
        //lstCar[7] = new Car("H",1);
        for(int i = 0; i<=7; i++){
            lst.add(lstCar[i]);
        }
        t.f2(lst);
        System.out.println(lst);
    }
}
