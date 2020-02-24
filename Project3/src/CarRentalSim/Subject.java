package CarRentalSim;

import java.util.ArrayList;

/**
 * Interface for CarRentalSim.Observer Pattern -> CarRentalSim.Subject
 */
public abstract class  Subject {
    private ArrayList<Observer> observers;

    public void registerObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    protected void notifyObservers(){
        for (Observer obs: this.observers) {
            obs.update();
        }
    }
}
