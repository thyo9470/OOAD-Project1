package Graphics;

import Interactions.Interactable;
import Interactions.Observer;

import javax.swing.*;

public class GraphicsHandler implements Observer {

    private Interactable interactable;
    private Graphics initialGraphics;
    private JFrame frame;
    private final int HEIGHT = 900;
    private final int WIDTH = 1800;
    private final String GAME_TITLE = "ADVENTURE GAME THE GAME";

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
    public void setInteractable(Interactable interactable) {
        this.interactable = interactable;
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

        if (this.interactable.getChangeState()){
            this.interactable = this.interactable.getNextIntractable();
        }

        this.changeDisplay();
    }
}

