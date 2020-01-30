public class Monotreme extends Animal{

    private boolean spikes;

    Monotreme(){
        super(true, "plants", "unknown", true, "Monty", 4);
        this.spikes = false;
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
    Monotreme(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.spikes = false;
    }

    /**
     *  Constructor with all Animal and Monotreme parameters
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     *
     * @param spikes:boolean - Does this animal have spikes
     */
    Monotreme(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, boolean spikes){
        super(awake, diet, habitat, hungry, name, numLegs);
        this.spikes = spikes;
    }

    public boolean hasSpikes(){
        return spikes;
    }

    @Override
    public void roam() {
        double randomNumber = Math.random();
        if(randomNumber < 0.5) {
            System.out.println(name + " the Monotreme: Began to bobble around the enclosure.");
        }else{
            System.out.println(name + " the Monotreme: Cowered in fear.");
        }
    }
}
