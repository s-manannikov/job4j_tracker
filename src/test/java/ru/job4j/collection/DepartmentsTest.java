package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenThreeDeps() {
        List<String> input = Arrays.asList("k1/sk1/ssk1", "k2/sk2/ssk2/");
        List<String> expect = Arrays.asList(
                "k1", "k1/sk1", "k1/sk1/ssk1",
                "k2", "k2/sk2", "k2/sk2/ssk2"
        );
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenFillAllAndSortAsc() {
        List<String> input = Arrays.asList(
                "k1/sk1/ssk1",
                "k1/sk2",
                "k1/sk1/ssk2",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        List<String> result = Departments.fillGaps(input);
        Departments.sortAsc(result);
        List<String> expect = Arrays.asList(
                "k1",
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k1/sk2",
                "k2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenFillAllAndSortDesc() {
        List<String> input = Arrays.asList(
                "k1/sk1/ssk1",
                "k1/sk2",
                "k1/sk1/ssk2",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        List<String> result = Departments.fillGaps(input);
        Departments.sortDesc(result);
        List<String> expect = Arrays.asList(
                "k2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2",
                "k1",
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k1/sk2"
        );
        assertThat(result, is(expect));
    }
}