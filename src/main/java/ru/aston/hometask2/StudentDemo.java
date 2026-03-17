package ru.aston.hometask2;

import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Программа
 * Выводит в консоль инфо о студентах из файла studentsBooks.json,
 * ищет книгу, после чего отображает год найденной книги
 */
public class StudentDemo {

    public static void main(String[] args) {
        List<Student> students = StudentJsonProcessor.parseStudentsFromJsonString();

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> Optional.ofNullable(student.getBooks()).stream())
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(book -> {
                    Integer year = book.getYear();
                    return year != null && year > 2000;
                })
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}