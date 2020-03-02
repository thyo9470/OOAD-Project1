package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

/**
 * Decorator for car to add a Car Seat
 */
public class SatelliteRadio extends CarDecorator {

    final private int COST = 30;
    final private int NIGHTLYCOST = 0;

    public SatelliteRadio(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + "(Satellite Radio)";
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
