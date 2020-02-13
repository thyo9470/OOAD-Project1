import java.util.ArrayList;

public class Zookeeper {

    private Zoo zoo;

    Zookeeper(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     *  Get the zoo the zookeeper works for
     * @return zooToManage (Zoo)
     */
    public Zoo getZoo() {
        return zoo;
    }

    /**
     * Change the zoo the zookeeper works for
     * @param zooToManage:Zoo
     */
    public void setZooToManage(Zoo zooToManage) {
        this.zoo = zooToManage;
    }

    public void manageZoo(){
        wakeAnimals();
        rollCall();
        feedAnimals();
        exerciseAnimals();
        shutdownZoo();
    }

    private void wakeAnimals(){
        System.out.println("\n\"The early bird gets the worm.\"\n -Zookeeper as he wakes the animals.");
        ArrayList<Animal> animals = zoo.getAnimals();
        for(Animal animal : animals){
            animal.wakeup();
        }
    }

    private void rollCall(){
        System.out.println("\n\"Lets see who's here today.\"\n -Zookeeper as he does roll call.");
        ArrayList<Animal> animals = zoo.getAnimals();
        for(Animal animal : animals){
            animal.makeNoise();
        }
    }

    private void feedAnimals(){
        System.out.println("\n\"A full belly is a happy belly.\"\n -Zookeeper as he feeds the animals.");
        ArrayList<Animal> animals = zoo.getAnimals();
        for(Animal animal : animals){
            animal.eat();
        }
    }

    private void exerciseAnimals(){
        System.out.println("\n\"Get up! Get on up! Get up! Get on Up!.\"\n -Zookeeper sings to motivate the animals to exercise.");
        ArrayList<Animal> animals = zoo.getAnimals();
        for(Animal animal : animals){
            animal.roam();
        }
    }

    private void shutdownZoo(){
        System.out.println("\n\"Time to head to sleepy town.\"\n -Zookeeper yawns as gives each habitat a look over.");
        ArrayList<Animal> animals = zoo.getAnimals();
        for(Animal animal : animals){
            animal.sleep();
        }
    }

}
