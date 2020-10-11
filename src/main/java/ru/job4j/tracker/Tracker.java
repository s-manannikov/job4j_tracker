package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                itemsWithoutNull[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, count);
    }

    public Item[] findByName(String key) {
        Item[] itemsByNames = new Item[items.length];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                itemsByNames[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemsByNames, count);
    }
}