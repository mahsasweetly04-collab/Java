package models;

import static managers.Colors.*;
public class Clue {

    private int id;
    private String description;
    private String relatedPerson;
    private boolean important;

    public Clue(int id, String description,
                String relatedPerson, boolean important) {

        this.id = id;
        this.description = description;
        this.relatedPerson = relatedPerson;
        this.important = important;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getRelatedPerson() {
        return relatedPerson;
    }

    public boolean isImportant() {
        return important;
    }

    public void displayClue() {
        System.out.println(BLUE + "Clue ID: " + RESET + id);
        System.out.println(BLUE + "Description: " + RESET + description);
        System.out.println(BLUE + "Related Person: " + RESET + relatedPerson);
        System.out.println(BLUE + "Important: " + RESET + important);
    }
}
