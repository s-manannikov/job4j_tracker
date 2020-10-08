package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Ivanovich");
        student.setGroup(1234);
        student.setCreated(new Date());
        System.out.println(student.getName() +". Group: " + student.getGroup() + ". " + student.getCreated());
    }
}
