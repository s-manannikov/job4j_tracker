package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " передвигается по рельсам.");
    }

    @Override
    public void speed() {
        System.out.println(" Средняя скорость 100 км/ч.");
    }
}
