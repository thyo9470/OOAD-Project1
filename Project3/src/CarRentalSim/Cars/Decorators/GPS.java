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
