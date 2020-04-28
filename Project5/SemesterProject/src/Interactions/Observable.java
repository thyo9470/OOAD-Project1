package Interactions;

/**
 * OBSERVER PATTERN
 */
public interface Observable {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
