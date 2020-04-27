package Factories;

import Entities.Entity;
import Graphics.GraphicsHandler;
import Interactions.Interactable;
import Rooms.Floor;
import Rooms.Puzzle;
import Rooms.Room;
import Rooms.TrapRoom;

import java.util.ArrayList;

public class FloorFactory {

    private RoomFactory RoomFactory;
    private FloorFactory factory;

    public FloorFactory(FloorFactory factory){
        this.factory = factory;
    }

    public Interactable makeRoomFactory(){

        Interactable floor = new Floor();

        GraphicsHandler graphicsHandler = new GraphicsHandler();
        graphicsHandler.setInteractable(floor);
        floor.registerObserver(graphicsHandler);

        for(ArrayList<Room> roomRow : ((Floor)floor).getRoomMap()) {
            for(Room room : roomRow){
                if(room instanceof TrapRoom){
                    Puzzle puzzle = ((TrapRoom)room).getPuzzle();
                    puzzle.registerObserver(graphicsHandler);
                }
            }
        }

        Entity player = ((Floor) floor).getPlayer();
        player.registerObserver(graphicsHandler);

        graphicsHandler.changeDisplay();
        return floor;
    }
}
