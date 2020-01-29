public class Monotreme extends Animal{

    Monotreme(String name){
        super(name, true, true);
    }

    Monotreme(String name, boolean awake, boolean hungry){
        super(name, awake, hungry);
    }

    @Override
    public void makeNoise() {
        System.out.println(name + " the Monotreme: shuffled around making quite gargling sounds");
    }
}
