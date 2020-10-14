package ru.job4j.poly;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " двигается по скоростным трассам.");
    }

    @Override
    public void speed() {
        System.out.println(" Средняя скорость 80 км/ч.");
    }
}
