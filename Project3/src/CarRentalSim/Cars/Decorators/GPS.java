package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

/**
 * Decorator for car to add a GPS
 */
public class GPS extends CarDecorator{

    final private int COST = 50;
    final private int NIGHTLYCOST = 10;

    public GPS(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        return this.car.getDescription() + " (GPS) ";
    }

    /**
     *  Retrieves the base car that has no extras added on
     * @return reference to the base car without any extras
     */
    @Override
    public Car getBaseCar() {
        return car.getBaseCar();
    }

    @Override
    public double getCost() {
        return car.getCost() + this.COST;
    }

    @Override
    public double getNightlyCost(){
        return car.getNightlyCost() + this.NIGHTLYCOST;
    }
}
