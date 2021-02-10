package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenFoundById() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        LocalDateTime time = LocalDateTime.now();
        tracker.add(new Item(1, "Item", time));
        FindByIdAction action = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter Id: ")).thenReturn("1");
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "Item{id=1, name='Item', created=" + time + "}" + ln);
        assertEquals(tracker.findById(1).getName(), "Item");
    }

    @Test
    public void whenNotFoundById() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        LocalDateTime time = LocalDateTime.now();
        tracker.add(new Item(1, "Item", time));
        FindByIdAction action = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter Id: ")).thenReturn("2");
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "Id not found!" + ln);
        assertNull(tracker.findById(2));
    }

}