public class Animal {

    protected String name;
    protected boolean awake;
    protected boolean hungry;

    Animal(String name){
        this.name = name;
        awake = true;
        hungry = true;
    }

    Animal(String name, boolean awake, boolean hungry){
        this.name = name;
        this.awake = awake;
        this.hungry = hungry;
    }

    public void wakeup(){
        System.out.println(name + " the Animal: Woke up.");
        awake = true;
    }

    public void makeNoise(){
        System.out.println(name + " the Animal: *generic animal sound.");
    }

    public void eat(){
        System.out.println(name + " the Animal: Began to eat.");
        hungry = false;
    }

    public void roam(){
        System.out.println(name + " the Animal: Began to roam.");
    }

    public void sleep(){
        System.out.println(name + " the Animal: Fell fast asleep.");
        awake = false;
    }

}
