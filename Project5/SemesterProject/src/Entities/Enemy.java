package Entities;

import Items.Item;
import Items.Skills.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity{

    public Enemy(String description) {
        super(description);
    }

    @Override
    public void promptSwap(Item newItem) {
        // TODO: create way for enemy to swap item
    }

    public Item getRewardItem() {
        Random rand = new Random();
        return this.getItems().get(rand.nextInt(this.getItems().size()));
    }

    /**
     * Currently randomly selects a skill from it's items and uses it
     * TODO: make this not suck ( implement some kind of AI )
     *
     * @return The skill the enemy wants to use
     */
    @Override
    protected Skill makeMove() {
        ArrayList<Skill> skills = getSkills();
        Random rand = new Random();
        int selectIndex = rand.nextInt(skills.size());
        Skill selectedSkill = skills.get(selectIndex);
        return selectedSkill;
    }

    public void battle(Entity opponent) {
        this.enemy = opponent;

        Skill selectedSkill = this.makeMove();
        int tries = 0;
        int maxTries = 10;
        while((this.getMana() - selectedSkill.getManaCost()) < 0 || (this.getHealth() - selectedSkill.getHealthCost()) <= 0) {
            tries++;
            if(tries > maxTries){
                break;
            }
            selectedSkill = this.makeMove();
        }
        if(tries < maxTries) {
            selectedSkill.activate(this, opponent);
        }

        if(opponent.getHealth() <= 0) {
            // TODO: enemy wins
        } else {
            opponent.battle(this);
        }
    }



}
