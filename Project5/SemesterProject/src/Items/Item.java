package Items;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;
import Items.Skills.Skill;
import Items.Skills.SkillAbility;

abstract public class Item{

    private Skill skill;
    private int attack;
    private int defense;
    private String description;

    public Item(String description, Skill skill, int attack, int defense) {
        this.attack = attack;
        this.defense = defense;
        this.skill = skill;
        this.description = description;
    }

    @Override
    public String toString(){

       description = "<u>" + this.description + "</u><br>";

        description += "<br>Attack: " + this.attack;
        description += "<br>Defense: " + this.defense;
        description += "<br><br><u>Skill</u>: " + this.skill.getDescription();
        for(SkillAbility ability: this.skill.getSkillAbilities()){
            description += "<br>" + ability.getClass().getSimpleName() + ": " + ability.getDescription();
        }

        description = "<html>" + description + "</html>";

        return description;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String getDescription() {
       return this.description;
    }

    public Skill getSkill() {
        return skill;
    }
}
