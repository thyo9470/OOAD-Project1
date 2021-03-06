package Entities;

import Items.Item;
import Items.Skills.Skill;

import java.util.ArrayList;

public class Player extends Entity{

    private Skill skillToUse = null;
    private Item itemToUse = null;

    public Player(String description){
        super(description);
    }

    /**
     * Waits for user input from display and return the selected skill
     *
     * @return
     */
    @Override
    protected Skill makeMove() {

        ArrayList<Skill> skills = getSkills();
        this.skillToUse = null;
        while(this.skillToUse == null) {
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
        Skill selectedSkill = this.skillToUse;
        return selectedSkill;
    }


    /**
     * Has entity take their turn in a battle
     *
     * @param opponent - who the entity is fighting
     */
    @Override
    public void battle(Entity opponent) {

        this.enemy = opponent;

        this.notifyObserver();

        Skill selectedSkill = this.makeMove();
        while((this.getMana() - selectedSkill.getManaCost()) < 0 || (this.getHealth() - selectedSkill.getHealthCost()) <= 0) {
            selectedSkill = this.makeMove();
        }
        selectedSkill.activate(this, opponent);

        if (opponent.getHealth() <= 0) {
            if (opponent instanceof Enemy) {
                Item reward = ((Enemy)opponent).getRewardItem();
                this.promptSwap(reward);
            }
        } else {
            opponent.battle(this);
        }
    }

    /**
     * Ask a user if they want to swap the item equipped for the given item
     * NOTE: This will require the graphics element for confirmation
     *
     * @param newItem
     */
    public void promptSwap(Item newItem){
        this.swappingItem = newItem;
        this.notifyObserver();
        if(this.getMatchingItem(newItem) != null) {
            while(this.itemToUse == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.equipItem(this.itemToUse);
        } else {
            this.equipItem(newItem);
        }
        this.itemToUse = null;
        this.swappingItem = null;
        this.returnToFloor();
    }

    /**
     * This function is used by the display to tell the user what skill to use
     *
     * @param skillToUse: Skill
     */
    public void setSkillToUse(Skill skillToUse) {
        this.skillToUse = skillToUse;
    }

    /**
     * Used to get input from GUI for swapping items
     *
     * @param itemToUse: Item
     */
    public void setItemToUse(Item itemToUse) {
        this.itemToUse = itemToUse;
    }
}
