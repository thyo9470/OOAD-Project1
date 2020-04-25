package Rooms;


public class TrapRoom extends Room{


    private Puzzle puzzle;

    /**
     * Sets the puzzle question
     * @param puzzle: newPuzzle
     */
    public void setPuzzle(Puzzle puzzle){
        this.puzzle = puzzle;
    }


    /**
     * Asks player the Puzzle Question
     * @param entity: currentEntity
     */
    public void interact(Entities.Entity entity){

        puzzle.askQuestion();

    }



}
