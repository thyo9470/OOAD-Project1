package Factories;

import Rooms.EnemyRoom;
import Rooms.Room;
import Rooms.TrapRoom;
import Rooms.TreasureRoom;

import java.util.Random;

/**
 * SIMPLE FACTORY PATTERN
 * Acts as a simple factory for rooms
 */
public class RoomFactory {

    //References to specific room type factories
    private EnemyFactory enemyFactory;
    private ItemFactory itemFactory;
    private PuzzleFactory puzzleFactory;

    public RoomFactory(){
        this.itemFactory = new ItemFactory();
        this.enemyFactory = new EnemyFactory(itemFactory);
        this.puzzleFactory = new PuzzleFactory(itemFactory);
    }

    /**
     * Creates random room objects
     *  - 10% treasure room
     *  - 40$ trap room
     *  - 50% enemy room
     * @return Room
     */
    public Room createRandomRoom(){
        Random rand = new Random();
        double random = rand.nextDouble();
        if(random < 0.1){
            TreasureRoom treasureRoom = new TreasureRoom();
            treasureRoom.setItem(itemFactory.createItem());
            return treasureRoom;
        }
        else if(random < 0.4){
            TrapRoom puzzleRoom = new TrapRoom();
            puzzleRoom.setPuzzle(puzzleFactory.createPuzzle());
            return puzzleRoom;
        }
        else{
            EnemyRoom enemyRoom = new EnemyRoom();
            enemyRoom.setEnemy(enemyFactory.createEnemy());
            return enemyRoom;
        }
    }

    /**
     * Creates the room of a given type
     * @param roomtype: String - indicate what room is desired
     * @return Room
     */
    public Room createRoom(String roomtype){

        if(roomtype.equals("Enemy")){
            return new EnemyRoom();
        }
        else if(roomtype.equals("Puzzle")){
            return new TrapRoom();
        }
        else if(roomtype.equals("Treasure")){
            return new TreasureRoom();
        }
        return new EnemyRoom();
    }

}
