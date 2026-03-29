package ru.aston.hometask3.builder;

public class House {
    private final FoundationType foundation;
    private final WallMaterial wallMaterial;
    private final FloorCount floorCount;
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final RoofType roofType;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.wallMaterial = builder.walls;
        this.floorCount = builder.floors;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.roofType = builder.roofType;
    }

    @Override
    public String toString() {
        return String.format("Дом: [Фундамент: %s, Стены: %s, Этажей: %d, Гараж: %b, Бассейн: %b, Крыша: %s]",
                foundation.getDescription(), wallMaterial.getName(), floorCount.getValue(), hasGarage, hasSwimmingPool, roofType.getDescription());
    }

    public static class HouseBuilder {
        private final FoundationType foundation;
        private final WallMaterial walls;
        private FloorCount floors = FloorCount.BUNGALOW;
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;
        private RoofType roofType = RoofType.FLAT;

        public HouseBuilder(FoundationType foundation, WallMaterial walls) {
            this.foundation = foundation;
            this.walls = walls;
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

        public House build() {
            return new House(this);
        }
    }
}

