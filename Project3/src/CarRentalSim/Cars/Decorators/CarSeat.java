package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

/**
 * Decorator for car to add a Car Seat
 */
public class CarSeat extends CarDecorator {

    final private int COST = 10;
    final private int NIGHTLYCOST = 3;

    public CarSeat(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + "(Car Seat)";
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
    public double getNightlyCost() {
        return car.getNightlyCost() + this.NIGHTLYCOST;
    }
}
