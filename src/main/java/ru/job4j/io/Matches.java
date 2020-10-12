package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match = 11;
        System.out.println("Перед Вами " + match + " спичек!");
        System.out.println("За один ход можно взять от 1 до 3 спичек.");
        while (match > 0) {
            System.out.println("Сделайте Ваш ход: ");
            int select = Integer.valueOf(input.nextLine());
            if (select > 3) {
                System.out.println("Вы можете взять не более 3 спичек за один ход!");
            } else if (select < 1) {
                    System.out.println("Вы должны взять минимум 1 спичку!");
                } else {
                match = match - select;
            }
            System.out.println("Осталось " + match + " спичек.");
        }
        System.out.println("Вы выиграли!");
    }
}