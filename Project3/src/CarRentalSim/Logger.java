package CarRentalSim;

import CarRentalSim.Cars.Car;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Store.RentalRecord;
import CarRentalSim.Store.Store;

import java.util.ArrayList;

/**
 * Class -> CarRentalSim.Logger
 */

public class Logger implements Observer {

    private Store store;
    private Simulator simulator;

    public Logger(Simulator simulator){
        this.simulator = simulator;
    }

    public void startObserving(Store store){
        this.store = store;
        this.store.registerObserver(this);
    }

    public void finishObserving(){
        this.store.removeObserver(this);
        this.store = null;
    }

    // TODO: Finish Simulate and store.close
    @Override
    public void update() {
        if (!this.store.isOpen()) {
            if(Simulator.getCurrentDay() >= this.simulator.getFinalDay()) {
                this.finalLog();
            } else {
                this.dailyLog();
            }
        }
    }

    // TODO: Create output logs
    private void dailyLog(){
        int dayNumber = Simulator.getCurrentDay();
        ArrayList<RentalRecord> completedRentals = new ArrayList<>();
        ArrayList<RentalRecord> activeRentals = new ArrayList<>();

        // get and sort active/completed records
        for(RentalRecord rentalRecord : this.store.getAllRentals())  {
            if(rentalRecord.isActive()){
                activeRentals.add(rentalRecord);
            } else {
                completedRentals.add(rentalRecord);
            }
        }

        ArrayList<Car> carsLeft = this.store.getCarsAvailable();
        double dailyRevenue = this.store.getDailyRevenue();

        // print data TODO: Do we need to save this info to a file?
        System.out.println(String.format("Day: %d", dayNumber));

        System.out.println("=================================================================");

        // completed rentals
        System.out.println(String.format("There are %d completed car rentals", completedRentals.size()));
        // TODO: maybe create a function to print the info of a rental record inside RentalRecord class
        for (RentalRecord rentalRecord: completedRentals) {
            this.printRentalRecord(rentalRecord);
        }

        // Active rentals
        System.out.println(String.format("There are %d active car rentals", activeRentals.size()));
        // TODO: maybe create a function to print the info of a rental record inside RentalRecord class
        for (RentalRecord rentalRecord: activeRentals) {
           this.printRentalRecord(rentalRecord);
        }

        System.out.println(String.format("There are %d cars still available", this.store.getCarsAvailable().size()));
        for (Car car : this.store.getCarsAvailable()){
            System.out.println(String.format("License Plate: %s", car.getLicensePlate()));
        }

        System.out.println("-----------------------------------------------------------------");

        System.out.println(String.format("The store made %.2f dollars today", this.store.getDailyRevenue()));

        System.out.println("=================================================================");

    }

    private void printRentalRecord(RentalRecord rentalRecord){
        Customer customer = rentalRecord.getCustomer();
        System.out.println(String.format("Rental Record: %d", System.identityHashCode(rentalRecord)));
        System.out.println(String.format("Customer Type: %s", customer.getClass().getSimpleName()));
        System.out.println("Cars rented:");
        System.out.println("");
        for(Car car : rentalRecord.getCars()){
            System.out.println(String.format("License Place: %s", car.getLicensePlate()));
            // TODO: Print extras added to the car
            System.out.println("");
        }
        System.out.println(String.format("Duration: %d", rentalRecord.getDuration()));
        System.out.println(String.format("Total Fee: %.2f", rentalRecord.getCost()));
        System.out.println("-----------------------------------------------------------------");
    }

    // TODO: Create output logs
    private void finalLog(){
        int dayNumber = Simulator.getCurrentDay();
        ArrayList<RentalRecord> rentalRecords = this.store.getAllRentals();
        double totalStoreRevenue = this.store.getRevenue();

        System.out.println(String.format("Day: %d ( the final day )", dayNumber));

        System.out.println("-----------------------------------------------------------------");

        for(RentalRecord rentalRecord : rentalRecords){
           this.printRentalRecord(rentalRecord);
        }

        System.out.println(String.format("Total Store Revenue %f", totalStoreRevenue));

        System.out.println("=================================================================");
    }
}
