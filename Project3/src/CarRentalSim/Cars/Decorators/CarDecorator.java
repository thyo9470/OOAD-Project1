package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

/**
 * Decorator Class -> CarRentalSim.Cars.Decorators.CarDecorator
 */
public abstract class CarDecorator extends Car {

   public abstract String getDescription();

   @Override
   public abstract Car getBaseCar();

   @Override
   public abstract double getCost();

   @Override
   public abstract double getNightlyCost();

   @Override
   public String getLicensePlate() {
      return this.getBaseCar().getLicensePlate();
   }

}
