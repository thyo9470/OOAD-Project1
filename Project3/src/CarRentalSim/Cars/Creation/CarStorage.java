package CarRentalSim.Cars.Creation;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Decorators.CarDecorator;
import CarRentalSim.Cars.Types.Minivan;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Class -> CarRentalSim.Cars.Creation.CarStorage
 *  Acts as concrete factor and concrete object pool
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

    @Override
    public Car requestCar(String licensePlate, Set<Class<? extends CarDecorator>> extras) {

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

    @Override
    public void returnCar(Car car) {
        Car baseCar = car.getBaseCar();
        this.cars.add(baseCar);
    }

    public Car createCar(Class<? extends Car> carType, String licensePlate){
        Car newCar = null;
        try {
            newCar = carType.getConstructor(String.class).newInstance(licensePlate);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return newCar;
    }

    @Override
    public void populate() {
        int licensePlate = 1000;
        for(int i = 0; i < 24; i++){
            this.cars.add(this.createCar(Minivan.class, Integer.toString(++licensePlate)));
        }
    }
}
