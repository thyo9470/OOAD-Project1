public class Marsupial extends Animal {

    private boolean Pouch;
    private boolean inAustralia;

    public Marsupial(){}

    public Marsupial(String foodItEats, int numLegs, String livesHere){
        super(foodItEats, numLegs, livesHere);
        this.Pouch = true;
        this.inAustralia = true;
    }

    public Marsupial(String foodItEats, int numLegs, String livesHere, boolean Pouch, boolean inAustralia){
        super(foodItEats, numLegs, livesHere);
        this.Pouch = Pouch;
        this.inAustralia = inAustralia;
    }


    public boolean getPouchVal(){
        return Pouch;
    }

    public void setPouchVal(boolean havePouch){
        this.Pouch = havePouch;
    }

    public boolean getInAussie(){
        return inAustralia;
    }

    public void setInAussie(boolean inAussie){
        this.inAustralia = inAussie;
    }

}
