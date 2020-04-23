package Graphics;

import Interactions.Interactable;
import Rooms.Puzzle;

import javax.swing.*;
import java.awt.*;

public class PuzzleGraphics extends Graphics {

    public static void main(String[] args) {

        Interactable puzzle = new Puzzle();

        PuzzleGraphics puzzleGraphics = new PuzzleGraphics();
        puzzleGraphics.setInteractable(puzzle);

        JFrame frame = new JFrame("Game Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        puzzleGraphics.createDisplay(frame);

    }

    @Override
    protected void setInteractable(Interactable interactable) {
        if(interactable.getClass().equals(Puzzle.class)) {
            this.interactable = interactable;
        } else {
            throw new IllegalArgumentException("Input must be of type Puzzle");
        }
    }

    /**
     * Given an epmty JFrame, this constructs the scene for answering questions
     *
     * @param frame: Jframe
     */
    @Override
    public void createDisplay(JFrame frame) {


        // question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        // question text
        JLabel questionText = new JLabel("This will be a question");
        questionText.setAlignmentX(Component.CENTER_ALIGNMENT);

        questionPanel.add(Box.createRigidArea(new Dimension(100, 50)));
        questionPanel.add(questionText);
        questionPanel.add(Box.createRigidArea(new Dimension(100, 50)));

        // input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.lightGray);

        frame.getContentPane().add(BorderLayout.NORTH, questionPanel);
        frame.getContentPane().add(BorderLayout.CENTER, inputPanel);

        frame.setVisible(true);

    }
}
