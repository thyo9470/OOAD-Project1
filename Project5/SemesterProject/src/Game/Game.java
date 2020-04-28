package Game;

import Entities.Entity;
import Entities.Player;
import Factories.FloorFactory;
import Graphics.GraphicsHandler;
import Interactions.Interactable;
import Items.Helmet;
import Items.Item;
import Items.MainHand;
import Items.Skills.DamageAbility;
import Items.Skills.RecoverManaAbility;
import Items.Skills.Skill;
import Rooms.Floor;
import Rooms.Puzzle;
import Rooms.Room;
import Rooms.TrapRoom;

import java.util.ArrayList;

public class Game extends Interactable {
    static final private int LAST_LEVEL = 5;
    static private int currentLevel = 1;
    static private boolean gameOver = false;
    static private boolean winGame = false;

    static public int getLastLevel() {
        return LAST_LEVEL;
    }
    static public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Increases the current level
     */
    static public void levelUp() {
        currentLevel++;
    }

    /**
     * @return boolean: checks for game over
     */
    static public boolean getGameOver() {
        return gameOver;
    }

    /**
     * Set game over to true
     */
    static public void setGameOver(){
        gameOver = true;
    }

    /**
     * @return boolean: checks if player won
     */
    static public boolean getWinGame() {
        return winGame;
    }

    /**
     * set win game to indicate the player winning
     */
    static public void setWinGame() {
        winGame = true;
    }

    public static void main(String[] args) {

        // create Game and display
        GraphicsHandler graphicsHandler = new GraphicsHandler();
        Interactable game = new Game(graphicsHandler);

    }

    private GraphicsHandler graphicsHandler;

    public Game(GraphicsHandler graphicsHandler){
        this.graphicsHandler = graphicsHandler;
        graphicsHandler.drawGameMenu(this);
    }

    /**
     * setups and starts the game:
     *  - create floorFactory and create floor
     *  - create player and equip basic items
     *  - register all Interactable objects with the graphicsHandler
     *  - changes to floor view
     */
    public void startGame() {
        // Create floor factory and floor
        FloorFactory floorFactory = new FloorFactory();

        Interactable floor = floorFactory.makeFloor();

        // create Player
        Interactable player = new Player("player");
        Skill hatSkill = new Skill("Sit on head");
        RecoverManaAbility recoverManaAbility = new RecoverManaAbility("Recover 20 mana", 20, 0, 0);
        hatSkill.addAbility(recoverManaAbility);
        Item hat = new Helmet("hat", hatSkill, 0, 10);
        ((Entity)player).equipItem(hat);

        // equip main hand item
        Skill swordSkill = new Skill("stab");
        DamageAbility damageAbility = new DamageAbility("10 base damage", 10, 20, 0);
        swordSkill.addAbility(damageAbility);
        Item sword = new MainHand("Sword", swordSkill, 10, 0);
        ((Entity)player).equipItem(sword);

        ((Floor)floor).setPlayer((Player)player);

        this.graphicsHandler.setInteractable(floor);
        floor.registerObserver(this.graphicsHandler);


        for(ArrayList<Room> roomRow : ((Floor)floor).getRoomMap()) {
            for(Room room : roomRow){
                if(room instanceof TrapRoom){
                    Puzzle puzzle = ((TrapRoom)room).getPuzzle();
                    puzzle.registerObserver(this.graphicsHandler);
                }
            }
        }

        player.registerObserver(this.graphicsHandler);
        this.registerObserver(this.graphicsHandler);

        this.setNextIntractable(floor);
        this.notifyObserver();
    }
}
