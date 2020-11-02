package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] a = o1.split("/");
        String[] b = o2.split("/");
        int rsl = b[0].compareTo(a[0]);
        if (rsl != 0) {
            return rsl;
        }
        return o1.compareTo(o2);
    }
}









/*        int rsl;
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

 */