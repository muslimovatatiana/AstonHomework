package ru.aston.hometask2;

import java.util.List;

public class Student {
    private final Integer id;
    private final List<Book> books;
    private final String name;
    private final String lastname;
    private final String group;

    public Student(Integer id, List<Book> books, String name, String lastname, String group) {
        this.id = id;
        this.books = books;
        this.name = name;
        this.lastname = lastname;
        this.group = group;
    }

    @Override
    public String toString() {
        String format = "Студент %d: %s %s; Группа: %s";
        return String.format(format, this.id, this.lastname, this.name, this.group);
    }

    public List<Book> getBooks() {
        return books;
    }

}
