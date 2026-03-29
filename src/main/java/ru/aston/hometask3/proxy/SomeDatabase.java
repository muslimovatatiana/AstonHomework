package ru.aston.hometask3.proxy;

public class SomeDatabase implements Database {
    @Override
    public void deleteRow(int id) {
        System.out.println("Запись с ID " + id + " успешно удалена из БД.");
    }
}
