import java.util.ArrayList;
import java.util.Random;

public class Lion extends Feline{

    final String[] lionSounds = {"meow", "roar", "grunt", "moan", "growl", "snarl", "purr", "hum", "puff", "woof"};

    Lion() {
        super(false, "Carnivore", "Grassland", true, "Lenny", 4);
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
    Lion(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
        super(awake, diet, habitat, hungry, name, numLegs);
    }

    /**
     * Override for makeNoise function
     * Constructs a random string of 5 lion sounds
     */
    @Override
    public void makeNoise() {
        Random rd = new Random();
        String noise = "";
        for(int i = 0; i < 5; i++){
            String nextSound = lionSounds[rd.nextInt(lionSounds.length)] + " ";
            noise += nextSound;
        }
        System.out.println(name + " the " + this.getClass().getName() + ": Made the following noises - " + noise);
    }


}
