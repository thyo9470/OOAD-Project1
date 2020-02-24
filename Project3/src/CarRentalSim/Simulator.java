package CarRentalSim;

import CarRentalSim.Cars.Creation.CarStorage;
import CarRentalSim.Customers.BusinessCustomer;
import CarRentalSim.Customers.CasualCustomer;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Customers.RegularCustomer;
import CarRentalSim.Store.Store;

/**
 * CarRentalSim.Simulator Class
 *
 */
public class Simulator {

    private Store store;
    private static int currentDay;
    private int FINALDAY = 36;

    public static void main(String[] args) {

        Simulator simulator = new Simulator();
        simulator.setup();
        simulator.simulate();
        System.out.println("Works so far");

    }

    public static int getCurrentDay(){
        return currentDay;
    }

    public int getFinalDay() {
        return FINALDAY;
    }

    private void setup(){
        Simulator.currentDay = 1;

        // Store
        Store store = new Store();
        this.store = store;

        // Customers
        for(int i = 0; i < 4; i++){
            Customer newCustomer = new CasualCustomer();
            newCustomer.startObserving(store);
        }
        for(int i = 0; i < 4; i++){
            Customer newCustomer = new RegularCustomer();
            newCustomer.startObserving(store);
        }
        for(int i = 0; i < 4; i++){
            Customer newCustomer = new BusinessCustomer();
            newCustomer.startObserving(store);
        }

        // Logger
        Logger logger = new Logger(this);
        //logger.startObserving(store); TODO: subscribe

        // CarStorage
        CarStorage carStorage = new CarStorage();
        store.setCarStorage(carStorage);

    }

    private void simulate(){
        this.store.open();
    }

}
