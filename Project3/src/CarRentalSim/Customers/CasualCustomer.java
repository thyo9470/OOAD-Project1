package CarRentalSim.Customers;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;
import CarRentalSim.Cars.Decorators.CarSeat;
import CarRentalSim.Cars.Decorators.GPS;
import CarRentalSim.Cars.Decorators.SatelliteRadio;

import java.util.ArrayList;
import java.util.Random;

/**
 * Casual customers are about enjoying themselves and having a relaxed ride
 */
public class CasualCustomer extends Customer {

    /**
     * Rents 1 car for 1-3 nights
     *  - 90% Chance to add satellite radio ( no better way to enjoy a car ride then some tunes )
     *  - 25% Chance to add a GPS ( it's not about the destination, but the journey )
     *  - 50% Chance to add a car seat ( day trips with the family are always fun )
     *    - Will rent 1 - 4 car seats
     */
    @Override
    protected void rent() {
        ArrayList<Car> carsAvailable = this.store.getCarsAvailable();
        Random rand = new Random();

        // CasualCustomers can rent 1 car for 1-3 nights
        int numCars = 1;
        int numNights = rand.nextInt(3)+1;

        // 50% chance to rent a car if there are enough available
        if(carsAvailable.size() > numCars && rand.nextDouble() < 0.5) {
            // Get the license plate for each car they want to rent
            ArrayList<String> licencePlates = new ArrayList<>();
            for (Car car: carsAvailable.subList(0,numCars)) {
                licencePlates.add(car.getLicensePlate());
            }

            // Select the extra features customer wants
            ArrayList<Class<? extends CarDecorator>> extras = new ArrayList<>();

            if(rand.nextDouble() < 0.9){
                extras.add(SatelliteRadio.class);
            }

            if(rand.nextDouble() < 0.25){
                extras.add(GPS.class);
            }

            if(rand.nextDouble() < 0.5){
                int numSeats = rand.nextInt(3) + 1;
                for (int i = 0; i < numSeats; i++) {
                    extras.add(CarSeat.class);
                }
            }

            this.store.rentCar(this, numNights, licencePlates, extras);
        }
    }

}
