package CarRentalSim.Store;

import CarRentalSim.Cars.Car;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Simulator;

import java.util.ArrayList;

public class RentalRecord {

    private boolean active;
    private double baseCost;
    private ArrayList<Car> carsRented;
    private Customer customer;
    private int duration;
    private double perDayCost;
    private int startDate; // date is the day number

    public RentalRecord(Customer customer, double baseCost, double perDayCost, int duration, int startDate, ArrayList<Car> carsRented){
        this.active = true;
        this.baseCost = baseCost;
        this.carsRented = carsRented;
        this.customer = customer;
        this.duration = duration;
        this.perDayCost = perDayCost;
        this.startDate = startDate;
    }

    public boolean isActive(){
        return this.active;
    }

    // assumption: once a car is returned it cannot be unreturned. A new record will be created for that.
    public void setReturned() {
        this.active = false;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    /**
     * @return double: the total cost of the trip
     */
    public double getCost(){
        return baseCost + ( perDayCost * duration );
    }

    /**
     * @return int: total duration of the rental
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @return int: number of days left in rental
     */
    public int getDaysLeft() {
        return duration - (Simulator.getCurrentDay() - startDate);
    }

    /**
     * @return ArrayList<CarRentalSim.Cars.Car>: cars in this rental
     */
    public ArrayList<Car> getCars(){
        return carsRented;
    }

}
