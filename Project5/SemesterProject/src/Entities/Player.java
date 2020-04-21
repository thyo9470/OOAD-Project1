package Entities;

import Items.Skill;

import java.util.ArrayList;

public class Player extends Entity{

    public Player(String description){
        super(description);
    }

    @Override
    protected Skill makeMove() {

        ArrayList<Skill> skills = getSkills();
        Skill selectedSkill = skills.get(0);
        System.out.println(this.getClass().getSimpleName() + " used: " + selectedSkill.getDescription());
        return selectedSkill;
    }

}
