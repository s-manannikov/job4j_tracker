package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Driving");
    }

    @Override
    public void passengers(int number) {
        System.out.println(number);
    }

    @Override
    public int refuel(int amount) {
        return amount * 50;
    }
}
