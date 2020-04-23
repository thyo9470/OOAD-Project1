package Entities;

import Items.Skills.Skill;

import java.util.ArrayList;

public class Player extends Entity{

    private int skillIndex = -1;
    private Skill skillToUse = null;

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
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
        Skill selectedSkill = this.skillToUse;
        System.out.println(this.getClass().getSimpleName() + " used: " + selectedSkill.getDescription()); // TODO: delete when done
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
        if((this.getMana() - selectedSkill.getManaCost()) > 0 && (this.getHealth() - selectedSkill.getHealthCost()) > 0) {
            selectedSkill.activate(this, opponent);

            if (opponent.getHealth() <= 0) {
                System.out.println(this.getClass().getSimpleName() + " Wins!"); // TODO: change this to go back to the floor
            } else {
                opponent.battle(this);
            }
        }
    }

    /**
     * This function is used by the display to tell the user what skill to use
     *
     * @param skillToUse
     */
    public void setSkillToUse(Skill skillToUse) {
        this.skillToUse = skillToUse;
    }
}
