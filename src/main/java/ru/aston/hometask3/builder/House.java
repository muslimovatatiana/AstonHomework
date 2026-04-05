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
        this.foundationSpecs = builder.foundation.build();
    }

    public static HouseBuilder builder() {
        return new HouseBuilder();
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
        private WallMaterial walls;
        private FloorCount floors;
        private boolean hasGarage;
        private boolean hasSwimmingPool;
        private RoofType roofType;
        private String address;
        private boolean isSafe;
        private FoundationStrategy foundation;

        private HouseBuilder() {
        }

        public HouseBuilder walls(WallMaterial wallMaterial) {
            this.walls = wallMaterial;
            return this;
        }

        public HouseBuilder address(String address) {
            this.address = address;
            return this;
        }

        public HouseBuilder floors(FloorCount floorCount) {
            this.floors = floorCount;
            return this;
        }

        public HouseBuilder hasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder hasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder roofType(RoofType roofType) {
            this.roofType = roofType;
            return this;
        }

        public HouseBuilder isSafe(boolean isSafe) {
            this.isSafe = isSafe;
            return this;
        }

        public HouseBuilder foundation(FoundationStrategy foundation) {
            this.foundation = foundation;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
