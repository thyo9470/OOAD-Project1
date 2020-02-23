/**
 * Abstract Class -> Car
 */
abstract class Car {

    private String description;
    private String licensePlate;
    private double cost;

    public Car(){}

    public Car(String description, String licensePlate, double cost){
        this.description = description;
        this.licensePlate = licensePlate;
        this.cost = cost;
    }

    public Car getBaseCase(){ return this; }

    public String getDescription() {
        return description;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getCost() {
        return cost;
    }
}
