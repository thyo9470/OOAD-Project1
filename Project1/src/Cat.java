public class Cat extends Feline {

    Cat(){
        super(false, "Carnivore", "suburbs", true, "Calypso", 4);
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
    Cat(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
    }

    /**
     * Override for makeNoise function
     * 50% chance to meow or just look but stay silent
     */
    @Override
    public void makeNoise() {
        double randomNumber = Math.random();
        if(randomNumber < 0.5) {
            System.out.println(name + " the " + this.getClass().getName() + ": Meowed");
        } else {
            System.out.println(name + " the " + this.getClass().getName() + ": Looked but stayed silent");
        }
    }
}
