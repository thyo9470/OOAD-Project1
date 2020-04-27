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
                if(y % 3 == 0) {
                    EnemyRoom enemyRoom = new EnemyRoom();

                    Enemy enemy = new Enemy("enemy");
                    Skill knifeSkill = new Skill("stab");
                    DamageAbility damageAbility = new DamageAbility("10 base damage", 10, 20, 0);
                    knifeSkill.addAbility(damageAbility);
                    Item knife = new MainHand("knife", knifeSkill);
                    ((Enemy)enemy).setRewardItem(knife);

                    enemyRoom.setEnemy(enemy);

                    roomRow.add(enemyRoom);
                } else if (y % 4 == 0){
                    TrapRoom trapRoom = new TrapRoom();
                    PuzzleQuestion puzzleQuestion = new PuzzleQuestion();
                    Puzzle puzzle = new Puzzle(puzzleQuestion);
                    trapRoom.setPuzzle(puzzle);
                    roomRow.add(trapRoom);
                } else {
                    TreasureRoom treasureRoom = new TreasureRoom();
                    Skill hatSkill = new Skill("Sit on head");
                    RecoverManaAbility recoverManaAbility = new RecoverManaAbility("Recover 20 mana", 20, 0, 0);
                    hatSkill.addAbility(recoverManaAbility);
                    Item hat = new Helmet("hat 2.0", hatSkill);
                    treasureRoom.setItem(hat);
                    roomRow.add(treasureRoom);
                }
            }
            this.roomMap.add(roomRow);
        }

        return floor;
    }
}
