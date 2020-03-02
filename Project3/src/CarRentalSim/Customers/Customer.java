package CarRentalSim.Customers;

import CarRentalSim.Observer;
import CarRentalSim.Store.RentalRecord;
import CarRentalSim.Store.Store;

import java.util.ArrayList;
import java.util.Random;


/**
 * Customer acts as an Observer for Observer Pattern
 */
public abstract class Customer implements Observer {
    protected Store store;

    public void startObserving(Store store){
        this.store = store;
        this.store.registerObserver(this);
    }

    public void finishObserving(){
        this.store.removeObserver(this);
        this.store = null;
    }

    /**
     * When store opens, customer will:
     *  - Check if it needs to make any returns
     *  - Possibly rent 1+ cars
     */
    @Override
    public void update(){
        if(this.store.isOpen()){
            this.checkRentals();
            this.rent();
        }
    }

    /**
     * Customer checks if any of their rentals are due
     *  - If yes, they will return them
     */
    private void checkRentals(){
        ArrayList<RentalRecord> rentals = this.store.getCustomerRentals(this);
        for (RentalRecord rentalRecord: rentals) {
            if(rentalRecord.getDaysLeft() == 0){
                this.store.returnCar(this);
            }
        }
    }

    abstract protected void rent();
}
