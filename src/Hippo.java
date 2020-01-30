public class Hippo extends Pachyderm {

    Hippo(){
        super(true, "vegetation", "savannah", true, "Harold", 4, 0);
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
    Hippo(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
    }

    /**
     *  Constructor with Animal and Pachyderm parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     *
     * @param numTusks:int - How many tusks does the animal possess?
     */
    Hippo(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, int numTusks){
        super(awake, diet, habitat, hungry, name, numLegs, numTusks);
    }

    /**
     * Overwrite roam for Hippos
     */
    @Override
    public void roam() { System.out.println(name + " the Hippo: Sinks into his pond."); }

    /**
     * Overwrite make noise for Hippos (5 different noisses)
     * 20% of the time grunts, groans, growls, wheezes, or
     */
    @Override
    public void makeNoise() {
        double rand = Math.random();
        if (rand < 0.2) {
            System.out.println(name + " the Hippo: *grunts*");
        } else if (rand < 0.4){
            System.out.println(name + " the Hippo: *groans*");
        } else if (rand < 0.6) {
            System.out.println(name + " the Hippo: *growls*");
        } else if (rand < 0.8) {
            System.out.println(name + " the Hippo: *wheezes*");
        } else {
            System.out.println(name + " the Hippo: *chuffs*");
        }
    }
}
