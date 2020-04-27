package Rooms;

import Entities.Entity;
import Interactions.Interactable;
import Items.Item;

public class Puzzle extends Interactable {

    private PuzzleQuestion puzzleQuestion;
    private Item rewardItem;
    private Entity entity;
    private int damage;

    public Puzzle(PuzzleQuestion puzzleQuestion){
        this.puzzleQuestion = puzzleQuestion;
        this.damage = 500;
    }

    public void setRewardItem(Item rewardItem) {
        this.rewardItem = rewardItem;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
     * Waits for answer
     * If correct: give item
     * if wrong: damage player
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
            if(this.rewardItem != null) {
                this.setNextIntractable(entity);
                entity.promptSwap(this.rewardItem);
            }
        } else {
            System.out.println(this.damage);
            entity.damage(this.damage);
        }
        this.puzzleQuestion.setAnswer(null);

        this.returnToFloor();
    }

    /**
     * used by graphics to give an answer to the question
     *
     * @param answer:String
     */
    public void answerQuestion(String answer) {
        this.puzzleQuestion.setAnswer(answer);
    }
}
