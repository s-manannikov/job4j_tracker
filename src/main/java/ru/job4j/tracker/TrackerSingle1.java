package ru.job4j.tracker;

import ru.job4j.tracker.Item;

public enum TrackerSingle1 {
    INSTANCE;

    public static TrackerSingle1 getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}