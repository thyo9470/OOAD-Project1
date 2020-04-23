package Graphics;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;
import Game.Game;
import Interactions.Interactable;
import Interactions.Observer;
import Items.Helmet;
import Items.Item;
import Items.MainHand;
import Items.Skills.DamageAbility;
import Items.Skills.RecoverManaAbility;
import Items.Skills.Skill;
import Items.Skills.SkillAbility;

import javax.swing.*;

public class GraphicsHandler implements Observer {

    private Interactable interactable;
    private Graphics initialGraphics;
    private JFrame frame;
    private final int HEIGHT = 800;
    private final int WIDTH = 1000;
    private final String GAME_TITLE = "ADVENTURE GAME THE GAME";

    public static void main(String[] args) {

        // create Game
        Interactable game = new Game();

        // create Player
        Interactable player = new Player("player");
        Skill hatSkill = new Skill("Sit on head");
        RecoverManaAbility recoverManaAbility = new RecoverManaAbility("Recover mana", 20, 0, 0);
        Item hat = new Helmet("hat", hatSkill);
        ((Entity)player).equipItem(hat);

        // equip main hand item
        Skill swordSkill = new Skill("stab");
        DamageAbility damageAbility = new DamageAbility("Ouch", 10, 20, 0);
        swordSkill.addAbility(damageAbility);
        Item sword = new MainHand("Sword", swordSkill);
        ((Entity)player).equipItem(sword);


        Interactable enemy = new Enemy("enemy");
        //((Entity)player).setEnemy((Entity)enemy);


        GraphicsHandler graphicsHandler = new GraphicsHandler();
        graphicsHandler.drawGameMenu(game);
        graphicsHandler.interactable = player;
        player.registerObserver(graphicsHandler);

        ((Entity) player).battle((Entity) enemy);

    }

    public GraphicsHandler() {

        this.frame = new JFrame(GAME_TITLE);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setSize(WIDTH, HEIGHT);

        // create graphics components
        Graphics FloorGraphics = new FloorGraphics();
        Graphics EntityGraphics = new EntityGraphics();
        Graphics PuzzleGraphics = new PuzzleGraphics();
        Graphics GameGraphics = new GameGraphics();

        // Create chain of command
        this.initialGraphics = FloorGraphics;
        FloorGraphics.setSuccessor(EntityGraphics);
        EntityGraphics.setSuccessor(PuzzleGraphics);
        PuzzleGraphics.setSuccessor(GameGraphics);

    }

    /**
     * Used at the start of the game to create the main menu
     *
     * @param game: Game
     */
    public void drawGameMenu(Interactable game) {
        initialGraphics.handle(game, frame);
    }

    /**
     *  Will return a user to the exploration floor after interacting with a room
     *
     */
    public void returnToFloor() {
        // TODO: implement when we have to move to previous graphics elements
    }

    /**
     * Will change the display when going from scene to scene
     * For example: going from main menu to exploration phase or going from exploration to battle
     *
     */
    private void changeDisplay() {

       this.frame.getRootPane().getContentPane().removeAll();

        this.initialGraphics.handle(this.interactable, frame);
        this.frame.repaint();
        this.frame.revalidate();

    }

    /**
     * When an interactable changes, this will update the display
     */
    @Override
    public void update() {
        this.changeDisplay();
    }
}

