package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter Id: "));
        if (tracker.delete(id)) {
            System.out.println("The item has been deleted.");
        } else System.out.println("Error! Please try again!");
        return true;
    }
}
