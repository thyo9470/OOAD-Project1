package CarRentalSim;

import CarRentalSim.Cars.Car;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Store.RentalRecord;
import CarRentalSim.Store.Store;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Logger acts as an Observer for Observer Pattern
 *
 * Logs the store's activity during the simulation and the final report on the last day
 *  - Reports at the end of the day when the shop closes
 *  - Observer in Observer pattern. Observers a store
 */
public class Logger implements Observer {

    private Store store;

    public void startObserving(Store store){
        this.store = store;
        this.store.registerObserver(this);
    }

    public void finishObserving(){
        this.store.removeObserver(this);
        this.store = null;
    }

    /**
     * Update for observer pattern
     *  - When store closes:
     *    - Prints the daily log
     *    - If it is the final day, print the final log
     */
    @Override
    public void update() {
        if (!this.store.isOpen()) {
            this.dailyLog();
        }
    }

    /**
     * Prints the daily activity of the observed store
     */
    private void dailyLog(){

        // Data we need to print
        int dayNumber = Simulator.getCurrentDay();
        ArrayList<RentalRecord> completedRentals = new ArrayList<>();
        ArrayList<RentalRecord> activeRentals = new ArrayList<>();

        // Get and sort active/completed records
        for(RentalRecord rentalRecord : this.store.getAllRentals())  {
            if(rentalRecord.isActive()){
                activeRentals.add(rentalRecord);
            } else {
                completedRentals.add(rentalRecord);
            }
        }

        ArrayList<Car> carsLeft = this.store.getCarsAvailable();
        double dailyRevenue = this.store.getDailyRevenue();

        System.out.println(String.format("Day: %d", dayNumber));

        System.out.println("=================================================================");

        // completed rentals
        System.out.println(String.format("There are %d completed car rentals", completedRentals.size()));
        for (RentalRecord rentalRecord: completedRentals) {
            Customer customer = rentalRecord.getCustomer();
            System.out.println(String.format("Customer ID: %d", System.identityHashCode(rentalRecord)));
            System.out.println(String.format("Customer Type: %s", customer.getClass().getSimpleName()));
            System.out.println(String.format("Rental Record ID: %d", System.identityHashCode(rentalRecord)));
            System.out.println("Cars rented:");
            System.out.println("");
            for(Car car : rentalRecord.getCars()){
                System.out.println(car.getDescription());
                System.out.println(String.format("License Plate: %s", car.getLicensePlate()));
                System.out.println("");
            }
            if(!rentalRecord.isActive()) {
                System.out.println(String.format("Duration: %d", rentalRecord.getDuration()));
                System.out.println(String.format("Total Fee: %.2f", rentalRecord.getCost()));
            }
            System.out.println("-----------------------------------------------------------------");
        }

        // Active rentals
        System.out.println(String.format("There are %d active car rentals", activeRentals.size()));
        for (RentalRecord rentalRecord: activeRentals) {
            Customer customer = rentalRecord.getCustomer();
            System.out.println(String.format("Customer ID: %d", System.identityHashCode(rentalRecord)));
            System.out.println(String.format("Customer Type: %s", customer.getClass().getSimpleName()));
            System.out.println(String.format("Rental Record ID: %d", System.identityHashCode(rentalRecord)));
            System.out.println("Cars rented:");
            System.out.println("");
            for(Car car : rentalRecord.getCars()){
                System.out.println(car.getDescription());
                System.out.println(String.format("License Plate: %s", car.getLicensePlate()));
                System.out.println("");
            }
            System.out.println("-----------------------------------------------------------------");
        }

        System.out.println(String.format("There are %d cars still available", carsLeft.size()));
        for (Car car : carsLeft){
            System.out.println(String.format("License Plate: %s", car.getLicensePlate()));
        }

        System.out.println("-----------------------------------------------------------------");

        System.out.println(String.format("The store made %.2f dollars today", dailyRevenue));

        System.out.println("=================================================================");

    }

    /**
     * Prints the final information of the store's activity during the simulation
     *  - Current Day
     *  - Total number of rentals
     *  - Distribution of rentals across customer types
     *  - The store's total revenue
     */
    public void finalLog(){
        int dayNumber = Simulator.getCurrentDay();
        ArrayList<RentalRecord> rentalRecords = this.store.getAllRentals();
        HashMap<String, Integer> customerTypeCounts = new HashMap<>();
        double totalStoreRevenue = this.store.getRevenue() + this.store.getDailyRevenue();

        System.out.println(String.format("Day: %d ( the final day )", dayNumber));

        System.out.println("=================================================================");

        for(RentalRecord rentalRecord : rentalRecords){
            Customer customer = rentalRecord.getCustomer();
            String customerType = customer.getClass().getSimpleName();
            if(customerTypeCounts.containsKey(customerType)){
                int newCount = customerTypeCounts.get(customerType) + 1;
                customerTypeCounts.put(customerType, newCount);
            } else {
                customerTypeCounts.put(customerType, 1);
            }
        }

        System.out.println(String.format("%d rentals were made in total with the following customer type distribution:", rentalRecords.size()));
        customerTypeCounts.forEach((k, v) -> {System.out.println(String.format("%s: %d", k, v));});

        System.out.println(String.format("Total Store Revenue %.2f", totalStoreRevenue));

        System.out.println("=================================================================");
    }
}
