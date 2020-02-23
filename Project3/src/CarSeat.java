public class CarSeat extends CarDecorator {

    Car car;

    public CarSeat(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("implement get description");
    }

    @Override
    public Car getBaseCar() {
        return car.getBaseCase();
    }

    public double getCost() {
       throw new UnsupportedOperationException("Implement getCost");
    }
}
