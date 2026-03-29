package ru.aston.hometask3.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        House simpleHouse = new House.HouseBuilder(FoundationType.CONCRETE, WallMaterial.BRICK)
                .build();

        House myCottage = new House.HouseBuilder(FoundationType.WOODEN, WallMaterial.WOOD)
                .setFloors(FloorCount.DUPLEX)
                .setRoof(RoofType.GABLE)
                .build();

        House mansion = new House.HouseBuilder(FoundationType.STONE, WallMaterial.CONCRETE)
                .setFloors(FloorCount.MANSION)
                .setRoof(RoofType.MANSARD)
                .addGarage()
                .addPool()
                .build();

        System.out.println(simpleHouse);
        System.out.println(myCottage);
        System.out.println(mansion);
    }
}

