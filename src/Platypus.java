public class Platypus extends Monotreme{

    private double billLength; // in cm

    Platypus(){
        super(true, "Bottom Feeders", "Freshwater Pond", true, "Perry", 4, false);
    }

    /**
     *  Constructor with only Animal parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     */
    Platypus(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs, false);
    }

    /**
     *  Constructor with all Animal, Monotreme, and Platypus parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     *
     * @param billLength:double - The length of the platypus's bill in cm
     */
    Platypus(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, double billLength){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.billLength = billLength;
    }

    /**
     *  returns the length of the Platypus's bill
     * @return billLength (double)
     */
    public double getBillLength() {
        return billLength;
    }

    /**
     * Overrides the makeNoise function from Animal
     */
    @Override
    public void makeNoise() {
        double randomNumber = Math.random();
        if (randomNumber < 0.4){
            System.out.println("gnarrg.g.g.g");
        } else if (randomNumber < 0.6) {
            System.out.println("Krrkrkrkrkekeekjfnfnd");
        } else if (randomNumber < 0.8) {
            System.out.println("krhkrgkrkrkkrkrkrrrrkrrrrrgg");
        } else {
            System.out.println("rrrrrrrrrr");
        }
    }

    /**
     * Overrides the roam function from Monotreme
     */
    @Override
    public void roam() {
        double randomNumber = Math.random();
        if(randomNumber < 0.9){
            System.out.println(name + " the Platypus: Dove into it's pond and swam off.");
        } else {
            System.out.println(name + " the Platypus: Looks at you with confusion. He has more important things to do such as ponder its own existence.");
        }
    }
}
