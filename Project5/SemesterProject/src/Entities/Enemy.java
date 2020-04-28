package Entities;

import Items.Item;
import Items.Skills.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity{

    public Enemy(String description) {
        super(description);
    }

    /**
     * Used to swap items in an enemy class
     * Currently just equips it with no though
     * Future: smart selection
     *
     * @param newItem: Item
     */
    @Override
    public void promptSwap(Item newItem) {
        this.equipItem(newItem);
    }

    /**
     * selects a random equipped to be the reward item when the entity dies
     *
     * @return Item
     */
    public Item getRewardItem() {
        Random rand = new Random();
        return this.getItems().get(rand.nextInt(this.getItems().size()));
    }

    /**
     * Currently randomly selects a skill from it's items and uses it
     *  Future; implement smart selection of enemy moves
     *      - min-max tree. This would be good to vary difficulty too by varying tree depth
     *
     * @return Skill: The skill the enemy wants to use
     */
    @Override
    protected Skill makeMove() {
        ArrayList<Skill> skills = getSkills();
        Random rand = new Random();
        int selectIndex = rand.nextInt(skills.size());
        Skill selectedSkill = skills.get(selectIndex);
        return selectedSkill;
    }

    /**
     * Prompts the enemy to make a move that will not cause them to kill themselves or go below 0 mana
     * After using their move they call their opponent to take their turn
     *
     * @param opponent - who the entity is fighting
     */
    public void battle(Entity opponent) {
        this.enemy = opponent;

        // select move to use
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

        // pass turn
        if(opponent.getHealth() <= 0) {
            opponent.returnToFloor();
        } else {
            opponent.battle(this);
        }
    }



}
