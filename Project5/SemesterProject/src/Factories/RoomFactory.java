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
        if(random < 0.2){
            return new TreasureRoom();
        }
        else if(random < 0.4){
            return new TrapRoom();
        }
        else{
            return new EnemyRoom();
        }
    }

    public Room createRoom(String roomtype){

        if(roomtype == "Enemy"){
            return new EnemyRoom();
        }
        else if(roomtype == "Puzzle"){
            return new TrapRoom();
        }
        else if(roomtype == "Treasure"){
            return new TreasureRoom();
        }
        return new EnemyRoom();
    }

}
