package Factories;

import Game.Game;
import Items.Item;
import Rooms.Puzzle;
import Rooms.PuzzleQuestion;
import Rooms.TrapRoom;

/**
 * SIMPLE FACTORY PATTERN
 * Acts as a simple factory for puzzles
 */
public class PuzzleFactory {

    private ItemFactory itemFactory;

    public PuzzleFactory(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    /**
     * Creates a random puzzle
     * @return Puzzle
     */
    public Puzzle createPuzzle(){

        PuzzleQuestion puzzleQuestion = new PuzzleQuestion();
        Puzzle puzzle = new Puzzle(puzzleQuestion);
        puzzle.setDamage(200 * Game.getCurrentLevel());
        puzzle.setRewardItem(itemFactory.createItem());
        return puzzle;
    }
}
