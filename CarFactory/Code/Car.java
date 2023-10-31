public class Car {

    private String carType;
    private int year;
    private String color;
    private int miles;

    public Car(){

    }
    public Car(String carTypes, int carYear, String carColor, int carMiles){
        this.carType = carTypes;
        this.year = carYear;
        this.color = carColor;
        this.miles = carMiles;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String toString(){
        return carType+","+year+","+color+","+miles;
    }



}
