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
        animals.add(new Elephant());
        animals.add(new Hippo());
        animals.add(new Hippo());
        animals.add(new Rhino());
        animals.add(new Rhino());

        // Marsupials
        animals.add(new Koala());
        animals.add(new Koala());

        // Monotreme
        animals.add(new LongBeakedEchidna());
        animals.add(new LongBeakedEchidna());
        animals.add(new Platypus());
        animals.add(new Platypus());
        animals.add(new ShortBeakedEchidna());
        animals.add(new ShortBeakedEchidna());
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
