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
        Car returnCar = null;
        for (Car car: this.cars) {
            if (car.getLicensePlate() == licensePlate) {
                returnCar = car;
                break;
            }
        }
        this.cars.remove(returnCar);

        for (Class<? extends CarDecorator> extra:extras) {
            try {
                returnCar = extra.getConstructor(Car.class).newInstance(returnCar);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return returnCar;
    }

    @Override
    public void returnCar(Car car) {
        Car baseCar = car.getBaseCase();
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

        this.cars.add(this.createCar(Minivan.class, "1234"));
        this.cars.add(this.createCar(Minivan.class, "6789"));

    }
}
