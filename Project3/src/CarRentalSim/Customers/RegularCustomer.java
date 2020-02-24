package CarRentalSim.Customers;

public class RegularCustomer extends Customer {

   /**
    * Regular customers can rent 1-3 cars for 3-5 nights
    */
   public RegularCustomer(){
      super(rand.nextInt(3)+1,rand.nextInt(3)+3);
   }

}
