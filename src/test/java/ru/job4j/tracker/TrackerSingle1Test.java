package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle1Test {

    @Test
    public void whenTrackerIsTracker() {
        TrackerSingle1 tracker = TrackerSingle1.getInstance();
        TrackerSingle1 tracker2 = TrackerSingle1.getInstance();
        assertThat(tracker, is(tracker2));
    }
}
