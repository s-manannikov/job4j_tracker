package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public Map<String, Student> convert(List<Student> students) {
        return students.stream().
                collect(Collectors.toMap(Student::getSurname, s -> s, (s1, s2) -> s1));
    }
}
