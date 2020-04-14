package Factories;

import Rooms.Puzzle;

public class PuzzleFactory {

    private PuzzleFactory factory;

    public PuzzleFactory(PuzzleFactory factory){
        this.factory = factory;
    }

    public Puzzle createPuzzle(Puzzle puzzleType){

        return puzzleType;
    }
}
