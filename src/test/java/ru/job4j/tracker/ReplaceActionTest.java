package ru.job4j.tracker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ReplaceActionTest {

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter Id: ")).thenReturn("1");
        when(input.askStr("Enter new name: ")).thenReturn(replacedName);
        rep.execute(input, tracker);
        assertEquals(tracker.findAll().get(0).getName(), replacedName);
    }

    @Test
    public void whenNotReplaced() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askStr("Enter Id: ")).thenReturn("0");
        rep.execute(input, tracker);
        assertEquals(tracker.findAll().get(0).getName(), "Replaced item");
    }
}