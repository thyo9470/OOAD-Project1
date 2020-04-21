package Interactions;

import Graphics.GraphicsHandler;

abstract public class Interactable implements Observable {

    protected GraphicsHandler graphicsHandler;
    protected Boolean changeState;
    protected Interactable nextIntractable;

    public Boolean isChangeState() {
        return this.changeState;
    }

    public Boolean getChangeState() {
        this.changeState = false;
        return this.changeState;
    }

    public Interactable getNextIntractable() {
        return nextIntractable;
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer instanceof GraphicsHandler) {
            this.graphicsHandler = (GraphicsHandler)observer;
        }
    }
}
