package Graphics;

import Entities.Entity;
import Entities.Player;
import Interactions.Interactable;
import Rooms.Floor;

import javax.swing.*;
import java.awt.*;

public class FloorGraphics extends Graphics {

    // TODO: delete this after testing
    public static void main(String[] args) {

        Interactable player = new Player("Test");

        Graphics floorGraphics = new FloorGraphics();
        //floorGraphics.setInteractable(player); // This will actually be given a floor but since Floor isn't working I am passing a player

        JFrame frame = new JFrame("Game Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        floorGraphics.createDisplay(frame);

    }

    @Override
    public void setInteractable(Interactable interactable) {
        if (interactable.getClass().equals(Floor.class)) {
            this.interactable = interactable;
        } else {
            throw new IllegalArgumentException("Input must be of type Floor");
        }
    }

    @Override
    public void createDisplay(JFrame frame) {

        // TODO: get Floor object to work
        //Entity entity = ((Floor) interactable).getPlayer();
        Entity entity = new Player("Test");


        JPanel leftPanel = this.createLeftPanel(entity);

        // Tile Map Panel
        // TODO: make createTileMap take as input the dungeon grid
        JPanel tileMapPanel = this.createTileMapPanel();

        frame.getContentPane().add(BorderLayout.EAST, leftPanel);
        frame.getContentPane().add(BorderLayout.CENTER, tileMapPanel);

        frame.setVisible(true);
    }

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

    private JPanel createEntityEquipmentPanel(Entity entity) {

        // Entity Equipment
        JPanel entityEquipmentPanel = new JPanel();
        entityEquipmentPanel.setLayout(new BoxLayout(entityEquipmentPanel, BoxLayout.Y_AXIS));
        entityEquipmentPanel.setBackground(Color.lightGray);

        entityEquipmentPanel.add(Box.createRigidArea(new Dimension(100, 20)));

        JLabel equipmentTitle = new JLabel("Equipment");
        equipmentTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        entityEquipmentPanel.add(equipmentTitle);

        return entityEquipmentPanel;

    }

    private JPanel createTileMapPanel() {

        int rows = 10;
        int cols = 12;
        JPanel tileMapPanel = new JPanel(new GridLayout(rows, cols, 10, 10));

        for (int y = 0; y < rows; y++) {
            for( int x = 0; x < cols; x++) {
                String text = Integer.toString(x) + "," + Integer.toString(y);
                JButton button = new JButton(text);
                tileMapPanel.add(button, y, x);
            }
        }

        return tileMapPanel;

    }

}
