package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                        "Menu." + System.lineSeparator()
                                + "0. ==== Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllItems() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                        "Menu." + System.lineSeparator()
                                + "0. ==== All items ====" + System.lineSeparator()
                                + "1. ==== Exit ====" + System.lineSeparator()
                                + item + System.lineSeparator()
                                + "Menu." + System.lineSeparator()
                                + "0. ==== All items ====" + System.lineSeparator()
                                + "1. ==== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. ==== Find item by Id ====" + System.lineSeparator()
                        + "1. ==== Exit ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. ==== Find item by Id ====" + System.lineSeparator()
                        + "1. ==== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. ==== Find items by name ====" + System.lineSeparator()
                        + "1. ==== Exit ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. ==== Find items by name ====" + System.lineSeparator()
                        + "1. ==== Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"10", "0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. ==== Exit ====%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. ==== Exit ====%n"
                )
        ));
    }
}