package ru.aston.hometask3.builder;

import ru.aston.hometask3.strategy.FoundationStrategy;

public class House {
    private final String foundationSpecs;
    private final WallMaterial wallMaterial;
    private final FloorCount floorCount;
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final RoofType roofType;
    private final String address;
    private boolean isSafe;

    private House(HouseBuilder builder) {
        this.wallMaterial = builder.walls;
        this.floorCount = builder.floors;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.roofType = builder.roofType;
        this.address = builder.address;
        this.isSafe = builder.isSafe;
        this.foundationSpecs = builder.strategy.build();
    }

    @Override
    public String toString() {
        return String.format("Дом по адресу: %s - Фундамент: %s, Стены: %s, Этажей: %d, " +
                        "Гараж: %b, Бассейн: %b, Крыша: %s, безопасность: %b",
                address, foundationSpecs, wallMaterial.getDescription(), floorCount.getValue(), hasGarage,
                hasSwimmingPool, roofType.getDescription(), isSafe);
    }

    public String getAddress() {
        return address;
    }

    public WallMaterial getWalls() {
        return wallMaterial;
    }

    public void setSafe(boolean safe) {
        isSafe = safe;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public RoofType getRoof() {
        return roofType;
    }

    public String getFoundationSpecs() {
        return foundationSpecs;
    }

    public static class HouseBuilder {
        private final WallMaterial walls;
        private FloorCount floors = FloorCount.BUNGALOW;
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;
        private RoofType roofType = RoofType.FLAT;
        private final String address;
        private boolean isSafe = true;
        private FoundationStrategy strategy;

        public HouseBuilder(WallMaterial walls, String address) {
            this.walls = walls;
            this.address = address;
        }

        public HouseBuilder setFloors(FloorCount floors) {
            this.floors = floors;
            return this;
        }

        public HouseBuilder addGarage() {
            this.hasGarage = true;
            return this;
        }

        public HouseBuilder addPool() {
            this.hasSwimmingPool = true;
            return this;
        }

        public HouseBuilder setRoof(RoofType roofType) {
            this.roofType = roofType;
            return this;
        }

        public House buildHouse() {
            return new House(this);
        }

        public HouseBuilder setSafe(boolean isSafe) {
            this.isSafe = isSafe;
            return this;
        }

        public HouseBuilder setFoundationPlan(FoundationStrategy strategy) {
            this.strategy = strategy;
            return this;
        }


    }
}

