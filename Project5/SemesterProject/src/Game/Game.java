package Game;

import Graphics.GraphicsHandler;
import Interactions.Interactable;
import Interactions.Observer;

public class Game extends Interactable {
    static private int lastLevel;
    static private int currentLevel;

    static public int getLastLevel() {
        return lastLevel;
    }
    static public int getCurrentLevel() {
        return currentLevel;
    }

    // TODO: delete when done testing
    public static void main(String[] args) {

        // create Game
        Interactable game = new Game();

        GraphicsHandler graphicsHandler = new GraphicsHandler();
        graphicsHandler.drawGameMenu(game);

    }

    static public void levelUp() {
        // level up i assume is just:
        currentLevel++;
    }

    private void setupGame() {
        // setup game objects and stuff
    }

    private void startGame() {
        // start game
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObserver() {

    }
}
