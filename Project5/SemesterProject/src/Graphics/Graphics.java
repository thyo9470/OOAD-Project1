package Graphics;

import Interactions.Interactable;

import javax.swing.*;

/**
 * CHAIN OF RESPONSIBILITY PATTERN
 * This is the handler class for the display
 *
 * MVC PATTERN
 * this and the child components act as the view and controller for MVC pattern
 */
abstract public class Graphics {

    protected Interactable interactable;
    protected Graphics successor;

    abstract protected void setInteractable(Interactable interactable);

    public void setSuccessor(Graphics successor) {
        this.successor = successor;
    }

    /**
     * CHAIN OF RESPONSIBILITY PATTERN
     * handles requests for chain of responsibility pattern
     *
     * Given an interactable and a frame this function will go down the different graphics components and try to display
     * the intractable on the frame
     *
     * This is done by trying to set the interactable for itself, if this produces an
     * illegal argument exception it goes to the next graphics component
     *
     * @param interactable: Interactable
     * @param frame: JFrame
     */
    public void handle(Interactable interactable, JFrame frame){
        try {
            this.setInteractable(interactable);
            this.createDisplay(frame);
        } catch (IllegalArgumentException e) {
            if(this.successor != null){
                this.successor.handle(interactable, frame);
            } else {
                throw new IllegalArgumentException("The given interactable is not support: " + interactable.getClass().getSimpleName());
            }
        }
    }

    /**
     * Given an empty JFrame, the graphics component constructs a scene
     * Each graphics component will need to implement their own displays
     *
     * @param frame
     */
    protected abstract void createDisplay(JFrame frame);
}
