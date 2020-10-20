package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle3Test {

    @Test
    public void whenTrackerIsTracker() {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
        TrackerSingle3 tracker2 = TrackerSingle3.getInstance();
        assertThat(tracker, is(tracker2));
    }
}
