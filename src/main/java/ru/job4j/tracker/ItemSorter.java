package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item(2, "two"), new Item(7, "seven"), new Item(5, "five"));
        items.sort(new ItemByNameIncrease());
        System.out.println("Sort by names in ascending order: " + items);
        items.sort(new ItemByNameDecrease());
        System.out.println("Sort by names in descending order: " + items);
        items.sort(new ItemByIdIncrease());
        System.out.println("Sort by ID in ascending order: " + items);
        items.sort(new ItemByIdDecrease());
        System.out.println("Sort by ID in descending order: " + items);
        items.sort(new ItemByCreatedIncrease());
        System.out.println("Sort by date in ascending order: " + items);
        items.sort(new ItemByCreatedDecrease());
        System.out.println("Sort by date in descending order: " + items);
    }
}
