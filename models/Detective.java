package models;

import static managers.Colors.*;
public class Detective extends Person {

    private String rank;
    private int solvedCases;

    public Detective(int id, String name, int age, String rank, int solvedCases) {
        super(id, name, age);

        this.rank = rank;
        this.solvedCases = solvedCases;
    }

    public String getRank() {
        return rank;
    }

    public int getSolvedCases() {
        return solvedCases;
    }

    public void incrementSolvedCases() {
        solvedCases++;
    }

    @Override
    public void introduce() {
        System.out.println(BLUE + "I am Detective " + getName() + RESET);
        System.out.println(BLUE + "Rank: " + RESET + rank);
        System.out.println(BLUE + "Solved Cases: " + RESET + solvedCases);
    }
}
