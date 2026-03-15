package ru.aston.hometask1;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public final class Barrel {
    private final List<StoredMaterial> storedMaterial;
    private final double volumeInLiters;
    private final String materialOfManufacture;

    public Barrel(double volumeInLiters, List<StoredMaterial> storedMaterials, String materialOfManufacture) {
        this.volumeInLiters = volumeInLiters;
        this.materialOfManufacture = materialOfManufacture;
        this.storedMaterial = Stream.ofNullable(storedMaterials)
                .flatMap(Collection::stream)
                .map(StoredMaterial::new)
                .toList();
    }

    public double getVolumeInLiters() {
        return volumeInLiters;
    }

    public String getMaterialOfManufacture() {
        return materialOfManufacture;
    }

    public List<StoredMaterial> getStoredMaterial() {
        return storedMaterial;
    }
}