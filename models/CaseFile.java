package models;

import static  managers.Colors.*;
import java.util.ArrayList;

public class CaseFile {
    private int caseId;
    private String title;
    private int remainingAttempts = 3;

    private Detective detective;
    private ArrayList<Suspect> suspects;
    private ArrayList<Witness> witnesses;
    private ArrayList<Clue> clues;
    private ArrayList<Evidence> evidences;

    private boolean solved;

    public CaseFile(int caseId, String title, Detective detective, ArrayList<Suspect> suspects,
                    ArrayList<Witness> witnesses, ArrayList<Clue> clues, ArrayList<Evidence> evidences) {
        this.caseId = caseId;
        this.title = title;
        this.detective = detective;
        this.suspects = suspects;
        this.witnesses = witnesses;
        this.clues = clues;
        this.evidences = evidences;
        this.solved = false;
    }

    public void displayCase() {
        System.out.println(CYAN + "\n===== CASE INFORMATION =====" + RESET);
        System.out.println("Case ID: " + caseId);
        System.out.println("Title: " + title);

        System.out.println(CYAN + "\n--- Assigned Detective ---" + RESET);
        detective.introduce();

        System.out.println(CYAN + "\n--- Suspects ---" + RESET);
        for (Suspect s : suspects) {
            s.introduce();
            System.out.println("----------");
        }

        System.out.println(CYAN + "\n--- Witnesses ---" + RESET);
        for (Witness w : witnesses) {
            w.introduce();
            System.out.println("----------");
        }

        System.out.println(CYAN + "\n--- Clues ---" + RESET);
        for (Clue c : clues) {
            c.displayClue();
            System.out.println("----------");
        }

        System.out.println(CYAN + "\n--- Evidence ---" + RESET);
        for (Evidence e : evidences) {
            e.displayEvidence();
            System.out.println("----------");
        }

        System.out.println(BLUE + "Solved: " + RESET + solved);
    }


    public void displaySuspects() {
        for (Suspect s : suspects) {
            s.introduce();
            System.out.println("----------");
        }
    }

    public void displayClues() {
        for (Clue c : clues) {
            c.displayClue();
            System.out.println("----------");
        }
    }

    public void displayEvidence() {
        for (Evidence e : evidences) {
            e.displayEvidence();
            System.out.println("----------");
        }
    }

    public Suspect findSuspect(int id) {
        for (Suspect s : suspects) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Suspect> getSuspects() {
        return suspects;
    }

    public Evidence findEvidence(int id){
        for (Evidence e : evidences) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public Detective getDetective() {
        return detective;
    }


    public void displayAllPeople() {
        // polymorphism
        ArrayList<Person> people = new ArrayList<>();
        
        people.add(detective);
        people.addAll(suspects);
        people.addAll(witnesses);

        System.out.println(CYAN + "\n===== ALL PEOPLE =====" + RESET);

        for (Person p : people) {
            p.introduce();
            System.out.println("----------------");
        }
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public void decrementAttempts() {
        remainingAttempts--;
    }


    public boolean isSolved() {
        return solved;
    }

    public void solveCase() {
        if (solved) {
            System.out.println(GREEN + "This case is already solved!" + RESET);
            return;
        }
        
        solved = true;
        detective.incrementSolvedCases();

        System.out.println(GREEN + "Case solved successfully!" + RESET);
        System.out.println(BLUE + "Detective " + detective.getName() + " has solved another case!"+RESET);
        System.exit(0);
    }
}