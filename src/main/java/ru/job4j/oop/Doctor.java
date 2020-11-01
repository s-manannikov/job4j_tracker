package ru.job4j.oop;

public class Doctor extends Profession {
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public Diagnosis heal(Patient patient) {
        return new Diagnosis();
    }
}
