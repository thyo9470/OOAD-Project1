package Factories;

import Rooms.Puzzle;
import Rooms.PuzzleQuestion;
import Rooms.TrapRoom;

public class PuzzleFactory {

    private PuzzleFactory factory;

    public PuzzleFactory(PuzzleFactory factory){
        this.factory = factory;
    }

    public Puzzle createPuzzle(){

        PuzzleQuestion puzzleQuestion = new PuzzleQuestion();
        return new Puzzle(puzzleQuestion);
    }
}
