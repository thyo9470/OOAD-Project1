package Interactions;

import Graphics.GraphicsHandler;

abstract public class Intractable implements Observable {

    protected GraphicsHandler graphicsHandler;
    protected Boolean changeState;
    protected Intractable nextIntractable;

    public Boolean isChangeState() {
        return this.changeState;
    }

    public Boolean getChangeState() {
        this.changeState = false;
        return this.changeState;
    }

    public Intractable getNextIntractable() {
        return nextIntractable;
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer instanceof GraphicsHandler) {
            this.graphicsHandler = (GraphicsHandler)observer;
        }
    }
}
