package CarRentalSim;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;
import CarRentalSim.Cars.Creation.CarStorage;
import CarRentalSim.Cars.Decorators.GPS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * CarRentalSim.Simulator Class
 *
 */
public class Simulator {

    public static void main(String[] args) {

       CarStorage carStorage = new CarStorage();
       ArrayList<Car> cars = carStorage.getCarsLeft();
       String licensePlate = cars.get(0).getLicensePlate();

       Set<Class<? extends CarDecorator>> extras = new HashSet<>();
       extras.add(GPS.class);
       Car rentedCar = carStorage.requestCar(licensePlate,extras);

       System.out.println(rentedCar.getDescription());
    }

}
