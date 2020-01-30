
public class LongBeakedEchidna extends Monotreme {

    public enum SquishLevel { MARSHMALLOW, PILLOW, PLAYDOH}

    private SquishLevel squishiness;

    LongBeakedEchidna(){
        super(true, "Bugs", "Hilly Forests", true, "Larry", 4, true);
        this.squishiness = SquishLevel.PILLOW;
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
    LongBeakedEchidna(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs, false);
        this.squishiness = SquishLevel.PILLOW;
    }

    /**
     *  Constructor with all Animal, Monotreme, and LongBeakedEchidna parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     *
     * @param squishiness:SquishLevel - How nervous is the echidna on a scale 0-1
     */
    LongBeakedEchidna(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, SquishLevel squishiness){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.squishiness = squishiness;
    }

    /**
     *  Gets how squishy this Long-Beaked Echidna is
     * @return squishiness (SquishLevel)
     */
    public SquishLevel getSquishiness() {
        return squishiness;
    }

    /**
     *  Sets how squishy this Long-Beaked Echidna is
     * @param squishiness:SquishLevel - options are: MARSHMALLOW, PILLOW, PLAYDOH
     */
    public void setSquishiness(SquishLevel squishiness) {
        this.squishiness = squishiness;
    }

    /**
     *  Override for makeNoise function from Animal
     *  The noise created is based on there squishiness
     */
    @Override
    public void makeNoise() {
        if(squishiness == SquishLevel.MARSHMALLOW){
           System.out.println(name + " the Long-Beaked Echidna: Snuffled.");
        } else if (squishiness == SquishLevel.PILLOW) {
            System.out.println(name + " the Long-Beaked Echidna: Grunted.");
        } else {
            System.out.println(name + " the Long-Beaked Echidna: Grumbled quietly.");
        }
    }

    /**
     *  Override for roam function from Monotreme
     *  How the animal roams is based on their squishiness
     */
    @Override
    public void roam() {
        if(squishiness == SquishLevel.MARSHMALLOW){
            System.out.println(name + " the Long-Beaked Echidna: Shuffled off.");
        } else if (squishiness == SquishLevel.PILLOW) {
            System.out.println(name + " the Long-Beaked Echidna: Waddled away.");
        } else {
            if (Math.random() < 0.5) {
                System.out.println(name + " the Long-Beaked Echidna: Sat there like a blob.");
            } else {
                System.out.println(name + " the Long-Beaked Echidna: Slowly frumped away.");
            }
        }
    }
}
