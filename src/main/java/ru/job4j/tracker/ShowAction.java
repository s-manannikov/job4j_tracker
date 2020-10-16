package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "==== All items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== All items ====");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        return true;
    }
}
