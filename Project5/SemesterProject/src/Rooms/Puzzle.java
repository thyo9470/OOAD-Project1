package Rooms;

import Graphics.GraphicsHandler;
import Interactions.Interactable;
import Interactions.Observer;

public class Puzzle extends Interactable {


    private PuzzleQuestion puzzleQuestion;

    // TODO: delete when done testing
    public static void main(String[] args) {

        PuzzleQuestion puzzleQuestion = new PuzzleQuestion();
        Puzzle puzzle = new Puzzle(puzzleQuestion);

        GraphicsHandler graphicsHandler = new GraphicsHandler();
        graphicsHandler.setInteractable(puzzle);
        puzzle.registerObserver(graphicsHandler);

        puzzle.askQuestion();

    }

    public Puzzle(PuzzleQuestion puzzleQuestion){
        this.puzzleQuestion = puzzleQuestion;
    }

    /**
     *
     * @return PuzzleQuestion
     */
    public PuzzleQuestion getQuestion(){
        return puzzleQuestion;
    }

    /**
     * calls the actual question/puzzle
     */

    public void askQuestion(){
        //asks the player the question

        this.notifyObserver();
        while(this.puzzleQuestion.getAnswer() == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.puzzleQuestion.checkAnswer()){
            // TODO: make good things happen
            // TODO: maybe have the puzzle store an item with it so that it can reward an item
            System.out.println("GOOD ANSWER!");
        } else {
            // TODO: make bad things happen
            // TODO: think of bad things: damage, manaDrain, losing an item, etc.
            System.out.println("BAD ANSWER!");
        }
        this.puzzleQuestion.setAnswer(null);

        this.returnToFloor();
    }

    public void asnwerQuestion(String answer) {
        this.puzzleQuestion.setAnswer(answer);
    }
}
