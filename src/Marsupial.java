public class Marsupial extends Animal {

    private boolean pouch;
    private boolean fromAustralia;

    Marsupial(){
        super(true, "plants", "unknown", true, "Marcy", 4);
        this.pouch = true;
        this.fromAustralia = true;
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
    Marsupial(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.pouch = true;
        this.fromAustralia = true;
    }

    /**
     *  Constructor with all Animal and Marsupial parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     *
     * @param pouch:boolean - Does this Marsupial have a pouch?
     * @param fromAustralia:boolean - Is this Marsupial from Australia
     */
    Marsupial(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, boolean pouch, boolean fromAustralia){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.pouch = pouch;
        this.fromAustralia = fromAustralia;
    }


    /**
     *  returns whether the marsupial has a pouch
     * @return puch (boolean)
     */
    public boolean hasPouch(){
        return pouch;
    }

    /**
     *  Returns if the animal is from Australia
     * @return fromAustralia (boolean)
     */
    public boolean fromAustralia(){
        return fromAustralia;
    }

}
