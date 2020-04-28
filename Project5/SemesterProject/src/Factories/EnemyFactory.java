package Factories;

import Entities.Enemy;

/**
 * SIMPLE FACTORY PATTERN
 * Acts as a simple factory for enemies
 */
public class EnemyFactory {

    private ItemFactory itemFactory;

    public EnemyFactory(ItemFactory itemFactory) {
       this.itemFactory = itemFactory;
    }

    /**
     * Creates an enemy based on the current game level
     * @return
     */
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
