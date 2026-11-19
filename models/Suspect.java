package models;

import static managers.Colors.*;
public class Suspect extends Person {

    private String motive;
    private boolean suspicious;

    public Suspect(int id, String name, int age, String motive, boolean suspicious) {
        super(id, name, age);

        this.motive = motive;
        this.suspicious = suspicious;
    }

    public String getMotive() {
        return motive;
    }

    public boolean isSuspicious() {
        return suspicious;
    }

    @Override
    public void introduce() {
        System.out.println(BLUE + "Suspect ID: " + RESET + getId());
        System.out.println(BLUE + "Suspect: " + RESET + getName());
        System.out.println(BLUE + "Age: " + RESET + getAge());
        System.out.println(BLUE + "Motive: " + RESET + motive);
        System.out.println(BLUE + "Suspicious: " + RESET + suspicious);
    }
}
