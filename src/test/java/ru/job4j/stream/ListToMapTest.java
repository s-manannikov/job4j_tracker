package ru.job4j.stream;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListToMapTest extends TestCase {

    public void testConvert() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, "Student1"));
        students.add(new Student(20, "Student2"));
        students.add(new Student(30, "Student3"));
        students.add(new Student(30, "Student3"));
        ListToMap lm = new ListToMap();
        Map<String, Student> rsl = lm.convert(students);
        Map<String, Student> expected = Map.of(
                "Student1", new Student(10, "Student1"),
                "Student2", new Student(20, "Student2"),
                "Student3", new Student(30, "Student3"));
        assertThat(rsl, is(expected));
    }
}