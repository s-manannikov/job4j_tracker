package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenFoundByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        LocalDateTime time = LocalDateTime.now();
        tracker.add(new Item(1, "Item", time));
        FindByNameAction action = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter name: ")).thenReturn("Item");
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "Item{id=1, name='Item', created=" + time + "}" + ln);
        assertEquals(tracker.findByName("Item").get(0).getName(), "Item");
    }

    @Test
    public void whenNotFoundByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        LocalDateTime time = LocalDateTime.now();
        tracker.add(new Item(1, "Item", time));
        FindByNameAction action = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter name: ")).thenReturn("Another item");
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "Name not found!" + ln);
    }
}