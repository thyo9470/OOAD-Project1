package Graphics;

import Game.Game;
import Interactions.Interactable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CHAIN OF RESPONSIBILITY PATTERN
 * One of the concrete handlers
 * Used to handle displaying specific graphics components
 */
public class GameGraphics extends Graphics {

    /**
     * Sets interactable if given interactable is of type Game
     * @param interactable: Interactable
     */
    @Override
    protected void setInteractable(Interactable interactable) {
        if(interactable.getClass().equals(Game.class)) {
            this.interactable = interactable;
        } else {
           throw new IllegalArgumentException("Input must be of type Game");
        }
    }

    /**
     * Given an empty JFrame, this constructs the main menu
     *
     * @param frame: JFrame
     */
    @Override
    public void createDisplay(JFrame frame) {

        Game game = ((Game)this.interactable);

        // main menu panel
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));


        JLabel titleLabel = new JLabel("Adventure Game The Game");
        titleLabel.setFont (titleLabel.getFont ().deriveFont (64.0f));
        JButton startGameButton = new JButton("Start Game");
        JButton exitGameButton = new JButton("Exit Game");

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        startGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                game.startGame();
            }
        });
        exitGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitGameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });


        mainMenuPanel.add(Box.createRigidArea(new Dimension(100, 100)));
        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(100, 50)));
        mainMenuPanel.add(startGameButton);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(100, 50)));
        mainMenuPanel.add(exitGameButton);

        frame.add(mainMenuPanel);

        frame.setVisible(true);

    }
}
