package Factories;

import Entities.Enemy;

import java.util.Random;

public class EnemyFactory {

    private ItemFactory itemFactory;

    public EnemyFactory(ItemFactory itemFactory) {
       this.itemFactory = itemFactory;
    }

    public Enemy createEnemy(){

        Random rand = new Random();
        double random = rand.nextDouble();
        Enemy enemy = new Enemy("enemy");
        if(random < 0.5){
            enemy.equipItem(itemFactory.createNewItem("Helmet"));
        }
        else{
            enemy.equipItem(itemFactory.createNewItem("OffHand"));
        }
        return enemy;
    }
}
