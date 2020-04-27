package Graphics;

import Entities.Entity;
import Game.Game;
import Interactions.Interactable;
import Items.Item;
import Rooms.Floor;
import Rooms.Room;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FloorGraphics extends Graphics {

    @Override
    protected void setInteractable(Interactable interactable) {
        if (interactable.getClass().equals(Floor.class)) {
            this.interactable = interactable;
        } else {
            throw new IllegalArgumentException("Input must be of type Floor");
        }
    }

    /**
     * given an empty JFrame, this displays everything for the exploration part of the game
     *  - this will also handle displaying the game over display
     *
     * @param frame: JFrame
     */
    @Override
    public void createDisplay(JFrame frame) {

        if (Game.getWinGame()){

            JPanel winGamePanel = new JPanel();
            winGamePanel.setLayout(new BoxLayout(winGamePanel, BoxLayout.Y_AXIS));

            JLabel winGameLabel = new JLabel("YOU WIN!!");
            winGameLabel.setFont (winGameLabel.getFont ().deriveFont (64.0f));
            winGameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton exitButton = new JButton("Exit");
            exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            exitButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    frame.dispose();
                }
            });

            winGamePanel.add(Box.createRigidArea(new Dimension(100, 100)));
            winGamePanel.add(winGameLabel);
            winGamePanel.add(Box.createRigidArea(new Dimension(100, 100)));
            winGamePanel.add(exitButton);

            frame.add(winGamePanel);

        } else if(Game.getGameOver()){

            JPanel gameOverPanel = new JPanel();
            gameOverPanel.setLayout(new BoxLayout(gameOverPanel, BoxLayout.Y_AXIS));

            JLabel gameOverLabel = new JLabel("GAME OVER");
            gameOverLabel.setFont (gameOverLabel.getFont ().deriveFont (64.0f));
            gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton exitButton = new JButton("Exit");
            exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            exitButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    frame.dispose();
                }
            });

            gameOverPanel.add(Box.createRigidArea(new Dimension(100, 100)));
            gameOverPanel.add(gameOverLabel);
            gameOverPanel.add(Box.createRigidArea(new Dimension(100, 100)));
            gameOverPanel.add(exitButton);

            frame.add(gameOverPanel);

        } else {
            Floor floor = (Floor) this.interactable;
            Entity entity = floor.getPlayer();

            JPanel leftPanel = this.createLeftPanel(entity);

            // Tile Map Panel
            JPanel tileMapPanel = this.createTileMapPanel(floor);

            frame.getContentPane().add(BorderLayout.EAST, leftPanel);
            frame.getContentPane().add(BorderLayout.CENTER, tileMapPanel);
        }

        frame.setVisible(true);
    }

    /**
     * Constructs the left panel of the exploration GUI which dispalys player stats and items
     *
     * @param entity: Entity
     * @return JPanel
     */
    private JPanel createLeftPanel(Entity entity) {

        // Info panel
        JPanel leftPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        JPanel entityInfoPanel = this.createEntityInfoPanel(entity);
        JPanel entityEquipementPanel = this.createEntityEquipmentPanel(entity);

        // Add info panels to left panel
        leftPanel.add(entityInfoPanel);
        leftPanel.add(entityEquipementPanel);

        return leftPanel;
    }

    /**
     * Constructs panel for left panel containing all the player information
     *
     * @param entity: Entity
     * @return JPanel
     */
    private JPanel createEntityInfoPanel(Entity entity) {

        // Entity Info
        JPanel entityInfoPanel = new JPanel();
        entityInfoPanel.setLayout(new BoxLayout(entityInfoPanel, BoxLayout.Y_AXIS));
        entityInfoPanel.setBackground(Color.lightGray);

        entityInfoPanel.add(Box.createRigidArea(new Dimension(100, 20)));

        JLabel currentLevel = new JLabel("Level: " + Integer.toString(Game.getCurrentLevel()));
        currentLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(currentLevel);

        entityInfoPanel.add(Box.createRigidArea(new Dimension(100, 30)));

        JLabel entityInfoTitle = new JLabel("Player Info");
        entityInfoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(entityInfoTitle);

        int health = entity.getHealth();
        int mana = entity.getMana();
        int attack = entity.getAttack();
        int defense = entity.getDefense();

        entityInfoPanel.add(Box.createRigidArea(new Dimension(100, 50)));

        JLabel healthLabel = new JLabel("Health: " + Integer.toString(health));
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(healthLabel);

        JLabel manaLabel = new JLabel("Mana: " + Integer.toString(mana));
        manaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(manaLabel);

        entityInfoPanel.add(Box.createRigidArea(new Dimension(100, 30)));

        JLabel attackLabel = new JLabel("Attack: " + Integer.toString(attack));
        attackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(attackLabel);

        JLabel defenseLabel = new JLabel("Defense: " + Integer.toString(defense));
        defenseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(defenseLabel);

        return entityInfoPanel;

    }

    /**
     * Creates equipment panel for left panel of exploration phase
     *
     * @param entity: Entity
     * @return JPanel
     */
    private JPanel createEntityEquipmentPanel(Entity entity) {

        // Entity Equipment
        JPanel entityEquipmentPanel = new JPanel();
        entityEquipmentPanel.setLayout(new BoxLayout(entityEquipmentPanel, BoxLayout.Y_AXIS));
        entityEquipmentPanel.setBackground(Color.lightGray);

        entityEquipmentPanel.add(Box.createRigidArea(new Dimension(100, 20)));

        JLabel equipmentTitle = new JLabel("Equipment");
        equipmentTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityEquipmentPanel.add(equipmentTitle);

        ArrayList<Item> equippedItems = entity.getItems();

        entityEquipmentPanel.add(Box.createRigidArea(new Dimension(100, 10)));

        for(Item item: equippedItems){
            JLabel itemLabel = new JLabel(item.getDescription());

            UIManager.put("ToolTip.background", Color.WHITE);
            UIManager.put("ToolTip.font", new FontUIResource("SansSerif", Font.BOLD, 12));
            itemLabel.setToolTipText(item.toString());

            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            entityEquipmentPanel.add(Box.createRigidArea(new Dimension(100, 10)));
            entityEquipmentPanel.add(itemLabel);
        }

        return entityEquipmentPanel;

    }

    /**
     * Creates the map of the dungeon floor
     *
     * @return JPanel
     */
    private JPanel createTileMapPanel(Floor floor) {

        ArrayList<ArrayList<Room>> tileMap = floor.getRoomMap();
        Entity player = floor.getPlayer();

        int cols = tileMap.size();
        int rows = tileMap.get(0).size();

        JPanel tileMapPanel = new JPanel(new GridLayout(rows, cols, 10, 10));

        for (int y = 0; y < rows; y++) {
            for( int x = 0; x < cols; x++) {
                Room currentRoom = tileMap.get(x).get(y);
                String text = currentRoom.getClass().getSimpleName();
                JButton button = new JButton(text);
                int[] playerPos = player.getPos();
                if(currentRoom.isFloorEnd()){
                    button.setText("Exit Floor");
                }
                if(Math.abs(x - playerPos[0]) > 1 || Math.abs(y - playerPos[1]) > 1){
                    button.setText("");
                    button.setEnabled(false);
                }
                if(currentRoom.hasBeenVisited()){
                    button.setText("Visited");
                    button.setEnabled(false);
                }

                int finalX = x;
                int finalY = y;
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        floor.makeMove(currentRoom);
                        player.setPos(new int[]{finalX, finalY});
                    }
                });

                tileMapPanel.add(button, y, x);
            }
        }

        return tileMapPanel;

    }

}
