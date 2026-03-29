package ru.aston.hometask3.adapter;

public class SocketAdapter implements ModernSocket {
    private OldSocket oldSocket;

    public SocketAdapter(OldSocket os) {
        this.oldSocket = os;
    }

    public void supplyPower() {
        oldSocket.provideElectricity();
    }
}
