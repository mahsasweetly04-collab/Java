package models;

import static managers.Colors.*;
public class Evidence {
    private int id;
    private String name;
    private String description;
    private String location;
    private boolean examined;
    private String analysisResult;

    public Evidence(int id, String name, String description, String location, String analysisResult) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.examined = false;
        this.analysisResult = analysisResult;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public boolean isExamined() {
        return examined;
    }

    public String getAnalysisResult() {
        return analysisResult;
    }

    public void examine() {
        if (examined) {
            System.out.println(YELLOW + "This evidence has already been examined!" + RESET);
            return;
        }

        examined = true;

        System.out.println(CYAN + "\n--- Evidence Analysis ---" + RESET);
        System.out.println(BLUE +"Evidence examined: " + RESET + name);
        System.out.println(BLUE + "Analysis: " + RESET + analysisResult);
    }

    public void displayEvidence() {
        System.out.println(BLUE + "Evidence ID: " + RESET + id);
        System.out.println(BLUE + "Name: " + RESET + name);
        System.out.println(BLUE + "Description: " + RESET + description);
        System.out.println(BLUE + "Location: " + RESET + location);
        System.out.println(BLUE + "Examined: " + RESET + examined);
    }
}