package Rooms;


import Entities.Entity;
import Interactions.Interactable;

public class TrapRoom extends Room{


    private Puzzle puzzle;

    /**
     * Sets the puzzle question
     * @param puzzle: newPuzzle
     */
    public void setPuzzle(Puzzle puzzle){
        this.puzzle = puzzle;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    /**
     * Asks player the Puzzle Question
     * @param entity: currentEntity
     */
    public void interact(Entity entity){

        this.puzzle.setEntity(entity);
        this.puzzle.askQuestion();

    }
}
