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
        return skills.get(0);
    }

}
