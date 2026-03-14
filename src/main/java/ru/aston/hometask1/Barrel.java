package ru.aston.hometask1;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Класс Бочка
 */
public final class Barrel {
    /**
    * Хранимые материалы (текущий хранимый материал - последний в списке)
    */
    private final List<Material> storedMaterial;
    /**
    * Объем бочки в литрах
    */
    private final double volume;
    /**
     * Материал из которого изготовлена бочка
     */
    private final String materialOfManufacture;

    public Barrel(double volume, List<Material> storedMaterial, String materialOfManufacture) {
        this.volume = volume;
        this.materialOfManufacture = materialOfManufacture;
        this.storedMaterial = Stream.ofNullable(storedMaterial)
                .flatMap(Collection::stream)
                .map(Material::new)
                .toList();
    }

    public double getVolume() {
        return volume;
    }

    public String getMaterialOfManufacture() {
        return materialOfManufacture;
    }

    public List<Material> getStoredMaterial() {
        return storedMaterial;
    }
}