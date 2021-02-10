package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item"));
        DeleteAction action = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter Id: ")).thenReturn("1");
        action.execute(input, tracker);
        assertTrue(tracker.findAll().isEmpty());
    }

    @Test
    public void whenNotDeleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item"));
        DeleteAction action = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter Id: ")).thenReturn("0");
        action.execute(input, tracker);
        assertEquals(tracker.findAll().get(0).getName(), "Item");
    }
}