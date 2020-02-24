package CarRentalSim.Customers;

import CarRentalSim.Observer;
import CarRentalSim.Store.Store;

import java.util.Random;

public abstract class Customer implements Observer {
    private Store store;
    private final int NUMCARS;
    private final int NUMNIGHTS;
    protected static Random rand = new Random();

    public Customer(int NUMCARS, int NUMNIGHTS) {
        this.NUMCARS = NUMCARS;
        this.NUMNIGHTS = NUMNIGHTS;
    }

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
            this.rent();
        }
    }

    private void rent(){
        if(this.store != null && this.store.isOpen()){
            this.store.rentCar(this, this.NUMCARS, this.NUMNIGHTS);
        }
    }
}
