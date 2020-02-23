public class CasualCustomer extends Customer {

    /**
     *  Casual customers can rent 1 car for 1-3 nights
     */
    public CasualCustomer(){
        super(1, rand.nextInt(3)+1);
    }
}
