package CarRentalSim.Cars.Creation;

import CarRentalSim.Cars.Car;

/**
 * Interface to implement factory pattern -> CarRentalSim.Cars.Creation.CarFactory
 */
public interface CarFactory {

    Car createCar(Class<? extends Car> carType, String licensePlate);

}
