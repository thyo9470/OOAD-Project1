package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

public class GPS extends CarDecorator{

    Car car;

    public GPS(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        return this.car.getDescription() + " (GPS) ";
    }

    @Override
    public Car getBaseCar() {
        return car.getBaseCase();
    }

    public double getCost() {
        throw new UnsupportedOperationException("Implement getCost");
    }
}
