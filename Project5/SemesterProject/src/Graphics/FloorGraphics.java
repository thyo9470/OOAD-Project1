package Graphics;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;
import Interactions.Interactable;
import Items.Item;
import Rooms.Floor;
import Rooms.Puzzle;
import Rooms.Room;
import Rooms.TrapRoom;

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
     *
     * @param frame: JFrame
     */
    @Override
    public void createDisplay(JFrame frame) {

        // TODO: get Floor object to work
        Floor floor = (Floor) this.interactable;
        Entity entity = floor.getPlayer();

        JPanel leftPanel = this.createLeftPanel(entity);

        // Tile Map Panel
        // TODO: make createTileMap take as input the dungeon grid
        JPanel tileMapPanel = this.createTileMapPanel(floor);

        frame.getContentPane().add(BorderLayout.EAST, leftPanel);
        frame.getContentPane().add(BorderLayout.CENTER, tileMapPanel);

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

        JLabel entityInfoTitle = new JLabel("Player Info");
        entityInfoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(entityInfoTitle);

        int health = entity.getHealth();
        int mana = entity.getMana();
        int attack = entity.getAttack();
        int defense = entity.getDefense();

        entityInfoPanel.add(Box.createRigidArea(new Dimension(100, 50)));

        // TODO: change this to just use player toString that will in the future produce HTML representation of itself
        JLabel healthLabel = new JLabel("Health: " + Integer.toString(health));
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(healthLabel);

        JLabel manaLabel = new JLabel("Mana: " + Integer.toString(mana));
        manaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityInfoPanel.add(manaLabel);

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

            // TODO: improve tool tips
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
     * TODO: determine if this needs to be passed the tile map
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
                if(Math.abs(x - playerPos[0]) > 1 || Math.abs(y - playerPos[1]) > 1){
                    button.setText("");
                    button.setEnabled(false);
                }
                if(currentRoom.hasBeenVisited()){
                    button.setText("Visited");
                    button.setEnabled(false);
                }
                // TODO: Check in about displaying last room

                int finalX = x;
                int finalY = y;
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        currentRoom.visit();
                        if(currentRoom instanceof TrapRoom){
                            Puzzle puzzle = ((TrapRoom)currentRoom).getPuzzle();
                            floor.setNextIntractable(puzzle);
                            puzzle.setFloor(floor);
                        } else {
                            floor.setNextIntractable(player);
                            player.setFloor(floor);
                        }
                        currentRoom.enterRoom(player);
                        player.setPos(new int[]{finalX, finalY});
                    }
                });

                tileMapPanel.add(button, y, x);
            }
        }

        return tileMapPanel;

    }

}
