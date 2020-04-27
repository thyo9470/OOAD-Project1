package Interactions;

import Entities.Entity;
import Game.Game;
import Graphics.GraphicsHandler;
import Rooms.Floor;

import java.awt.desktop.SystemSleepEvent;

abstract public class Interactable implements Observable {

    protected GraphicsHandler graphicsHandler;
    protected Floor floor;
    private Boolean changeState = false;
    private Interactable nextIntractable;

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
        System.out.println("RETURN TO FLOOR");
        Entity entity = this.floor.getPlayer();
        if(entity.getHealth() <= 0){
            Game.setGameOver();
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
