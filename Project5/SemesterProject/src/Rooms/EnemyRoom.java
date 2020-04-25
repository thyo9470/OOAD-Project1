package Rooms;

public class EnemyRoom extends Room{

    private Entities.Enemy enemy;

    /**
     * Sets enemy for room
     * @param enemy: newEnemy
     */
    public void setEnemy(Entities.Enemy enemy){ this.enemy = enemy; }

    /**
     * Enters battle when player comes across enemy
     * @param entity: currentEntity
     */
    public void interact(Entities.Entity entity){

        entity.battle(this.enemy);

    }

}
