import java.util.ArrayList;

import managers.GameManager;
import models.*;

public class Main {

    public static void main(String[] args) {
        Detective detective =new Detective(
            1, 
            "Alex", 
            35, 
            "Senior", 
            12
        );

        Suspect suspect =new Suspect(
            2,
            "John", 
            28, 
            "Financial problems", 
            true
        );

        Witness witness = new Witness(
            3,
            "Sarah", 
            30, 
            "Someone left the museum"
        );

        ArrayList<Suspect> suspects = new ArrayList<>();
        suspects.add(suspect);

        ArrayList<Witness> witnesses = new ArrayList<>();
        witnesses.add(witness);

        ArrayList<Clue> clues = new ArrayList<>();
        clues.add(
            new Clue(1, "Fingerprint found on the door",
                     "John", true)
            );
        clues.add(
            new Clue(2, "Camera stopped working",
                     "Unknown", false)
        );

        ArrayList<Evidence> evidences = new ArrayList<>();
        evidences.add(
            new Evidence(1, "Fingerprint", 
                        "A fingerprint was found on the museum door", 
                        "Museum entrance", 
                        "The fingerprint matches John.")
        );

        evidences.add(
            new Evidence(2, "Security Camera",
                        "A damaged security camera was discovered",
                        "Security room",
                        "The camera was disabled before the theft.")
        );

        evidences.add(
            new Evidence(3, "Torn Paper",
                        "A piece of paper was found near the exhibition room",
                        "Exhibition room",
                        "The paper contains a partial financial record.")
        );

        CaseFile case1 = new CaseFile(
            101,
            "The Mystery of the Locked Room",
            detective,
            suspects,
            witnesses,
            clues,
            evidences
        );

        GameManager game = new GameManager(case1); 
        game.startGame();
    }
}
