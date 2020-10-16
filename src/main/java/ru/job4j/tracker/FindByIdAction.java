package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "==== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter Id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else System.out.println("Id not found!");
        return true;
    }
}
