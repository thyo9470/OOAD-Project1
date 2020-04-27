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
    final private int ROWS = 10;
    final private int COLS = 12;

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

    public void nextLevel() {
        // do next level sthuff
    }

    public void makeMove(Room room) {
        if(room.isFloorEnd()){
            if(Game.getCurrentLevel() == Game.getLastLevel()){
                Game.setWinGame();
                this.setNextIntractable(this);
            }else {
                Interactable newFloor = this.floorFactory.makeFloor();
                ((Floor)newFloor).setPlayer((Player)this.player);
                ((Player)this.player).setPos(new int[]{-1,-1});
                Game.levelUp();
                newFloor.registerObserver(this.graphicsHandler);
                this.setNextIntractable(newFloor);
                for(ArrayList<Room> roomRow : ((Floor)newFloor).getRoomMap()) {
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
        if(room instanceof TrapRoom){
            Puzzle puzzle = ((TrapRoom)room).getPuzzle();
            this.setNextIntractable(puzzle);
            puzzle.setFloor(this);
        } else {
            this.setNextIntractable(this.player);
        }
        room.enterRoom(this.player);
    }

}
