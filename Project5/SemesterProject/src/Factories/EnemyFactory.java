package Factories;

import Entities.Enemy;

public class EnemyFactory {

    private EnemyFactory factory;

    public EnemyFactory(EnemyFactory factory){
        this.factory = factory;
    }

    public Enemy createEnemy(String enemyType){

        return new Enemy(enemyType);
    }
}
