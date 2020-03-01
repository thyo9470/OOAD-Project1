package CarRentalSim.Cars.Creation;

import CarRentalSim.Cars.Car;

/**
 * Interface to implement Factory Pattern
 */
public interface CarFactory {

    Car createCar(Class<? extends Car> carType, String licensePlate);

}
