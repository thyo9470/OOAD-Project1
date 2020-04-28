package Rooms;

import Entities.Player;
import Factories.FloorFactory;
import Game.Game;
import Interactions.Interactable;

import java.util.ArrayList;

public class Floor extends Interactable {

    private FloorFactory floorFactory;
    private ArrayList<ArrayList<Room>> roomMap;
    private Player player;

    public Floor(ArrayList<ArrayList<Room>> roomMap, FloorFactory floorFactory) {

        this.roomMap = roomMap;
        this.floorFactory = floorFactory;

    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<ArrayList<Room>> getRoomMap() {
        return roomMap;
    }

    /**
     * Given a room the floor determines how to interact with it:
     *  - win game
     *  - go to next level
     *  - run interact function with room and update display
     * @param room
     */
    public void makeMove(Room room) {
        if(room.isFloorEnd()){
            if(Game.getCurrentLevel() == Game.getLastLevel()){
                Game.setWinGame();
                this.setNextIntractable(this);
            }else {
                Game.levelUp();
                Floor newFloor = this.floorFactory.makeFloor();
                newFloor.setPlayer(this.player);
                (this.player).resetPos();
                newFloor.registerObserver(this.graphicsHandler);
                this.setNextIntractable(newFloor);
                for(ArrayList<Room> roomRow : newFloor.getRoomMap()) {
                    for(Room roomlet : roomRow){
                        if(roomlet instanceof TrapRoom){
                            Puzzle puzzle = ((TrapRoom)roomlet).getPuzzle();
                            puzzle.registerObserver(this.graphicsHandler);
                        }
                    }
                }
            }
            this.notifyObserver();
            return;
        }

        room.visit();
        this.player.setFloor(this);
        this.setNextIntractable(this.player);

        if(room instanceof TrapRoom){
            Puzzle puzzle = ((TrapRoom)room).getPuzzle();
            puzzle.setEntity(this.player);
            this.setNextIntractable(puzzle);
            puzzle.setFloor(this);
        }

        room.enterRoom(this.player);
    }

}
