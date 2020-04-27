package Factories;

import Items.Item;
import Rooms.Puzzle;
import Rooms.PuzzleQuestion;
import Rooms.TrapRoom;

public class PuzzleFactory {

    private ItemFactory itemFactory;

    public PuzzleFactory(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    public Puzzle createPuzzle(){

        PuzzleQuestion puzzleQuestion = new PuzzleQuestion();
        Puzzle puzzle = new Puzzle(puzzleQuestion);
        puzzle.setRewardItem(itemFactory.createItem());
        return puzzle;
    }
}
