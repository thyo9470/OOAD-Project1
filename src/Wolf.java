public class Wolf extends Canine {

    Wolf(){
        super(false, "Omnivore", "forests", true, "woonwoon", 4, false);
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

    Wolf(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
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
    Wolf(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, boolean domesticated){
        super(awake, diet, habitat, hungry, name, numLegs, domesticated);
    }

    /**
     * Override make noise for Wolves
     * 20% of the time wolf howls
     * 80% of the time dog aggressively growls
     */
    @Override
    public void makeNoise() {
        double rand = Math.random();
        if (rand < 0.2) {
            System.out.println(name + " the Wolf: howls");
        } else {
            System.out.println(name + " the Wolf: aggressively growls.");
        }
    }


}
