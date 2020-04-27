package Factories;

import Entities.Enemy;
import Items.Item;

public class EnemyFactory {

    private EnemyFactory factory;
    private ItemFactory fact;

    public EnemyFactory(EnemyFactory factory){
        this.factory = factory;
    }

    public Enemy createEnemy(){

        Enemy enemy = new Enemy("enemy");
        enemy.setRewardItem(fact.createItem());
        return enemy;
    }
}
