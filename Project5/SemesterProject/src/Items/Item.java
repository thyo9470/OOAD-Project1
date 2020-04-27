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

    public Item(String description, Skill skill) {
        this.attack = 10;
        this.defense = 20;
        this.skill = skill;
        this.description = description;
    }

    @Override
    public String toString(){

       String fullDescription = "<u>" + this.description + "</u><br>";

        fullDescription += "<br>Attack: " + this.attack;
        fullDescription += "<br>Defense: " + this.defense;
        fullDescription += "<br><br><u>Skill</u>: " + this.skill.getDescription();
        for(SkillAbility ability: this.skill.getSkillAbilities()){
            fullDescription += "<br>" + ability.getClass().getSimpleName() + ": " + ability.getDescription();
        }

        fullDescription = "<html>" + fullDescription + "</html>";

        return fullDescription;
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
