package ru.aston.hometask2;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable {
    private final Integer pagination;
    private final String name;
    private final String author;
    private final Integer year;

    public Book(int pagination, String name, String author, Integer year) {
        this.pagination = pagination;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Integer getPagination() {
        return pagination;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        String format = "Книга: %s; Автор: %s; Год выпуска: %s; Кол-во страниц: %d";
        return String.format(format, this.name, this.author, this.year, this.pagination);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return Objects.equals(pagination, other.getPagination())
                && Objects.equals(year, other.year)
                && Objects.equals(name, other.name)
                && Objects.equals(author, other.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year, pagination);
    }

    @Override
    public int compareTo(Object obj) {
        Book other = (Book) obj;
        return Objects.compare(this.getPagination(), other.getPagination(), Comparator.nullsFirst(Integer::compareTo));
    }
}
