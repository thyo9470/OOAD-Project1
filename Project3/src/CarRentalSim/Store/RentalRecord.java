package CarRentalSim.Store;

import CarRentalSim.Cars.Car;
import CarRentalSim.Customers.Customer;
import CarRentalSim.Simulator;

import java.util.ArrayList;

public class RentalRecord {

    private Customer customer;
    private double baseCost;
    private double perDayCost;
    private int duration;
    private int startDate; // date is the day number
    private ArrayList<Car> carsRented;

    public RentalRecord(Customer customer, double baseCost, double perDayCost, int duration, int startDate, ArrayList<Car> carsRented){
        this.customer = customer;
        this.baseCost = baseCost;
        this.perDayCost = perDayCost;
        this.duration = duration;
        this.startDate = startDate;
        this.carsRented = carsRented;
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
