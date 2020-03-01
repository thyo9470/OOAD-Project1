package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

/**
 * Decorator for car to add a Car Seat
 */
public class SatelliteRadio extends CarDecorator {

    Car car;

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
        // TODO: set cost
        return car.getCost() + 10;
    }

    @Override
    public double getNightlyCost(){
        // TODO: set nightly cost
        return car.getNightlyCost() + 1;
    }
}
