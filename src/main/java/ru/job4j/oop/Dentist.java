package ru.job4j.oop;

public class Dentist extends Doctor {
    private String category;

    public String getCategory() {
        return category;
    }

    public Teeth recovery(Patient patient) {
        return new Teeth();
    }
}
