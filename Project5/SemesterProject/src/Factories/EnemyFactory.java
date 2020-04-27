package Factories;

import Entities.Enemy;

import java.util.Random;

public class EnemyFactory {

    private ItemFactory itemFactory;

    public EnemyFactory(ItemFactory itemFactory) {
       this.itemFactory = itemFactory;
    }

    public Enemy createEnemy(){

        Enemy enemy = new Enemy("enemy");
        enemy.equipItem(itemFactory.enemyDefaultItem());
        enemy.equipItem(itemFactory.createItem());
        return enemy;
    }
}
