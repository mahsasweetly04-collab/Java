package managers;

import models.*;
import java.util.Scanner;

public class GameManager {

    private CaseFile currentCase;
    private Scanner scanner;

    public GameManager(CaseFile currentCase) {
        this.currentCase = currentCase;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {

        int choice;

        do {
            System.out.println("\n" + Colors.CYAN + "===== DETECTIVE GAME =====" + Colors.RESET);
            System.out.println(Colors.YELLOW + "1. View Case" + Colors.RESET);
            System.out.println(Colors.YELLOW + "2. View Suspects" + Colors.RESET);
            System.out.println(Colors.YELLOW + "3. View Clues" + Colors.RESET);
            System.out.println(Colors.YELLOW + "4. Interrogate Suspect" + Colors.RESET);
            System.out.println(Colors.YELLOW + "5. View Evidence" + Colors.RESET);
            System.out.println(Colors.YELLOW + "6. Examine Evidence" + Colors.RESET);
            System.out.println(Colors.YELLOW + "7. Solve Case" + Colors.RESET);
            System.out.println(Colors.YELLOW + "8. View All People" + Colors.RESET);
            System.out.println(Colors.RED + "9. Exit" + Colors.RESET);

            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentCase.displayCase();
                    break;

                case 2:
                    viewSuspects();
                    break;

                case 3:
                    viewClues();
                    break;

                case 4:
                    interrogateSuspect();
                    break;

                case 5:
                    viewEvidence();
                    break;

                case 6:
                    examineEvidence();
                    break;

                case 7:
                    solveCase();
                    break;

                case 8:
                    currentCase.displayAllPeople();
                    break;

                case 9:
                    System.out.println(Colors.GREEN + "Goodbye Detective!" + Colors.RESET);
                    break;

                default:
                    System.out.println(Colors.RED + "Invalid option!" + Colors.RESET);
            }

        } while (choice != 9);
    }

    private void viewSuspects() {
        currentCase.displaySuspects();
    }

    private void viewClues() {
        currentCase.displayClues();
    }

    private void viewEvidence() {
        currentCase.displayEvidence();
    }

    private void examineEvidence() {
        System.out.println(Colors.BLUE + "Enter Evidence ID:" + Colors.RESET);
        int id = scanner.nextInt();

        Evidence evidence = currentCase.findEvidence(id);

        if (evidence != null) {
            evidence.examine();

        } else {
            System.out.println(Colors.RED + "Evidence not found!" + Colors.RESET);
        }
    }   

    private void interrogateSuspect() {
        scanner.nextLine();
        System.out.println(Colors.BLUE + "Enter suspect name:" + Colors.RESET);
        String name = scanner.nextLine();

        Suspect suspect = null;

        for (Suspect s : currentCase.getSuspects()) {
            if (s.getName().equalsIgnoreCase(name)) {
                suspect = s;
                break;
            }
        }

        if (suspect != null) {
            System.out.println("\nInterrogating " + suspect.getName());
            System.out.println("Motive: " + suspect.getMotive());

        } else {
            System.out.println(Colors.RED + "Suspect not found!" + Colors.RESET);
        }
    }

    private void solveCase() {
        if (currentCase.isSolved()) {
            System.out.println(Colors.YELLOW + "This case is already solved!" + Colors.RESET);
            return;
        }

        if (currentCase.getRemainingAttempts() <= 0) {
            System.out.println(Colors.RED + "Game Over! You ran out of attempts and failed to solve the case." + Colors.RESET);
            return;
        }

        scanner.nextLine();
        System.out.println(Colors.BLUE + "Enter the suspect name you think is guilty:" + Colors.RESET);
        String name = scanner.nextLine();

        Suspect suspect = null;

        for (Suspect s : currentCase.getSuspects()) {
            if (s.getName().equalsIgnoreCase(name)) {
                suspect = s;
                break;
            }
        }

        if (suspect != null) {
            if (suspect.isSuspicious()) {
                System.out.println(Colors.GREEN + "\nCorrect! Case solved successfully!" + Colors.RESET);
                currentCase.solveCase();
            } else {
                currentCase.decrementAttempts();
                System.out.println(Colors.RED + "Incorrect! " + suspect.getName() + " is innocent." + Colors.RESET);
                checkAttemptsStatus();
            }      
        }else {
            currentCase.decrementAttempts();
            System.out.println(Colors.RED + "Suspect not found!" + Colors.RESET);
            checkAttemptsStatus();
        }
    }

    private void checkAttemptsStatus() {
        if (currentCase.getRemainingAttempts() > 0) {
            System.out.println(Colors.YELLOW + "Attempts left: " + currentCase.getRemainingAttempts() + Colors.RESET);
        } else {
            System.out.println(Colors.RED + "\n[!] GAME OVER! You have no attempts remaining." + Colors.RESET);
            System.out.println(Colors.RED + "Exiting the game..." + Colors.RESET);
            
            System.exit(0);
        }
    }
}