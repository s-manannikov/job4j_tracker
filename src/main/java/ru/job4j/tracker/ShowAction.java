package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== All items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        System.out.println("==== All items ====");
        List<Item> items = tracker.findAll();
        for (int i = 0; i < items.size(); i++) {
            out.println(items.get(i));
        }
        return true;
    }
}
