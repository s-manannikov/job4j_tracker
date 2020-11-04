package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        List<Student> stud = students.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        return filter(students, predicate);
    }

    private static List<Student> filter(List<Student> students, Predicate<Student> predicate) {
        List<Student> list = new ArrayList<>();
        for (Student stud : students) {
            if (predicate.test(stud)) {
                list.add(stud);
            }
        }
        return list;
    }
}
