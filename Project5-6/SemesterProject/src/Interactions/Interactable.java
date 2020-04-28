package Interactions;

import Entities.Entity;
import Game.Game;
import Graphics.GraphicsHandler;
import Rooms.Floor;

/**
 * OBSERVER PATTERN
 * Acts as one of the observable objects in observer pattern
 *
 * MVC PATTERN
 * Acts as the model for the MVC pattern
 */
abstract public class Interactable implements Observable {

    protected GraphicsHandler graphicsHandler;
    protected Floor floor;
    private Boolean changeState = false;
    private Interactable nextIntractable;

    /**
     * Gets the current change state.
     * change state is also set to false since it will only need to be called once per state change
     * @return
     */
    public Boolean getChangeState() {
        Boolean currentChangeState = this.changeState;
        this.changeState = false;
        return currentChangeState;
    }

    /**
     * sets the floor which the interactable will return to after interacting
     * @param floor: Floor
     */
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    /**
     * set to whatever the next interactable to display is
     * @return Interactable
     */
    public Interactable getNextIntractable() {
        return nextIntractable;
    }

    /**
     * sets what the next ineractable will be to display
     *  sets changeState to true since this function should only be called when changing states
     * @param nextIntractable: Interactable
     */
    public void setNextIntractable(Interactable nextIntractable) {
        this.changeState = true;
        this.nextIntractable = nextIntractable;
    }

    /**
     * Returns to the floor from Interactable
     *  - delete the thread used to allow for getting input and showing display
     *  - checks for game over
     */
    public void returnToFloor() {
        if(Thread.currentThread().getName() == "room-thread"){
            Thread.interrupted();
        }
        Entity entity = this.floor.getPlayer();
        if(entity.getHealth() <= 0){
            Game.setGameOver();
        }
        this.changeState = true;
        this.setNextIntractable(this.floor);
        this.notifyObserver();
    }

    /**
     * OBSERVER PATTERN
     * register observer for observer pattern
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        if (observer instanceof GraphicsHandler) {
            this.graphicsHandler = (GraphicsHandler)observer;
        }
    }

    /**
     * OBSERVER PATTERN
     * remove registered observer
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        this.graphicsHandler = null;
    }

    /**
     * OBSERVER PATTERN
     * Indicate a state change to observer
     */
    @Override
    public void notifyObserver() {
        this.graphicsHandler.update();
    }
}
