package Rooms;

import Interactions.Interactable;
import Interactions.Observer;

public class Puzzle extends Interactable {


    private String PuzzleQuestion;

    /**
     *
     * @return question string
     */
    public String getQuestion(){
        //reutrns question
        return PuzzleQuestion;
    }

    /**
     * calls the actual question/puzzle
     */

    public void askQuestion(){
        //asks the player the question

    }

    /**
     *  void checkanswer to question/puzzle
     */

    public void checkAnswer(){
        //checks the answer of the question right vs wrong
    }

    @Override
    public void registerObserver(Observer observer){

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObserver() {

    }
}
