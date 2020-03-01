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
        // TODO: Change this back to 4 iterations and not 1
        for(int i = 0; i < 1; i++){
            Customer newCasualCustomer = new CasualCustomer();
            newCasualCustomer.startObserving(store);

            Customer newRegularCustomer = new RegularCustomer();
            newRegularCustomer.startObserving(store);

            Customer newBusinessCustomer = new BusinessCustomer();
            newBusinessCustomer.startObserving(store);
        }
        for(int i = 0; i < 4; i++){
        }
        for(int i = 0; i < 4; i++){
        }

        // Logger
        Logger logger = new Logger(this);
        logger.startObserving(store);

        // CarStorage
        CarStorage carStorage = new CarStorage();
        store.setCarStorage(carStorage);

    }

    private void simulate(){
        for(int i = 0; i < this.FINALDAY; i++) {
            this.store.open();
            this.store.close();
            this.currentDay++;
        }
    }

}
