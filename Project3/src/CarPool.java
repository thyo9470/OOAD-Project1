import java.util.Set;

/**
 * Interface to implement factory pattern -> CarPool
 */
public interface CarPool {
    void populate();
    Car requestCar(String licensePlate, Set<Class<? extends CarDecorator>> extras);
    void returnCar(Car car);
}
