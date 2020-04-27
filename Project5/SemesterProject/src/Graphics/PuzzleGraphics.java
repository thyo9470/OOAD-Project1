package Graphics;

import Entities.Player;
import Interactions.Interactable;
import Rooms.Puzzle;
import Rooms.PuzzleQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleGraphics extends Graphics {

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

        // question info
        Puzzle puzzle = ((Puzzle)this.interactable);
        PuzzleQuestion puzzleQuestion = puzzle.getQuestion();
        String question = puzzleQuestion.getQuestion();

        // question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        // question text
        JLabel questionText = new JLabel(question);
        questionText.setAlignmentX(Component.CENTER_ALIGNMENT);

        questionPanel.add(Box.createRigidArea(new Dimension(100, 50)));
        questionPanel.add(questionText);
        questionPanel.add(Box.createRigidArea(new Dimension(100, 50)));

        // input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.lightGray);

        ButtonGroup bg = new ButtonGroup();
        String[] puzzleOptions = puzzleQuestion.getOptions();
        for(String op: puzzleOptions){
            JRadioButton radioButton = new JRadioButton(op);
            bg.add(radioButton);
            inputPanel.add(radioButton);
        }

        JButton submitAnswer = new JButton("Submit");
        submitAnswer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Source: https://stackoverflow.com/questions/41314151/get-all-jradiobutton-from-a-buttongroup
                //Convert Enumeration to a List
                ArrayList<AbstractButton> listRadioButton = Collections.list(bg.getElements());

                for (AbstractButton button : listRadioButton) {
                    if(button.isSelected()){
                        String answer = ((JRadioButton) button).getActionCommand();
                        puzzle.answerQuestion(answer);
                    }
                }
            }
        });
        inputPanel.add(submitAnswer);


        frame.getContentPane().add(BorderLayout.NORTH, questionPanel);
        frame.getContentPane().add(BorderLayout.CENTER, inputPanel);

        frame.setVisible(true);

    }
}
