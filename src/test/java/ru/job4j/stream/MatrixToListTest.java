package ru.job4j.stream;

import junit.framework.TestCase;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest extends TestCase {

    public void testConvert() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        MatrixToList mtl = new MatrixToList();
        List<Integer> rsl = mtl.convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }
}