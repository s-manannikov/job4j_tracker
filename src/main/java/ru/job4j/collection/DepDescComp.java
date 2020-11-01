package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl;
        List<String> a = Arrays.asList(o1.split("/"));
        List<String> b = Arrays.asList(o2.split("/"));
        if (a.get(0).equals(b.get(0))) {
                rsl = o1.compareTo(o2);
            } else {
                rsl = o2.compareTo(o1);
            }
        return rsl;
    }
}