package pl.com.goodsolution.course.course;

public class Car {
    private int power;
    private String plateNumber;

    public Car(int power, String plateNumber) {
        this.power = power;
        this.plateNumber = plateNumber;
    }

    public int getPower() {
        return power;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
