package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String surgery;

    public String getSurgery(){
        return surgery;
    }

    public TypeOfSurgery make(Patient patient){
        return new TypeOfSurgery();
    }
}
