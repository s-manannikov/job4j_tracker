package ru.job4j.oop;

public class Builder extends Engineer {
    private String experience;

    public String getExperience(){
        return experience;
    }

    public Building build (Customer customer){
        return new Building();
    }
}
