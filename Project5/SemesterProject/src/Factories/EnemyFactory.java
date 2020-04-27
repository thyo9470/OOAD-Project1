package Factories;

import Entities.Enemy;

import java.util.Random;

public class EnemyFactory {

    private ItemFactory itemFactory;

    public EnemyFactory(ItemFactory itemFactory) {
       this.itemFactory = itemFactory;
    }

    public Enemy createEnemy(){

        int level = Game.Game.getCurrentLevel();
        Enemy enemy = new Enemy("enemy");
        enemy.equipItem(itemFactory.enemyDefaultItem());
        for(int i = 1; i < level; i++){
            enemy.equipItem(itemFactory.createItem());
        }
        return enemy;
    }
}
