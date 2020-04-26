package Rooms;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;
import Graphics.GraphicsHandler;
import Interactions.Interactable;
import Items.Helmet;
import Items.Item;
import Items.MainHand;
import Items.Skills.DamageAbility;
import Items.Skills.RecoverManaAbility;
import Items.Skills.Skill;

import java.util.ArrayList;

public class Floor extends Interactable {

    public static void main(String[] args) {

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

    }

    // private FloorFactory floorFactory; TODO: make floor factory
    private ArrayList<ArrayList<Room>> roomMap;
    private Player player;
    final private int ROWS = 10;
    final private int COLS = 12;

    public Floor() {

        this.roomMap = new ArrayList<>();
        for(int x = 0; x < this.COLS; x++){
            ArrayList<Room> roomRow = new ArrayList<>();
            for(int y = 0; y < this.ROWS; y++){
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

        // create Player
        Interactable player = new Player("player");
        Skill hatSkill = new Skill("Sit on head");
        RecoverManaAbility recoverManaAbility = new RecoverManaAbility("Recover 20 mana", 20, 0, 0);
        hatSkill.addAbility(recoverManaAbility);
        Item hat = new Helmet("hat", hatSkill);
        ((Entity)player).equipItem(hat);

        // equip main hand item
        Skill swordSkill = new Skill("stab");
        DamageAbility damageAbility = new DamageAbility("10 base damage", 10, 20, 0);
        swordSkill.addAbility(damageAbility);
        Item sword = new MainHand("Sword", swordSkill);
        ((Entity)player).equipItem(sword);

        this.player = ((Player)player);
    }

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
