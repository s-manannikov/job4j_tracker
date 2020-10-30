package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        List<String> first = Arrays.asList(left.split("\\."));
        List<String> second = Arrays.asList(right.split("\\."));
        int a = Integer.parseInt(first.get(0));
        int b = Integer.parseInt(second.get(0));
        return Integer.compare(a, b);
    }
}