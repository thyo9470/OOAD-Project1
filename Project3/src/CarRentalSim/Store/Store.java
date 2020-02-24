package CarRentalSim.Store;

import CarRentalSim.Cars.Car;
import CarRentalSim.Cars.Creation.CarStorage;
import CarRentalSim.Cars.Decorators.CarDecorator;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Simulator;
import CarRentalSim.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *  CarRentalSim.Store.Store acts as the CarRentalSim.Subject for CarRentalSim.Observer pattern
 */
public class Store extends Subject {
    private double revenue;
    private double dailyRevenue;
    private ArrayList<RentalRecord> rentalRecords = new ArrayList<>();
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

    public ArrayList<Car> getCarsAvailable(){
        return this.carStorage.getCarsLeft();
    }

    public void rentCar(Customer customer, int duration, ArrayList<String> licensePlates){
        ArrayList<Car> cars = new ArrayList<>();
        double baseCost = 0;
        double nightlyCost = 0;
        for (String val:licensePlates) {
            Set<Class<? extends CarDecorator>> extras = new HashSet<>();
            Car requestedCar = this.carStorage.requestCar(val, extras);
            baseCost += requestedCar.getCost();
            nightlyCost += requestedCar.getNightlyCost();
            cars.add(requestedCar);
        }
        //TODO: make costs make sense
        RentalRecord newRentalRecord = new RentalRecord(customer, baseCost, nightlyCost, duration, Simulator.getCurrentDay(), cars);
        this.rentalRecords.add(newRentalRecord);
    }

    public void returnCar(Customer customer){
        for (RentalRecord rentalRecord: this.rentalRecords) {
            if(rentalRecord.getCustomer() == customer){
                for (Car car: rentalRecord.getCars()) {
                   this.carStorage.returnCar(car);
                }
                this.rentalRecords.remove(rentalRecord);
            }
        }
    }

    public void open(){
        this.open = true;
        super.notifyObservers();
    }

    public void close(){
       this.open = false;
       super.notifyObservers();
    }
}
