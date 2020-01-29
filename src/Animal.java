public class Animal {

    private String food;
    private int legs;
    private String location;

    public Animal(){}

    public Animal(String foodItEats, int numLegs, String livesHere){
        this.food = foodItEats;
        this.legs = numLegs;
        this.location = livesHere;
    }

    public String getFood(){
        return food;
    }

    public void setFood(String newFood){
        this.food = newFood;
    }

    public int getLegs(){
        return legs;
    }

    public void setLegs(int newLegs){
        this.legs = newLegs;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String newLoc){
        this.location = newLoc;
    }





}
