package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static boolean valid(int m) {
        return (m >= 1) && (m <= 3);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match = 11, count = 0;
        System.out.println("Перед Вами " + match + " спичек!" + System.lineSeparator() +
                "За один ход можно взять от 1 до 3 спичек.");
        while (match > 0) {
            if (count % 2 == 0) {
                System.out.print("Игрок 1. Ваш ход: ");
            } else System.out.print("Игрок 2. Ваш ход: ");
            int select = Integer.valueOf(input.nextLine());
            if (valid(select)) {
                match = match - select;
                System.out.println("Осталось " + match + " спичек.");
                count++;
            } else System.out.println("Вы можете взять не менее 1 и не более 3 спичек!");
        }
        if (count % 2 == 0) {
            System.out.println("Игрок 2 выиграл!");
        } else System.out.println("Игрок 1 выиграл!");
    }
}