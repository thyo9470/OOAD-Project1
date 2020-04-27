package Rooms;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public PuzzleQuestion() {
       this.setRandomQuestion();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        questionBank.add("Which of these movies is Chris Evans not int?");
        questionBank.add("How many Star Wars movies are there?");
        questionBank.add("When was CU Boulder Founded?");
        questionBank.add("What is the state flower of Colorado?");
        questionBank.add("Which Beatle was the youngest Beatle?");
        questionBank.add("Who was the 28th President?");
        questionBank.add("What weapon does Gimli from Lord of the Rings wield?");
        questionBank.add("How many swallows does it take to carry a coconut?");
        questionBank.add("When is the Queen of England's Birthday?");
        questionBank.add("How big is the Earth's radius?");
        this.question = this.questionBank.get(rand.nextInt(questionBank.size()));
    }

    public String getQuestion() {
        return this.question;
    }

    /**
     * Getters and setters for the questions
     * @return getOptionforCurrQuestion
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
        String[] question6 = {"Spiderman Homecoming", "Thor II", "Antman"};
        String[] question7 = {"9", "11", "7"};
        String[] question8 = {"1876", "1899", "1912"};
        String[] question9 = {"Columbine", "Poppy", "Petunia"};
        String[] question10 = {"Ringo", "John", "George"};
        String[] question11 = {"William Taft", "Woodrow Wilson", "Theodore Roosevelt"};
        String[] question12 = {"A Sword", "A Bow", "An Axe"};
        String[] question13 = {"It depends, African or European", "One", "Two"};
        String[] question14 = {"April 30th", "May 30th", "April 21st"};
        String[] question15 = {"3958 miles", "40002 miles", "789 miles"};


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

        } else if (this.questionBank.get(4).equals(this.question)){
            this.options = question5;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(5).equals(this.question)){
            this.options = question6;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(6).equals(this.question)) {
            this.options = question7;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(7).equals(this.question)) {
            this.options = question8;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(8).equals(this.question)) {
            this.options = question9;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(9).equals(this.question)) {
            this.options = question10;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(10).equals(this.question)){
            this.options = question11;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(11).equals(this.question)) {
            this.options = question12;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(12).equals(this.question)) {
            this.options = question13;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else if(this.questionBank.get(13).equals(this.question)){
            this.options = question14;
            System.out.println(Arrays.toString(this.options));
            return this.options;
        } else {
            this.options = question15;
            System.out.println(Arrays.toString(this.options));
            return this.options;

        }

    }


    public boolean checkAnswer(){
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
        } else if( this.question.equals(this.questionBank.get(5)) && this.answer.equals("Antman") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(6)) && this.answer.equals("11") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(7)) && this.answer.equals("1876") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(8)) && this.answer.equals("Columbine") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(9)) && this.answer.equals("George") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(10)) && this.answer.equals("Woodrow Wilson") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(11)) && this.answer.equals("An Axe") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(12)) && this.answer.equals("It depends, African or European")){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(13)) && this.answer.equals("April 21st") ){
            //correct
            return true;
        } else if( this.question.equals(this.questionBank.get(14)) && this.answer.equals("3958 miles") ){
            //correct
            return true;
        } else {
            return false;
        }

    }
}




