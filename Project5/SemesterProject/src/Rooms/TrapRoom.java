package Rooms;


public class TrapRoom extends Room{


    private Puzzle puzzle;

    /**
     *
     * @param puzzle
     */
    public void setPuzzle(Puzzle puzzle){
        this.puzzle = puzzle;
    }


    /**
     *
     * @param entity
     */
    public void interact(Entities.Entity entity){

        puzzle.askQuestion();

    }



}
