public class ShortBeakedEchidna extends Monotreme {

    private double nervousness; // scale 0-1, 1 being the most nervous

    ShortBeakedEchidna(){
        super(true, "Bugs", "Semi-Arid Biome", true, "Steve", 4, true);
        this.nervousness = Math.random();
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
    ShortBeakedEchidna(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs, false);
        this.nervousness = Math.random();
    }

    /**
     *  Constructor with all Animal, Monotreme, and ShortBeakedEchidna parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     *
     * @param nervousness:double - How nervous is the echidna on a scale 0-1
     */
    ShortBeakedEchidna(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, double nervousness){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.nervousness = nervousness;
    }

    /**
     *  Setter for nervousness
     *  If the given nervousness is more than 1, nervousness is set to 1
     *  If the given nervousness is less then 0, nervousness is set to 0
     * @param nervousness (double)
     */
    public void setNervousness(double nervousness) {
        if (nervousness > 1) { nervousness = 1; }
        if (nervousness < 0) { nervousness = 0; }
        this.nervousness = nervousness;
    }

    /**
     *  Override for the makeNoise function from Animal
     *  Depending one how nervous the short-beaked echidna is it will either shy away or snuffle and grunt
     */
    @Override
    public void makeNoise() {
        double randomNumber = Math.random();
        if(randomNumber < this.nervousness){
            System.out.println(name + " the Short-Beaked Echidna: Shied away from the zookeeper.");
        } else {
            System.out.println(name + " the Short-Beaked Echidna: Snuffled and Grunted");
        }
    }

    /**
     *  Override for the roam function from Monotreme
     *  Nervousness will decide how the animal roams. It will either be scared or waddle away.
     */
    @Override
    public void roam() {
        double randomNumber = Math.random();
        if(randomNumber < this.nervousness){
            if (Math.random() < 0.5) {
                System.out.println(name + " the Short-Beaked Echidna: Shied away from the zookeeper.");
            } else {
                System.out.println(name + " the Short-Beaked Echidna: Tucked its head away in fear.");
            }
        }else {
            System.out.println(name + " the Short-Beaked Echidna: Waddled away");
        }
    }
}
