public class Rhino extends Pachyderm {

    Rhino(){
        super(true, "vegetation", "savannah", true, "Ronald", 4, 1);
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
    Rhino(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
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
    Rhino(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, int numTusks){
        super(awake, diet, habitat, hungry, name, numLegs, numTusks);
    }

    /**
     * override roam for rhinos
     */
    @Override
    public void roam() {
        double rand = Math.random();
        if (rand < 0.5){
            System.out.println(name + " the Rhino: Charges! How Scary.");
        } else {
            System.out.println(name + " the Rhino: Runs around his paddock.");
        }
    }

    /**
     * override make noise for rhino noises
     */
    @Override
    public void makeNoise() { System.out.println(name + " the Rhino: *screams and trumpets*");}
}
