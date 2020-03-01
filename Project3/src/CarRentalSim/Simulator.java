package CarRentalSim;

import CarRentalSim.Cars.Creation.CarStorage;
import CarRentalSim.Customers.BusinessCustomer;
import CarRentalSim.Customers.CasualCustomer;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Customers.RegularCustomer;
import CarRentalSim.Store.Store;

/**
 * CarRentalSim.Simulator Class
 */
public class Simulator {

    private Store store;
    private static int currentDay;
    private int FINALDAY = 35;

    /**
     * Sets up and starts simulation
     * @param args
     */
    public static void main(String[] args) {

        Simulator simulator = new Simulator();
        simulator.setup();
        simulator.simulate();

    }

    /**
     * assumption: People/things inherently know what day and don't need to ask for the day. This is why this method is static
     * @return (int) currentDay - The current day in the simulation
     */
    public static int getCurrentDay(){
        return currentDay;
    }

    /**
     * Used to find out when the simulation ends
     * assumption: This function is not static because people/things don't inherently know when the world is going to end ( our simulation's end )
     * @return (int) FINALDAY - The last day of the simulation
     */
    public int getFinalDay() {
        return FINALDAY;
    }

    /**
     * Creates all objects that are part of the simulation:
     *  - 1 store
     *  - 12 customers
     *    - 4 casual customers
     *    - 4 regular customers
     *    - 4 business customers
     *  - 1 logger
     *  - 1 car storage
     */
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

        // Logger
        Logger logger = new Logger(this);
        logger.startObserving(store);

        // CarStorage
        CarStorage carStorage = new CarStorage();
        store.setCarStorage(carStorage);

    }

    /**
     * Runs the simulation for a set number of days ( this.FINALDAY )
     *  - opening the store
     *  - closing the store
     *  - incrementing the current day
     */
    private void simulate(){
        for(this.currentDay = 0; this.currentDay <= this.FINALDAY; this.currentDay++) {
            this.store.open();
            this.store.close();
        }
    }

}
