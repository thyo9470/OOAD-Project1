package Rooms;

import Entities.Player;
import Interactions.Interactable;

import java.util.ArrayList;

public class Floor extends Interactable {

    // private FloorFactory floorFactory; TODO: make floor factory
    private ArrayList<ArrayList<Room>> roomMap;
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setRoomMap(ArrayList<ArrayList<Room>> roomMap) {
        this.roomMap = roomMap;
    }

    public ArrayList<ArrayList<Room>> getRoomMap() {
        return roomMap;
    }

    public void nextLevel() {
        // do next level sthuff
    }

    public void makeMove(Room room) {
        // make player move to shtuff
    }

}
