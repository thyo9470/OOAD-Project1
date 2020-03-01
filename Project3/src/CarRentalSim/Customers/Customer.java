package CarRentalSim.Customers;

import CarRentalSim.Cars.Car;
import CarRentalSim.Observer;
import CarRentalSim.Store.RentalRecord;
import CarRentalSim.Store.Store;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public abstract class Customer implements Observer {
    // TODO: give a way to identify customers
    protected Store store;
    protected static Random rand = new Random();

    public void startObserving(Store store){
        this.store = store;
        this.store.registerObserver(this);
    }

    public void finishObserving(){
        this.store.removeObserver(this);
        this.store = null;
    }

    @Override
    public void update(){
        if(this.store.isOpen()){
            this.checkRentals();
            this.rent();
        }
    }

    private void checkRentals(){
        ArrayList<RentalRecord> rentals = this.store.getCustomerRentals(this);
        for (RentalRecord rentalRecord: rentals) {
            if(rentalRecord.getDaysLeft() == 0){
                this.store.returnCar(this);
            }
        }
    }

    // TODO: make NUMCARS not constent across rentals
    // TODO: add extras for customers
    // TODO: maybe make unique version of this function for each of the customer types?
    abstract protected void rent();
    /*protected void rent(){
        ArrayList<Car> carsAvailable = this.store.getCarsAvailable();
        Random rand = new Random();
        // 50% chance to rent a car if there are enough available
        if(carsAvailable.size() > this.NUMCARS && rand.nextDouble() < 0.5) {
            // Get the license plate for each car they want to rent
            ArrayList<String> licencePlates = new ArrayList<>();
            for (Car car: carsAvailable.subList(0,this.NUMCARS)) {
              licencePlates.add(car.getLicensePlate());
            }
            this.store.rentCar(this, this.NUMNIGHTS, licencePlates);
        }
    }*/
}
