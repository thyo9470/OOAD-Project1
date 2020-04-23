package Graphics;

import Entities.Entity;
import Entities.Player;
import Interactions.Interactable;
import Items.Item;
import Items.Skills.Skill;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EntityGraphics extends Graphics {

    final private int SKILL_BUTTON_HEIGHT = 100;
    final private int ITEM_BUTTON_HEIGHT = 200;
    final private int ITEM_BUTTON_WIDTH = 200;
    final private int ITEM_BUTTON_SPACING = 50;

    @Override
    protected void setInteractable(Interactable interactable) {
        if (Entity.class.isAssignableFrom(interactable.getClass())) {
            this.interactable = interactable;
        } else {
            throw new IllegalArgumentException("Input must be of type Entity");
        }
    }

    /**
     * given an empty JFrame it will construct any scence that are for entities: battles and swap item
     *  TODO: add swap item GUI
     *
     * @param frame: JFrame
     */
    @Override
    protected void createDisplay(JFrame frame) {

        Entity player = ((Entity) this.interactable);
        Entity enemy = player.getEnemy();

        // Show player and enemy panel
        JPanel displayPanel = new JPanel();

        if (player.isSwappingItem()) {
            // Item  Panel
            JPanel itemPanel = this.createSwapItemPanel(player);

            frame.getContentPane().add(itemPanel);
        } else {
            // Skills panel
            JPanel skillPanel = this.createSkillsPanel(player);

            // Entity Info Panel
            JPanel entityInfoPanel = this.createEntityInfoPanel(player, enemy);

            frame.getContentPane().add(BorderLayout.NORTH, entityInfoPanel);
            frame.getContentPane().add(BorderLayout.SOUTH, skillPanel);
        }

        frame.setVisible(true);

    }

    /**
     * Constructs the panel that will ask the player if they want to keep
     * their currently equipped item or swap it for the new item
     *
     * @param entity
     * @return
     */
    private JPanel createSwapItemPanel(Entity entity) {

        Item newItem = entity.getSwappingItem();
        Item oldItem = entity.getMatchingItem(newItem);

        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        JPanel buttonPanel = new JPanel(new GridBagLayout());

        JLabel swapText = new JLabel("Select which item you want to keep");
        swapText.setFont (swapText.getFont ().deriveFont (32.0f));

        JButton oldItemButton = new JButton("OLD ITEM IMAGE HERE");
        oldItemButton.setPreferredSize(new Dimension(ITEM_BUTTON_WIDTH, ITEM_BUTTON_HEIGHT));

        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.font", new FontUIResource("SansSerif", Font.BOLD, 12));
        oldItemButton.setToolTipText(oldItem.toString());

        oldItemButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(entity.getClass().equals(Player.class)) {
                    ((Player)entity).setItemToUse(oldItem);
                }
            }
        });

        JButton newItemButton = new JButton("NEW ITEM IMAGE HERE");
        newItemButton.setPreferredSize(new Dimension(ITEM_BUTTON_WIDTH, ITEM_BUTTON_HEIGHT));

        newItemButton.setToolTipText(newItem.toString());

        newItemButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(entity.getClass().equals(Player.class)) {
                    ((Player)entity).setItemToUse(newItem);
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, ITEM_BUTTON_SPACING, 0, ITEM_BUTTON_SPACING);

        buttonPanel.add(oldItemButton,c);
        buttonPanel.add(newItemButton,c);

        swapText.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        itemPanel.add(Box.createRigidArea(new Dimension(100, 150)));
        itemPanel.add(swapText);
        itemPanel.add(buttonPanel);



        return itemPanel;

    }

    /**
     * constructs the panel for the JFrame that contains all the skill buttons in battle
     *
     * @param entity: Entity
     * @return JPanel with skill buttons
     */
    private JPanel createSkillsPanel(Entity entity) {

        JPanel skillPanel = new JPanel(new GridLayout(1, 4, 1, 1));

        ArrayList<Skill> skills = entity.getSkills();

        for (Skill skill:skills) {

            String skillButtonText = skill.getDescription();
            skillButtonText += "<br>Mana Cost: " + skill.getManaCost();
            skillButtonText += "<br>Health Cost: " + skill.getHealthCost();
            skillButtonText = "<html>" + skillButtonText + "</html>";

            JButton skillButton = new JButton(skillButtonText);

            // TODO: improve tool tips
            UIManager.put("ToolTip.background", Color.WHITE);
            UIManager.put("ToolTip.font", new FontUIResource("SansSerif", Font.BOLD, 12));
            skillButton.setToolTipText(skill.toString());

            int buttonWidth = skillButton.getWidth();
            skillButton.setPreferredSize(new Dimension(buttonWidth, this.SKILL_BUTTON_HEIGHT));

            skillButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(entity.getClass().equals(Player.class)) {
                        ((Player)entity).setSkillToUse(skill);
                    }
                }
            });
            skillPanel.add(skillButton);
        }

        return skillPanel;

    }

    /**
     * Constructs the entity info panel at the top of the battle that shows the player and enemy info ( aka health and mana )
     *
     * @param player
     * @param enemy
     * @return
     */
    private JPanel createEntityInfoPanel(Entity player, Entity enemy) {

        JPanel entityInfoPanel = new JPanel(new GridLayout(1,2,1,1));

        // Player Info Panel
        JPanel playerInfoPanel = this.createEntityInfo(player);
        entityInfoPanel.add(playerInfoPanel);

        // Enemy Info Panel
        JPanel enemyInfoPanel = this.createEntityInfo(enemy);
        entityInfoPanel.add(enemyInfoPanel);

        return entityInfoPanel;

    }

    /**
     * constructs individual entity info panels for createEntityInfoPanel
     * The entity info is any information needed about a specific entity ie health and mana
     *
     * @param entity
     * @return
     */
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

