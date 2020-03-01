package CarRentalSim.Customers;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;
import CarRentalSim.Cars.Decorators.CarSeat;
import CarRentalSim.Cars.Decorators.GPS;
import CarRentalSim.Cars.Decorators.SatelliteRadio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RegularCustomer extends Customer {

   /**
    * Rents 1-3 cars for 3-5 nights
    *  - 50% chance to add satellite radio
    *  - 50% chance to add GPS
    *  - 50% chance to add a car seat
    */
   @Override
   protected void rent() {
      ArrayList<Car> carsAvailable = this.store.getCarsAvailable();
      Random rand = new Random();

      // Regular customers can rent 1-3 cars for 3-5 nights
      int numCars = rand.nextInt(3)+1;
      int numNights = rand.nextInt(3)+3;

      // 50% chance to rent a car if there are enough available
      if(carsAvailable.size() > numCars && rand.nextDouble() < 0.5) {
         // Get the license plate for each car they want to rent
         ArrayList<String> licencePlates = new ArrayList<>();
         for (Car car: carsAvailable.subList(0,numCars)) {
            licencePlates.add(car.getLicensePlate());
         }

         // Select the extra features customer wants
         Set<Class<? extends CarDecorator>> extras = new HashSet<>();

         if(rand.nextDouble() < 0.5){
            extras.add(SatelliteRadio.class);
         }

         if(rand.nextDouble() < 0.5){
            extras.add(GPS.class);
         }

         if(rand.nextDouble() < 0.5){
            extras.add(CarSeat.class);
         }

         this.store.rentCar(this, numNights, licencePlates, extras);
      }
   }

}
