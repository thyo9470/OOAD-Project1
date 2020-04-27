package Factories;

import Entities.Enemy;

public class EnemyFactory {

    private ItemFactory itemFactory;

    public EnemyFactory(ItemFactory itemFactory) {
       this.itemFactory = itemFactory;
    }

    public Enemy createEnemy(){

        // TODO: Make sure the enemies have both defense and attack
        // since one item will pretty much assign only one they end up either being really week or having not attack
        Enemy enemy = new Enemy("enemy");
        enemy.equipItem(itemFactory.createItem());

        return enemy;
    }
}
