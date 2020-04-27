package Factories;

import Interactions.Interactable;
import Rooms.*;
import Rooms.Floor;

import java.util.ArrayList;
import java.util.Random;

public class FloorFactory {

    private RoomFactory roomFactory;
    private ArrayList<ArrayList<Room>> roomMap;
    final private int ROWS = 10;
    final private int COLS = 12;

    public FloorFactory(){
        this.roomFactory = new RoomFactory();
    }

    public Interactable makeFloor(){

        // Create room map for floor
        roomMap = new ArrayList<>();
        for(int x = 0; x < COLS; x++){
            ArrayList<Room> roomRow = new ArrayList<>();
            for(int y = 0; y < ROWS; y++){
                roomRow.add(this.roomFactory.createRandomRoom());
            }
            this.roomMap.add(roomRow);
        }

        // select the end room
        Random rand = new Random();
        int exitY = rand.nextInt(this.ROWS - this.ROWS/2) + this.ROWS/2;
        int exitX = rand.nextInt(this.COLS - this.COLS/2) + this.COLS/2;
        exitY = 2;
        exitX = 2;

        roomMap.get(exitX).get(exitY).setFloorEnd();

        Interactable floor = new Floor(roomMap, this);

        return floor;
    }
}
