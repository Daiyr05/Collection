package carproject;

public class Car implements Comparable<Car> {
    private String Brand;
    private int number;

    public Car(String brand, int number) {
        Brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Car o) {
        return this.Brand.compareTo(o.getBrand());
    }


}
