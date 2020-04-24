package Rooms;

import Graphics.GraphicsHandler;
import Interactions.Interactable;
import Interactions.Observer;

public class Puzzle extends Interactable {


    private PuzzleQuestion puzzleQuestion;
    private String userAnswer; // Got from display

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
        while(this.userAnswer == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.userAnswer);
        if(this.puzzleQuestion.checkAnswer(this.userAnswer)){
            // TODO: make good things happen
        } else {
            // TODO: make bad things happen
        }
        System.out.println(this.userAnswer);
        this.userAnswer = null;

        // TODO: return to floor
    }

    public void asnwerQuestion(String answer) {
        this.userAnswer = answer;
    }
}
