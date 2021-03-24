package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenCreate() {
        Store store = new HbmTracker();
        Item item1 = new Item(1, "item1");
        store.add(item1);
        List<Item> items = store.findAll();
        assertEquals(items.get(0).getId(), 1);
    }

    @Test
    public void whenFindAll() {
        Store store = new HbmTracker();
        Item item1 = new Item(1, "item1");
        Item item2 = new Item(2, "item2");
        store.add(item1);
        store.add(item2);
        List<Item> list = store.findAll();
        assertEquals(list.get(0).getId(), 1);
        assertEquals(list.get(1).getId(), 2);
    }

    @Test
    public void whenReplace() {
        Store store = new HbmTracker();
        Item item1 = new Item(1, "item1");
        Item item2 = new Item(2, "item2");
        store.add(item1);
        store.replace(1, item2);
        assertEquals(store.findById(1).getName(), "item2");
    }

    @Test
    public void whenFindById() {
        Store store = new HbmTracker();
        Item item1 = new Item(1, "item1");
        store.add(item1);
        assertEquals(store.findById(1).getName(), "item1");
    }

    @Test
    public void whenFindByName() {
        Store store = new HbmTracker();
        Item item1 = new Item(1, "item1");
        store.add(item1);
        assertEquals(store.findByName("item1").get(0).getId(), 1);
    }

    @Test
    public void whenDelete() {
        Store store = new HbmTracker();
        Item item1 = new Item(1, "item1");
        store.add(item1);
        store.delete(1);
        assertEquals(store.findAll().size(), 0);
    }
}