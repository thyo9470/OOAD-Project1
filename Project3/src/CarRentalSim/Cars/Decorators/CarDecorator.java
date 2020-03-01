package CarRentalSim.Cars.Decorators;

import CarRentalSim.Cars.Car;

/**
 * Abstract class for Decorator Pattern
 *
 * Meant for adding more features to car rentals
 */
public abstract class CarDecorator extends Car {

   @Override
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
