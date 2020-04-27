package Factories;

import Entities.Enemy;
import Items.Armor;
import Items.Item;
import Items.MainHand;
import Items.Skills.DamageAbility;
import Items.Skills.RecoverManaAbility;
import Items.Skills.Skill;

public class EnemyFactory {

    private ItemFactory fact;
    public Enemy createEnemy(){

        //Todo: add item variety for enemies
        Enemy enemy = new Enemy("enemy");
        enemy.equipItem(fact.createItem());

        return enemy;
    }
}
