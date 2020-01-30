public class Canine extends Animal {

    private boolean domesticated;

    Canine(){
        super(false, "Omnivore", "Forests", true, "Cory", 4);
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
     * 25% chance to...
     *  - roll over for a belly rub
     *  - chase their tail
     *  - hide in a cave
     *  - look for meat to eat
     */

    @Override
    public void roam(){
        double randomNumber = Math.random();
        if(randomNumber < 0.25) {
            System.out.println(name + " the" + this.getClass().getName() + ": rolls over for belly rubs.");
        } else if (randomNumber < 0.5){
            System.out.println(name + " the " + this.getClass().getName() + ": chases his tail.");
        } else if(randomNumber < 0.75) {
            System.out.println(name + " the " + this.getClass().getName() + ": hides in his cave.");
        } else {
            System.out.println(name + " the " + this.getClass().getName() + ": looks for some meat to eat.");
        }
    }

    /**
     * Override makeNoise for Canines
     */
    @Override
    public void makeNoise(){
        System.out.println(name + " the " + this.getClass().getName() + " growls.");
    }




}
