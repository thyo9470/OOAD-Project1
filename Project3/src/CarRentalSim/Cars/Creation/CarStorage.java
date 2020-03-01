package CarRentalSim.Cars.Creation;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;
import CarRentalSim.Cars.Types.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 *  Acts as concrete factory and concrete object pool
 */
public class CarStorage implements CarPool, CarFactory {

    private ArrayList<Car> cars;

    public CarStorage(){
        this.cars = new ArrayList<>();
        this.populate();
    }

    public ArrayList<Car> getCarsLeft(){
        return this.cars;
    }

    /**
     * Retrieves car from object pool, adds extras, returns request car
     *
     * @param licensePlate:String - the license plate of the desired car
     * @param extras:ArrayList<Class<? extends CarDecorator>> - A list of CarDecorator class objects to specify what extra features a customer wants for a rental
     * @return Car: The request car with extras added on
     */
    @Override
    public Car requestCar(String licensePlate, ArrayList<Class<? extends CarDecorator>> extras) {

        // Retrieve car from storage
        Car requestedCar = null;
        for (Car car: this.cars) {
            if (car.getLicensePlate() == licensePlate) {
                requestedCar = car;
                break;
            }
        }
        this.cars.remove(requestedCar);

        // Add requested extras
        for (Class<? extends CarDecorator> extra:extras) {
            try {
                requestedCar = extra.getConstructor(Car.class).newInstance(requestedCar);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return requestedCar;
    }

    /**
     * Removes extras from the returned car and adds it back to the object pool
     * @param car:Car
     */
    @Override
    public void returnCar(Car car) {
        Car baseCar = car.getBaseCar();
        this.cars.add(baseCar);
    }

    /**
     * Creates a new car of a given type, assigns it the given license plate number, and returns it
     *
     * @param carType:Class<? extends Car> - The type of car to create ( ie Economy.class )
     * @param licensePlate:String
     * @return Car: a new car instance of the given type with the given license plate
     */
    public Car createCar(Class<? extends Car> carType, String licensePlate){
        Car newCar = null;
        try {
            newCar = carType.getConstructor(String.class).newInstance(licensePlate);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return newCar;
    }

    /**
     * Fills the car storage with 24 cars
     *  - 5 Economy
     *  - 5 Minivans
     *  - 5 Standard
     *  - 5 SUV
     *  - 4 Luxury
     *
     *  License plates are just integers starting at 1000
     *  TODO: Do we want to make this more complicated?
     */
    @Override
    public void populate() {
        int licensePlate = 1000;
        for(int i = 0; i < 4; i++){
            this.cars.add(this.createCar(Economy.class, Integer.toString(++licensePlate)));
            this.cars.add(this.createCar(Minivan.class, Integer.toString(++licensePlate)));
            this.cars.add(this.createCar(Standard.class, Integer.toString(++licensePlate)));
            this.cars.add(this.createCar(SUV.class, Integer.toString(++licensePlate)));
            this.cars.add(this.createCar(Luxury.class, Integer.toString(++licensePlate)));
        }
        this.cars.add(this.createCar(Economy.class, Integer.toString(++licensePlate)));
        this.cars.add(this.createCar(Minivan.class, Integer.toString(++licensePlate)));
        this.cars.add(this.createCar(Standard.class, Integer.toString(++licensePlate)));
        this.cars.add(this.createCar(SUV.class, Integer.toString(++licensePlate)));
    }
}
