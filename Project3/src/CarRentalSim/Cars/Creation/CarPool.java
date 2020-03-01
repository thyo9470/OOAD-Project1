package CarRentalSim.Cars.Creation;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;

import java.util.ArrayList;

/**
 * Interface to implement Object Pool Pattern
 */
public interface CarPool {
    void populate();
    Car requestCar(String licensePlate, ArrayList<Class<? extends CarDecorator>> extras);
    void returnCar(Car car);
}
