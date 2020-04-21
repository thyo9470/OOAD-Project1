package Graphics;

import Interactions.Interactable;

import javax.swing.*;

abstract public class Graphics {

    protected Interactable interactable;
    private Graphics successor;

    public Interactable getInteractable() {
        return interactable;
    }

    abstract public void setInteractable(Interactable interactable);

    public void handle(Interactable interactable) {

    }

    abstract public void createDisplay(JFrame frame);
}
