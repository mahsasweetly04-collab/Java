package models;

import static managers.Colors.*;
public class Witness extends Person {
    private String observation;

    public Witness(int id, String name, int age, String observation) {
        super(id, name, age);

        this.observation = observation;
    }

    public String getObservation() {
        return observation;
    }

    @Override
    public void introduce() {
        System.out.println(BLUE + "Witness: " + RESET + getName());
        System.out.println(BLUE + "Observation: " + RESET + observation);
    }
}
