public class Feline extends Animal{

    Feline(){
        super(false, "Carnivore", "unknown", true, "Felix", 4);
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
    Feline(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
    }

    /**
     *  Override for roam function
     *  there is a 50% chance for the Feline to either stroll around the enclosure or go to sleep
     */
    @Override
    public void roam() {
        double randomNumber = Math.random();
        if(randomNumber < 0.5) {
            System.out.println(name + " the " + this.getClass().getName() + ": Began to stroll around the enclosure.");
        }else{
            System.out.println(name + " the "  + this.getClass().getName() + ": Looked at you and went to sleep.");
        }
    }

    /**
     *  Override for makeNoise function
     *  Just has the Feline meow
     */
    @Override
    public void makeNoise() {
        System.out.println(name + " the " + this.getClass().getName() + ": Meowed");
    }
}
