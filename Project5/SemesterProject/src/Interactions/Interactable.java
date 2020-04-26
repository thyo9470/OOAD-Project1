package Interactions;

import Graphics.GraphicsHandler;
import Rooms.Floor;

abstract public class Interactable implements Observable {

    protected GraphicsHandler graphicsHandler;
    protected Floor floor;
    protected Boolean changeState = false;
    protected Interactable nextIntractable;

    public Boolean isChangeState() {
        return this.changeState;
    }

    public Boolean getChangeState() {
        Boolean currentChangeState = this.changeState;
        this.changeState = false;
        return currentChangeState;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Interactable getNextIntractable() {
        return nextIntractable;
    }

    public void setNextIntractable(Interactable nextIntractable) {
        this.changeState = true;
        this.nextIntractable = nextIntractable;
    }

    public void returnToFloor() {
        if(Thread.currentThread().getName() == "room-thread"){
            Thread.interrupted();
        }
        this.setNextIntractable(this.floor);
        this.notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer instanceof GraphicsHandler) {
            this.graphicsHandler = (GraphicsHandler)observer;
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        this.graphicsHandler = null;
    }

    @Override
    public void notifyObserver() {
        this.graphicsHandler.update();
    }
}
