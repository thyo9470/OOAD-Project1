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
        throw new UnsupportedOperationException("implement get description");
    }

    @Override
    public Car getBaseCar() {
        return car.getBaseCase();
    }

    public double getCost() {
        throw new UnsupportedOperationException("Implement getCost");
    }
}
