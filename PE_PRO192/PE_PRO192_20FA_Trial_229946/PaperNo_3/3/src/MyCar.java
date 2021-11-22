
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 *
 * @author ADMIN
 */
public class MyCar implements ICar {

    @Override
    public int f1(List<Car> t) {
        int sum = 0;
        for (Car x : t) {
            sum += x.getRate();
        }
        return sum / t.size();
    }

    @Override
    public void f2(List<Car> t) {
        int max = Integer.MIN_VALUE;
        int index_max = -1;
        int min = Integer.MAX_VALUE;
        int index_min = -1;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getRate() > max) {
                max = t.get(i).getRate();
                index_max = i;
            }
            if (t.get(i).getRate() < max) {
                min = t.get(i).getRate();
                index_min = i;
            }
        }    
          //c2:
            Collections.swap(t, index_min, index_max);
          //c3:
//            Car tmp = t.get(index_min);
//            t.set(index_min, t.get(index_max));
//            t.set(index_max, tmp);
         
    }

    @Override
    //cach 1 cua thay
    public void f3(List<Car> t) {
        t.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if(o1.getMaker().compareTo(o2.getMaker()) > 0){
                    return 1;
                }else if(o1.getMaker().compareTo(o2.getMaker()) < 0){
                    return -1;
                }
                if(o1.getRate() > o2.getRate()){
                    return -1;
                }else
                  return 1;
            }
        });

        //cach tu lam
//        for (int i = 0; i < t.size() - 1; i++) {
//            for (int j = i; j < t.size(); j++) {
//                if (t.get(i).getMaker().compareToIgnoreCase(t.get(j).getMaker()) > 0) { 
//                    Collections.swap(t, i, j);
////                    t.add(t.get(i));
////                    t.set(i, t.get(j));
////                    t.set(j, t.get(t.size() - 1));
////                    t.remove(t.size() - 1);
//                } else if (t.get(i).getMaker().equalsIgnoreCase(t.get(j).getMaker())) {
//                    if (t.get(i).getRate() > t.get(j).getRate()) {
//                        Collections.swap(t, i, j);
////                        t.add(t.get(i));
////                        t.set(i, t.get(j));
////                        t.set(j, t.get(t.size() - 1));
////                        t.remove(t.size() - 1);
//                    }
//                }
//            }
//        }
        //c3 cua thay:
//        Collections.sort(t, new Comparator<Car>() {
//            @Override
//            public int compare(Car o1, Car o2) {
//                if (o1.getMaker().compareTo(o2.getMaker()) > 0) {
//                    return 1;
//                } else if (o1.getMaker().compareTo(o2.getMaker()) < 0) {
//                    return -1;
//                }
//                if (o1.getRate() > o2.getRate()) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//
//        });

        //output4

    }

}
