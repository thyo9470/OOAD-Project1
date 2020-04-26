package Rooms;


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
    public void interact(Entities.Entity entity){

        this.puzzle.askQuestion();

    }
}
