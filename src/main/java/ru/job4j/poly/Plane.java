package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void speed() {
        System.out.println(" Средняя скорость 850 км/ч.");
    }
}
