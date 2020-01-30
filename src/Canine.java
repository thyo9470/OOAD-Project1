public class Canine extends Animal {

    private boolean domesticated;

    Canine(){
        super(true, "Omnivore", "Forests", true, "Richard", 4);
        this.domesticated = true;
    }

    /**
     *  Constructor with only Animal parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     * domesticated default set to true
     */


    Canine(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.domesticated = true;
    }

    /**
     *  Constructor with Animal and Canine parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     * @param domesticated:bool - Is this Canine domesticated?
     */


    Canine(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, boolean domesticated){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.domesticated = domesticated;
    }

    /**
     * returns number of tusks animal possesses
     * @return domesticated: boolean
     */

    public boolean isDomesticated(){
        return domesticated;
    }

    /**
     * Override roam for Canines
     */

    @Override
    public void roam(){
        System.out.println(name + " the Canine is roaming.");
    }

    /**
     * Override makeNoise for Canines
     */

    @Override
    public void makeNoise(){
        System.out.println(name + " the Canine growls.");
    }




}
