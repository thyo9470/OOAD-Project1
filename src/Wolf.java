public class Wolf extends Canine {

    Wolf(){
        super(true, "Omnivore", "Suburbs", true, "MoonMoon", 4, false);
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
     * Override roam for Wolves
     * 70% of the time wold hides in his cave
     * 30% of the time the wolf goes looking for meat to eat
     */
    @Override
    public void roam() {
        double randomNumber = Math.random();
        if(randomNumber < 0.7) {
            System.out.println(name + " the Wolf: hides in his cave.");
        } else {
            System.out.println(name + " the Wolf: looks for some meat to eat.");
        }

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
