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

public class BusinessCustomer extends Customer {

    /**
     *  Rents 3 cars for 7 nights
     *   - 10% chance to add satellite radio ( most business people believe music is a waste of time )
     *   - 70% chance to add a GPS ( they must work as efficiently as possible )
     *   - 0% chance to add a car seat ( kinda weird to bring a child on a business trip )
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
            Set<Class<? extends CarDecorator>> extras = new HashSet<>();

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
