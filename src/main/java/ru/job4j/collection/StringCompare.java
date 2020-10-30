package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = Integer.compare(left.length(), right.length());
        int j = 0;
            for (int i = 0; i < (Math.min(left.length(), right.length())); i++) {
                if (left.charAt(i) != right.charAt(j)) {
                    rsl = Character.compare(left.charAt(i), right.charAt(j));
                    break;
                }
                j++;
            }
        return rsl;
    }
}