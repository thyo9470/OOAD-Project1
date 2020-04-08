package Game;

public class Game {
    static private int lastLevel;
    static private int currentLevel;

    static public int getLastLevel() {
        return lastLevel;
    }
    static public int getCurrentLevel() {
        return currentLevel;
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
}
