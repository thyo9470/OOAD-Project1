package Items;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;

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

    public static void main(String[] args) {

       // equipping items
        Entity thomas = new Player("Thomas");

        // equip helmet
        Skill hatSkill = new Skill("Sit on head", false, -10, 10);
        Item hat = new Helmet("hat", hatSkill);

        thomas.equipItem(hat);

        // swap for different helmet
        Skill biggerHatSkill = new Skill("absorb head", true, 10, 10);
        Item biggerHat = new Helmet("BiggerHat", biggerHatSkill);

        thomas.equipItem(biggerHat);

        // equip main hand item
        Skill swordSkill = new Skill("stab", true, 7, 5);
        Item sword = new MainHand("Sword", swordSkill);

        thomas.equipItem(sword);

        // battle
        Entity enemy = new Enemy("Big Bad Boy");
        Item sword2 = new MainHand("Sword", swordSkill);
        Item hat2 = new Helmet("HAT!!!", hatSkill);
        Skill ringSkill = new Skill("regain mana", false, 0, -10);
        Item ring = new OffHand("ring", ringSkill);
        enemy.equipItem(sword2);
        enemy.equipItem(hat2);
        enemy.equipItem(ring);
        System.out.println(enemy.getDescription());
        thomas.battle(enemy);
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
