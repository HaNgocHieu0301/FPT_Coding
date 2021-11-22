
/**
 *
 * @author ADMIN
 */
public class Car implements Comparable<Car>{
    private String carID;
    private Brand brand;
    private String color;
    private String frameID;
    private String engineID;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public int compareTo(Car o) {
        int d = this.getBrand().getBrandName().compareTo(o.getBrand().getBrandName());
        if(d > 0){
            return 1;
        }else if(d < 0){
            return -1;
        }else {
            return this.carID.compareTo(o.carID);
        }
    }
    @Override
    public String toString() {
        return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
        //< carID, brand.brandID, color, frameID, engineID>
    }  
    
    public String screenString(){
        return brand.getBrandName()+"\n"+carID+", "+color+", "+frameID+", "+engineID;
        //< brand, “\n”, car_ID, color, frameID, engineID>
    }
    
}
