package ru.aston.hometask3.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Database userProxy = new DatabaseProxy("USER");
        userProxy.deleteRow(101);

        Database adminProxy = new DatabaseProxy("ADMIN");
        adminProxy.deleteRow(101);
    }
}
