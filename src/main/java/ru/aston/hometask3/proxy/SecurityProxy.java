package ru.aston.hometask3.proxy;

public class SecurityProxy implements SecuritySystem {
    private final HouseSecurity realSystem = new HouseSecurity();
    private final String password;

    public SecurityProxy(String password) {
        this.password = password;
    }

    public void unlock() {
        if ("1234".equals(password)) realSystem.unlock();
        else System.out.println("Доступ запрещен!");
    }
}
