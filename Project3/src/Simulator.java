import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Simulator Class
 *
 */
public class Simulator {

    public static void main(String[] args) {

       CarStorage carStorage = new CarStorage();
       ArrayList<Car> cars = carStorage.getCarsLeft();
       String licensePlate = cars.get(0).getLicensePlate();

       Set<Class<? extends CarDecorator>> extras = new HashSet<>();
       Car rentedCar = carStorage.requestCar(licensePlate,extras);


    }

}
