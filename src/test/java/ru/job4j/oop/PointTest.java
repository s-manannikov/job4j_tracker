package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenPoint3d() {
        Point first = new Point(0, 0, 3);
        Point second = new Point(0, 2, 6);
        double rsl = first.distance3d(second);
        assertThat(rsl, closeTo(3.60, 0.01));
    }
}