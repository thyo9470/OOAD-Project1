package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

/**
 * Decorator Class -> CarRentalSim.Cars.Decorators.CarDecorator
 */
public abstract class CarDecorator extends Car {

   public abstract String getDescription();

   public abstract Car getBaseCar();

}
