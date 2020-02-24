package CarRentalSim.Cars.Creation;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;

import java.util.Set;

/**
 * Interface to implement factory pattern -> CarRentalSim.Cars.Creation.CarPool
 */
public interface CarPool {
    void populate();
    Car requestCar(String licensePlate, Set<Class<? extends CarDecorator>> extras);
    void returnCar(Car car);
}
