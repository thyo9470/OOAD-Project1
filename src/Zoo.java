import java.util.ArrayList;

public class Zoo {

    private ArrayList<Animal> animals;

    public static void main(String[] args){

        Zoo zoo = new Zoo();
        Zookeeper zookeeper = new Zookeeper(zoo);
        zookeeper.manageZoo();

    }

    Zoo(){
        this.animals = new ArrayList<>();

        // Pachyderms
        animals.add(new Elephant());
        animals.add(new Elephant(false, "vegetation", "forest", true, "Eli", 4, 2));
        animals.add(new Hippo());
        animals.add(new Hippo(false, "vegetation", "swamp", true, "Hannah", 4, 0));
        animals.add(new Rhino());
        animals.add(new Rhino(false, "vegetation", "grassland", true, "Ricky", 4, 1));

        // Canines
        animals.add(new Dog());
        animals.add(new Dog(false, "omnivore", "urban", true, "Doug", 4, true));
        animals.add(new Wolf());
        animals.add(new Wolf(false, "carnivore", "outlands", true, "Walsh", 4));

        // Feline
        animals.add(new Cat());
        animals.add(new Cat(false, "carnivore", "urban", true, "Cathrine", 4));
        animals.add(new Lion());
        animals.add(new Lion(false, "carnivore", "grassland", true, "Leon", 4));
        animals.add(new Tiger());
        animals.add(new Tiger(false, "carnivore", "jungle", true, "Theodore", 4));
    }

    /**
     * Get a list of all the animals in the zoo
     * @return animals (ArrayList<Animal>
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     *  Set list of animals in the zoo to new list of animals
     * @param animals:ArrayList<Animal>
     */
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    /**
     *  Add one animal to the animals in the zoo
     * @param animal:Animal
     */
    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
}
