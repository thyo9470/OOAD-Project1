package Items;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;
import Items.Skills.Skill;

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
