package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter Id: "));
        Item item = tracker.findById(String.valueOf(id));
        if (item != null) {
            out.println(item);
        } else {
            out.println("Id not found!");
        }
        return true;
    }
}
