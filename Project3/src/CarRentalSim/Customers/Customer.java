package CarRentalSim.Customers;

import CarRentalSim.Cars.Car;
import CarRentalSim.Observer;
import CarRentalSim.Store.RentalRecord;
import CarRentalSim.Store.Store;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public abstract class Customer implements Observer {
    private Store store;
    private final int NUMCARS;
    private final int NUMNIGHTS;
    protected static Random rand = new Random();

    public Customer(int NUMCARS, int NUMNIGHTS) {
        this.NUMCARS = NUMCARS;
        this.NUMNIGHTS = NUMNIGHTS; }

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
    private void rent(){
        ArrayList<Car> carsAvailable = this.store.getCarsAvailable();
        Random rand = new Random();
        if(carsAvailable.size() > this.NUMCARS && rand.nextDouble() < 0.5) {
            ArrayList<String> licencePlates = new ArrayList<>();
            for(int i = 0; i < this.NUMCARS; i++){
                licencePlates.add(carsAvailable.get(i).getLicensePlate());
            }
            this.store.rentCar(this, this.NUMNIGHTS, licencePlates);
        }
    }
}
