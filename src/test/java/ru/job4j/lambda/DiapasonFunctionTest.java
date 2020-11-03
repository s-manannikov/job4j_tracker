package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DiapasonFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = DiapasonFunction.diapason(
                3, 6,
                x -> (2 * Math.pow(x, 2)) - (4 * x) + 3);
        List<Double> expected = Arrays.asList(9D, 19D, 33D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = DiapasonFunction.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}