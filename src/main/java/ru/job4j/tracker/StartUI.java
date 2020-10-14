package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("==== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Input input, Tracker tracker) {
        System.out.println("==== All items ====");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        int id = Integer.valueOf(input.askStr("Enter Id: "));
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("The item has been edited.");
        } else System.out.println("Error! Please try again!");
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        int id = Integer.valueOf(input.askStr("Enter Id: "));
        if (tracker.delete(id)) {
            System.out.println("The item has been deleted.");
        } else System.out.println("Error! Please try again!");
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("==== Find item by Id ====");
        int id = Integer.valueOf(input.askStr("Enter Id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else System.out.println("Id not found!");
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else System.out.println("Name not found!");
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}