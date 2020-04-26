package Factories;

import Rooms.Puzzle;
import Rooms.PuzzleQuestion;

public class PuzzleFactory {

    private PuzzleFactory factory;

    public PuzzleFactory(PuzzleFactory factory){
        this.factory = factory;
    }

    public Puzzle createPuzzle(PuzzleQuestion puzzleType){

        return new Puzzle(puzzleType);
    }
}
