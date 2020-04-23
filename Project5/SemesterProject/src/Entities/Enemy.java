package Entities;

import Items.Item;
import Items.Skills.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity{

    private Item rewardItem;

    public Enemy(String description) {
        super(description);
    }

    @Override
    public void promptSwap(Item newItem) {
        // TODO: create way for enemy to swap item
    }

    // TODO: delete maybe depending on what john has
    public void setRewardItem(Item rewardItem) {
        this.rewardItem = rewardItem;
    }

    public Item getRewardItem() {
        return rewardItem;
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
        System.out.println(this.getClass().getSimpleName() + " used: " + selectedSkill.getDescription());
        return selectedSkill;
    }

    public void battle(Entity opponent) {
        this.enemy = opponent;

        Skill testSkill = this.makeMove();
        testSkill.activate(this, opponent);

        if(opponent.getHealth() <= 0) {
            // TODO: enemy wins
        } else {
            opponent.battle(this);
        }
    }



}
