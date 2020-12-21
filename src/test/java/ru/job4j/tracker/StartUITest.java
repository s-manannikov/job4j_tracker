package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    public Connection init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCreateItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0", "Item name", "1"}
            );
            UserAction[] actions = {
                    new CreateAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, Arrays.asList(actions));
            assertThat(tracker.findAll().get(0).getName(), is("Item name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplaceItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
        Output out = new StubOutput();
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
        } catch (Exception e) {
            e.printStackTrace();
            }
    }

    @Test
    public void whenDeleteItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
        Output out = new StubOutput();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenExit() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                        "Menu." + System.lineSeparator()
                                + "0. ==== Exit ====" + System.lineSeparator()
        ));
    } catch (Exception e) {
        e.printStackTrace();
        }
    }

    @Test
    public void whenShowAllItems() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindById() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
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
    } catch (Exception e) {
        e.printStackTrace();
        }
    }

    @Test
    public void whenFindByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenInvalidExit() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"10", "0"}
        );
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
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
}