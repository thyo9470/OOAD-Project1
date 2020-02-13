public class Tiger extends Feline {


   Tiger(){
      super(false, "Carnivore", "Forests", true, "Teddy", 4);
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
   Tiger(boolean awake, String diet, String habitat, boolean hungry, String name, int numLegs){
      super(awake, diet, habitat, hungry, name, numLegs);
   }

   /**
    * Override for makeNoise function
    * 1/3 chance to roar
    * 1/3 chance to chuff ( it's like the tiger equivalent of purring
    * 1/3 chance to growl
    */
   @Override
   public void makeNoise() {
      double randomNumber = Math.random();
      if(randomNumber < 0.33) {
         System.out.println(name + " the " + this.getClass().getName() + ": Roared");
      } else if (randomNumber < 0.66){
         System.out.println(name + " the " + this.getClass().getName() + ": Chuff Chuff");
      } else {
         System.out.println(name + " the " + this.getClass().getName() + ": Growled");
      }
   }
}
