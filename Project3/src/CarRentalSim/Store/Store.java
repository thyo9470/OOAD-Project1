package CarRentalSim.Store;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Creation.CarStorage;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Subject;

import java.util.ArrayList;

/**
 *  CarRentalSim.Store.Store acts as the CarRentalSim.Subject for CarRentalSim.Observer pattern
 */
public abstract class Store extends Subject {
        private double revenue;
        private double dailyRevenue;
        private ArrayList<RentalRecord> rentalRecords;
        private CarStorage carStorage;
        private boolean open;

        public void setCarStorage(CarStorage carStorage){
                this.carStorage = carStorage;
        }

        public double getRevenue(){
                return this.revenue;
        }

        public double getDailyRevenue() {
                return dailyRevenue;
        }

        public ArrayList<RentalRecord> getCustomerRentals(Customer customer){
                // get rental records for the given customer
                ArrayList<RentalRecord> customerRecords = new ArrayList<RentalRecord>();
                for (RentalRecord record: this.rentalRecords) {
                        if(record.getCustomer() == customer){
                                customerRecords.add(record);
                        }
                }
                return customerRecords;
        }

        public ArrayList<RentalRecord> getAllRentals() {
                return rentalRecords;
        }

        public boolean isOpen(){
                return open;
        }

        public ArrayList<Car> carsAvailable(){
                throw new UnsupportedOperationException("Implement CarRentalSim.Cars.Creation.CarStorage");
        }

        public void rentCar(Customer customer, int numCars, int numDays){
               throw new UnsupportedOperationException("Implement CarRentalSim.Customers.Customer and CarRentalSim.Cars.Creation.CarStorage");
        }

        public void returnCar(Customer customer){
               throw new UnsupportedOperationException("Implement CarRentalSim.Cars.Creation.CarStorage");
        }

        // TODO: add notify observers
        public void open(){
                this.open = true;
                super.notifyObservers();
        }

        // TODO: add notify observers
        public void close(){
               this.open = false;
               super.notifyObservers();
        }
}
