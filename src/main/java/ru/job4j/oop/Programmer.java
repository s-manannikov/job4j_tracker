package ru.job4j.oop;

public class Programmer extends Engineer {
    private String language;

    public String getLanguage() {
        return language;
    }

    public Project write(Customer customer) {
        return new Project();
    }
}
