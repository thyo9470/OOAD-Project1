package CarRentalSim.Customers;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;
import CarRentalSim.Cars.Decorators.GPS;
import CarRentalSim.Cars.Decorators.SatelliteRadio;

import java.util.ArrayList;
import java.util.Random;

/**
 * For business customers efficiency comes before fun
 */
public class BusinessCustomer extends Customer {

    /**
     *  Rents 3 cars for 7 nights
     *   - 10% Chance to add satellite radio ( most business people believe music is a waste of time )
     *   - 70% Chance to add a GPS ( they must work as efficiently as possible )
     *   -  0% Chance to add a car seat ( kinda weird to bring a child on a business trip )
     */
    @Override
    protected void rent() {
        ArrayList<Car> carsAvailable = this.store.getCarsAvailable();
        Random rand = new Random();

        // Business customers can only rent 3 cars for 7 nights
        int numCars = 3;
        int numNights = 7;

        // 50% chance to rent a car if there are enough available
        if(carsAvailable.size() > numCars && rand.nextDouble() < 0.5) {
            // Get the license plate for each car they want to rent
            ArrayList<String> licencePlates = new ArrayList<>();
            for (Car car: carsAvailable.subList(0,numCars)) {
                licencePlates.add(car.getLicensePlate());
            }

            // Select the extra features customer wants
            ArrayList<Class<? extends CarDecorator>> extras = new ArrayList<>();

            if(rand.nextDouble() < 0.1){
                extras.add(SatelliteRadio.class);
            }

            if(rand.nextDouble() < 0.7){
                extras.add(GPS.class);
            }

            this.store.rentCar(this, numNights, licencePlates, extras);
        }
    }
}
