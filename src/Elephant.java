public class Elephant extends Pachyderm {

    Elephant(){
        super(false, "vegetation", "savannah", true, "Emily", 4, 2);
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
    Elephant(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
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
    Elephant(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs, int numTusks){
        super(awake, diet, habitat, hungry, name, numLegs, numTusks);
    }

    /**
<<<<<<< HEAD
=======
     * override roam for elephants
     * 1/3 of the time stomps around
     * 1/3 of the time
     */
    @Override
    public void roam() {
        double rand = Math.random();
        if (rand < 0.34) {
            System.out.println(name + " the Elephant: stomps around its enclosure.");
        } else if (rand < 0.67) {
            System.out.println(name + " the Elephant: uses its trunk to take a bath.");
        } else {
            System.out.println(name + " the Elephant: sprays you with water from its trunk!");
        }
    }

    /**
>>>>>>> 978f1e7a0b25d9379000b49b1d1f9352636afaa3
     * override make noise for elephant noises
     */
    @Override
    public void makeNoise() { System.out.println(name + " the Elephant: Phoo-waompph"); }
}
