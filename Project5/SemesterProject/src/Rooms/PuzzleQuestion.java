package Rooms;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


public class PuzzleQuestion {

    /**
     * Private String variables
     */
    private String question;
    private String[] options;
    private String answer;


    Random rand = new Random();


    private List<String> questionBank = new ArrayList<>();
    private String[] q1;
    private String[] q2;
    private String[] q3;
    private String[] q4;
    private String[] q5;

    public PuzzleQuestion() {
       this.setRandomQuestion();
    }

    /**
     * Sets the question for this puzzle question object
     */

    public void setRandomQuestion(){
        questionBank.add("Who wrote Hitchhikers Guide to the Galaxy?");
        questionBank.add("When did the Hitchhikers Guide to the Galaxy Movie Premiere?");
        questionBank.add("What animal left Earth in Hitchhikers Guide to the Galaxy?");
        questionBank.add("Which one is NOT a Star Wars Character?");
        questionBank.add("Solve: (15 + 28 / 12) + 17 * 0 + 69 ?");
        this.question = this.questionBank.get(rand.nextInt(questionBank.size()));
    }

    public String getQuestion() {
        return this.question;
    }

    /**
     * Getters and setters for the questions
     * @return
     */
    public String[] getOptions(){

        /**
         * add options for every question
         */
        //Question 1
        String[] question1 = {"Adam Douglas", "Douglas Adams", "J.R.R. Tolkien"};
        String[] question2 = {"1993", "2005", "2001"};
        String[] question3 = {"Dolphins", "Snails", "Baboons"};
        String[] question4 = {"Han Solo", "Jabba The Hutt", "Boogaloo"};
        String[] question5 = {"89.583", "89.5", "69"};


        /**
         * Checks current question and returns the options for that question.
         */

        if (this.questionBank.get(0).equals(this.question)){
            //its question 1 so return options
            this.options = question1;
            //Used for printing out to test
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if (this.questionBank.get(1).equals(this.question)){
            //its question2 so return options
            this.options = question2;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if (this.questionBank.get(2).equals(this.question)){
            this.options = question3;
            System.out.println(Arrays.toString(this.options));
            return this.options;

        } else if (this.questionBank.get(3).equals(this.question)){
            this.options = question4;
            System.out.println(Arrays.toString(this.options));
            return this.options;

        } else {
            this.options = question5;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        }

    }

    /*public String getAnswer(){
        //Take in user selection / input

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Your Answer (1) (2) or (3): ");
        this.answer= sc.nextLine();              //reads string
        System.out.print("You have entered: "+ this.answer);

        return this.answer;
    }*/


    public boolean checkAnswer(String answer){

        //if question == 1 && option == 2 then correct
        if( this.question.equals(this.questionBank.get(0)) && this.answer.equals("Douglas Adams") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(1)) && this.answer.equals("2005") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(2)) && this.answer.equals("Dolphins") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(3)) && this.answer.equals("Boogaloo") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(4)) && this.answer.equals("69") ){
            //correct
            return true;
        } else {
            return false;
        }

    }
}




