import java.util.Set;

/**
 * Interface to implement factory pattern -> CarFactory
 */
public interface CarFactory {

    Car createCar(Class<? extends Car> carType, String licensePlate);

}
