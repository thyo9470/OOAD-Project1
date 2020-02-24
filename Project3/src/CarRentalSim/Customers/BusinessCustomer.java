package CarRentalSim.Customers;

public class BusinessCustomer extends Customer {

    /**
     * Business customers can only rent 3 cars for 7 nights
     */
    public BusinessCustomer(){
        super(3,7);
    }
}
