package Factories;

import Entities.Enemy;
import Interactions.Interactable;
import Items.Helmet;
import Items.Item;
import Items.MainHand;
import Items.Skills.DamageAbility;
import Items.Skills.RecoverManaAbility;
import Items.Skills.Skill;
import Rooms.*;
import Rooms.Floor;

import java.util.ArrayList;

public class FloorFactory {

    private RoomFactory RoomFactory;
    private FloorFactory factory;
    private ArrayList<ArrayList<Room>> roomMap;
    final private int ROWS = 10;
    final private int COLS = 12;

    public FloorFactory(FloorFactory factory){
        this.factory = factory;
    }

    public Interactable makeFloor(){

        roomMap = new ArrayList<>();
        for(int x = 0; x < COLS; x++){
            ArrayList<Room> roomRow = new ArrayList<>();
            for(int y = 0; y < ROWS; y++){
                roomRow.add(RoomFactory.createRandomRoom());
            }
            this.roomMap.add(roomRow);
        }

        Interactable floor = new Floor(roomMap);

        return floor;
    }
}
