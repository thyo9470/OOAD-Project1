package Rooms;

import Entities.Enemy;
import Entities.Entity;

public class EnemyRoom extends Room{

    private Enemy enemy;

    /**
     * Sets enemy for room
     * @param enemy: newEnemy
     */
    public void setEnemy(Enemy enemy){ this.enemy = enemy; }

    /**
     * Enters battle when player comes across enemy
     * @param entity: currentEntity
     */
    public void interact(Entity entity){

        entity.battle(this.enemy);

    }

}
