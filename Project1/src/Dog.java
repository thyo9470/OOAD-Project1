public class Dog extends Canine {

    Dog(){
        super(false, "Omnivore", "Suburbs", true, "Danny", 4, true);
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
    Dog(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
    }

    /**
     *  Constructor with Animal and Canine parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     *
     * @param domesticated:boolean - Is this animal domesticated
     */
    Dog(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, boolean domesticated){
        super(awake, diet, habitat, hungry, name, numLegs, domesticated);
    }

    /**
     * Override make noise for Dogs
     * 80% of the time the dog whines
     * 20% of the time the dog barks
     */
    @Override
    public void makeNoise() {
        double rand = Math.random();
        if (rand < 0.2) {
            System.out.println(name + " the Dog: barks");
        } else {
            System.out.println(name + " the Dog: whines.");
        }
    }

}
