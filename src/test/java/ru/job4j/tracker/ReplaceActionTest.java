package ru.job4j.tracker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;

public class ReplaceActionTest {

    @Ignore
    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Ignore
    @Test
    public void whenNotReplaced() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }
}