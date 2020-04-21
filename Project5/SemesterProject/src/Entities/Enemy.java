package Entities;

import Interactions.Observer;
import Items.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity{

    public Enemy(String description) {
        super(description);
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



}
