package Factories;

import Game.Game;
import Rooms.*;
import Rooms.Floor;

import java.util.ArrayList;
import java.util.Random;

/**
 * SIMPLE FACTORY PATTERN
 * Acts as a simple factory for floors
 */
public class FloorFactory {

    private RoomFactory roomFactory;

    public FloorFactory(){
        this.roomFactory = new RoomFactory();
    }

    /**
     * Generates a floor object and populates it with rooms from the roomFactory
     *  - sets one of the rooms as the end room
     *  - sets the size of the floor depending on level
     * @return
     */
    public Floor makeFloor(){
        int rows = Game.getCurrentLevel() * 2;
        int cols = Game.getCurrentLevel() * 3;
        System.out.println(Game.getCurrentLevel());

        // Create room map for floor
        ArrayList<ArrayList<Room>> roomMap = new ArrayList<>();
        for(int x = 0; x < cols; x++){
            ArrayList<Room> roomRow = new ArrayList<>();
            for(int y = 0; y < rows; y++){
                roomRow.add(this.roomFactory.createRandomRoom());
            }
            roomMap.add(roomRow);
        }

        // select the end room
        Random rand = new Random();
        int exitY = rand.nextInt(rows - rows/2) + rows/2;
        int exitX = rand.nextInt(cols - cols/2) + cols/2;

        roomMap.get(exitX).get(exitY).setFloorEnd();

        Floor floor = new Floor(roomMap, this);

        return floor;
    }
}
