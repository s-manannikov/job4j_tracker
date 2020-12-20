package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

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
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(1, "name"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "name");
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findByName("name").size(), is(0));
        }
    }

    @Test
    public void replaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "name");
            Item replacingItem = new Item(1, "new name");
            tracker.add(item);
            tracker.replace(item.getId(), replacingItem);
            assertThat(tracker.findByName("name").size(), is(0));
            assertThat(tracker.findByName("new name").size(), is(1));
        }
    }

    @Test
    public void findById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "name1");
            tracker.add(item);
            assertThat(tracker.findById(item.getId()).getName(), is("name1"));
        }
    }
}