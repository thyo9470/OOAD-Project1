package Factories;

import Rooms.Puzzle;
import Rooms.PuzzleQuestion;
import Rooms.TrapRoom;

public class PuzzleFactory {

    public Puzzle createPuzzle(){

        // TODO: give the puzzle a reward item

        PuzzleQuestion puzzleQuestion = new PuzzleQuestion();
        return new Puzzle(puzzleQuestion);
    }
}
