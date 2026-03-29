package ru.aston.hometask3.proxy;

public class DatabaseProxy implements Database {
    private final SomeDatabase someDatabase;
    private final String userRole;

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
        this.someDatabase = new SomeDatabase();
    }

    @Override
    public void deleteRow(int id) {
        if ("ADMIN".equalsIgnoreCase(userRole)) {
            someDatabase.deleteRow(id);
        } else {
            System.out.println("Отказ в доступе: у пользователя с ролью '" + userRole + "' нет прав на удаление.");
        }
    }
}
