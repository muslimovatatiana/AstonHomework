package ru.aston.hometask3;

import ru.aston.hometask3.adapter.ModernSocket;
import ru.aston.hometask3.adapter.OldSocket;
import ru.aston.hometask3.adapter.SocketAdapter;
import ru.aston.hometask3.builder.FloorCount;
import ru.aston.hometask3.builder.House;
import ru.aston.hometask3.builder.RoofType;
import ru.aston.hometask3.builder.WallMaterial;
import ru.aston.hometask3.chain.InspectionChain;
import ru.aston.hometask3.decorator.Building;
import ru.aston.hometask3.decorator.SimpleHouse;
import ru.aston.hometask3.decorator.SmartLockDecorator;
import ru.aston.hometask3.proxy.SecurityProxy;
import ru.aston.hometask3.proxy.SecuritySystem;
import ru.aston.hometask3.strategy.ConcreteFoundation;

public class ConstructionDemo {
    public static void main(String[] args) {
        House myHouse = House.builder()
                .address("ул. Московская 15")
                .floors(FloorCount.DUPLEX)
                .foundation(new ConcreteFoundation())
                .walls(WallMaterial.BRICK)
                .roofType(RoofType.GABLE)
                .hasGarage(true)
                .hasSwimmingPool(true)
                .isSafe(true)
                .build();
        System.out.println(myHouse.toString());

        Building smartHouse = new SmartLockDecorator(new SimpleHouse());
        smartHouse.describe();

        ModernSocket socket = new SocketAdapter(new OldSocket());
        socket.supplyPower();

        SecuritySystem gate1 = new SecurityProxy("not 1234");
        gate1.unlock();
        SecuritySystem gate2 = new SecurityProxy("1234");
        gate2.unlock();

        InspectionChain chain = new InspectionChain()
                .addStep(h -> System.out.println("Инспекция по адресу: " + h.getAddress()))
                .addStep(h -> {
                    System.out.println("Проверка материала стен: " + h.getWalls().getDescription());
                    if (h.getWalls() == null) h.setSafe(false);
                })
                .addStep(h -> System.out.println("Проверка крыши (" + h.getRoof().getDescription() + ")... OK"))
                .addStep(h -> {
                    System.out.println("Проверка фундамента...");
                    if (h.getFoundationSpecs().contains("бетон")) {
                        System.out.println("Надежно!");
                    }
                });
        chain.process(myHouse);
    }
}
