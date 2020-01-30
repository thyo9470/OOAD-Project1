public class Pachyderm extends Animal{

    private int numTusks;

    Pachyderm(){
        super(true, "vegetation", "savannah", true, "Paul", 4);
        this.numTusks = 0;
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
    Pachyderm(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.numTusks = 0;
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
    Pachyderm(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, int numTusks){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.numTusks = numTusks;
    }

    /**
     * returns number of tusks animal possesses
     * @return numTusks (integer)
     */
    public int numTusks() { return numTusks; }

    /**
     * Override roam for Pachyderms
     */
    @Override
    public void roam() { System.out.println(name + " the : Began to roam."); }
}
