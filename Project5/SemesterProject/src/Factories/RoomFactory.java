package Factories;

import Rooms.EnemyRoom;
import Rooms.Room;
import Rooms.TrapRoom;
import Rooms.TreasureRoom;

import java.util.Random;

public class RoomFactory {

    //References to specific room type factories
    private EnemyFactory EnemyFactory;
    private ItemFactory ItemFactory;
    private PuzzleFactory PuzzleFactory;
    private RoomFactory factory;

    public RoomFactory(RoomFactory factory){
        this.factory = factory;
    }

    public Room createRandomRoom(){
        Random rand = new Random();
        double random = rand.nextDouble();
        if(random < 0.1){
            TreasureRoom treasureRoom = new TreasureRoom();
            treasureRoom.setItem(ItemFactory.createItem());
            return treasureRoom;
        }
        else if(random < 0.4){
            TrapRoom puzzleRoom = new TrapRoom();
            puzzleRoom.setPuzzle(PuzzleFactory.createPuzzle());
            return puzzleRoom;
        }
        else{
            EnemyRoom enemyRoom = new EnemyRoom();
            enemyRoom.setEnemy(EnemyFactory.createEnemy());
            return enemyRoom;
        }
    }

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
