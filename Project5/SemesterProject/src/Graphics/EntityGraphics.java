package Graphics;

import Entities.Enemy;
import Entities.Entity;
import Entities.Player;
import Interactions.Interactable;
import Rooms.Floor;

import javax.swing.*;
import java.awt.*;

public class EntityGraphics extends Graphics {

    // TODO: delete this after testing
    public static void main(String[] args) {

        Interactable player = new Player("player");
        Interactable enemy = new Enemy("enemy");
        ((Entity)player).setEnemy((Entity)enemy);

        EntityGraphics entityGraphics = new EntityGraphics();
        entityGraphics.setInteractable(player);

        JFrame frame = new JFrame("Game Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        entityGraphics.createDisplay(frame);

    }

    @Override
    public void setInteractable(Interactable interactable) {
        if (Entity.class.isAssignableFrom(interactable.getClass())) {
            this.interactable = interactable;
        } else {
            throw new IllegalArgumentException("Input must be of type Entity");
        }
    }

    @Override
    public void createDisplay(JFrame frame) {

        Entity player = ((Entity) interactable);
        Entity enemy = player.getEnemy();

        // Skills panel
        JPanel skillPanel = this.createSkillsPanel(player);

        // Entity Info Panel
        JPanel entityInfoPanel = this.createEntityInfoPanel(player, enemy);

        // Show player and enemy panel
        JPanel displayPanel = new JPanel();

        frame.getContentPane().add(BorderLayout.NORTH, entityInfoPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, skillPanel);

        frame.setVisible(true);

    }

    // TODO: populate with entity's skills
    private JPanel createSkillsPanel(Entity entity) {

        JPanel skillPanel = new JPanel(new GridLayout(1, 4, 1, 1));

        JButton skill1 = new JButton("Skill 1");
        JButton skill2 = new JButton("Skill 2");
        JButton skill3 = new JButton("Skill 3");
        JButton skill4 = new JButton("Skill 4");

        skillPanel.add(skill1);
        skillPanel.add(skill2);
        skillPanel.add(skill3);
        skillPanel.add(skill4);

        return skillPanel;

    }

    private JPanel createEntityInfoPanel(Entity player, Entity enemy) {

        JPanel entityInfoPanel = new JPanel(new GridLayout(1,2,1,1));

        // Player Info Panel
        /*JPanel playerInfoPanel = new JPanel();
        playerInfoPanel.setBackground(Color.lightGray);
        JLabel playerLabel = new JLabel("Player:");
        playerInfoPanel.add(playerLabel);*/
        JPanel playerInfoPanel = this.createEntityInfo(player);
        entityInfoPanel.add(playerInfoPanel);

        // Enemy Info Panel
        /*JPanel enemyInfoPanel = new JPanel();
        enemyInfoPanel.setBackground(Color.lightGray);
        JLabel enemyLabel = new JLabel("Enemy:");
        enemyInfoPanel.add(enemyLabel);*/
        JPanel enemyInfoPanel = this.createEntityInfo(enemy);
        entityInfoPanel.add(enemyInfoPanel);

        return entityInfoPanel;

    }

    private JPanel createEntityInfo(Entity entity) {

        JPanel entityInfo = new JPanel();
        entityInfo.setLayout(new BoxLayout(entityInfo, BoxLayout.Y_AXIS));
        entityInfo.setBackground(Color.lightGray);

        JLabel playerLabel = new JLabel(entity.getClass().getSimpleName() + ":");
        entityInfo.add(playerLabel);

        int health = entity.getHealth();
        int mana = entity.getMana();
        int attack = entity.getAttack();
        int defense = entity.getDefense();

        JLabel EmptyLine = new JLabel(" ");
        entityInfo.add(EmptyLine);

        JLabel healthLabel = new JLabel("Health: " + Integer.toString(health));
        entityInfo.add(healthLabel);

        JLabel manaLabel = new JLabel("Mana: " + Integer.toString(mana));
        entityInfo.add(manaLabel);

        JLabel attackLabel = new JLabel("Attack: " + Integer.toString(attack));
        entityInfo.add(attackLabel);

        JLabel defenseLabel = new JLabel("Defense: " + Integer.toString(defense));
        entityInfo.add(defenseLabel);

        return entityInfo;

    }
}
