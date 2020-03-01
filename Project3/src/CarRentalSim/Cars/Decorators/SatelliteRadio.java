package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;

public class SatelliteRadio extends CarDecorator {

    Car car;

    public SatelliteRadio(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + "(Satellite Radio)";
    }

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
