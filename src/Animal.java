import java.util.Random;

public class Animal {

    private boolean awake;
    private String diet;
    private String habitat;
    private boolean hungry;
    protected String name;
    private int numLegs;


    Animal(){
        Random rd = new Random();
        this.awake = rd.nextBoolean();
        this.diet = "unknown";
        this.habitat = "unknown";
        this.hungry = rd.nextBoolean();
        this.name = "Adam";
        this.numLegs = 4;
    }

    /**
     * Constructor that you can set all class fields
     * @param awake:boolean - Is the animal awake?
     * @param diet:String - What does the animal eat?
     * @param habitat:String - Where does the animal live?
     * @param hungry:boolean - Is the animal hungry?
     * @param name:String - The name of the animal
     * @param numLegs:int - How many legs does the animal have?
     */
    Animal(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        this.awake = awake;
        this.diet = diet;
        this.habitat = habitat;
        this.hungry = hungry;
        this.name = name;
        this.numLegs = numLegs;
    }

    /**
     *  Get animal's diet
     * @return String: animal diet
     */
    public String getDiet(){
        return diet;
    }

    /**
     *  Change the animal's diet
     * @param newDiet (String)
     */
    public void setDiet(String newDiet){
        this.diet = newDiet;
    }

    /**
     *  Gets the number of legs an animal has
     * @return int: numLegs
     */
    public int getNumLegs(){
        return numLegs;
    }

    /**
     *  Change the number of legs the animal has
     * @param newNumLegs:int
     */
    public void setNumLegs(int newNumLegs){
        this.numLegs = newNumLegs;
    }

    /**
     *  Get's the habitat where an animal lives
     * @return String: Habitat
     */
    public String getHabitat(){
        return habitat;
    }

    /**
     *  Change the animal's habitat
     * @param newHabitat:String
     */
    public void setHabitat(String newHabitat){
        this.habitat = newHabitat;
    }

    /**
     *  Wakes animal up animal
     */
    public void wakeup(){
        if (!this.awake) {
            System.out.println(name + " the " + this.getClass().getName() + ": Woke up.");
            this.awake = true;
        } else {
            System.out.println(name + " the " + this.getClass().getName() + ": Is already awake");
        }
    }

    /**
     *  Animal makes noise
     */
    public void makeNoise(){
        System.out.println(name + " the " + this.getClass().getName() + ": *generic animal sound*.");
    }

    /**
     *  Makes animal eat
     *  Call to have the animal eat
     */
    public void eat(){
        if(this.hungry) {
            System.out.println(name + " the " + this.getClass().getName() + ": Began to eat.");
            this.hungry = false;
        } else {
            System.out.println(name + " the " + this.getClass().getName() + ": Was not hungry.");
        }
    }

    // add is hungry and is awake

    /**
     *  Call to make the animal roam around its exhibit
     */
    public void roam(){
        System.out.println(name + " the " + this.getClass().getName() + ": Began to roam.");
        this.hungry = true;
    }

    /**
     *  Call to make the animal sleep
     */
    public void sleep(){
        if (this.awake) {
            System.out.println(name + " the " + this.getClass().getName() + ": Fell fast asleep.");
            this.awake = false;
        } else {
            System.out.println(name + " the " + this.getClass().getName() + ": Is already asleep");
        }
    }


}
