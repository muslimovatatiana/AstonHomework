package homework1;

import java.util.List;

/**
 * Класс Бочка
 * Объем, Материал из которого изготовлена, Хранимые материалы (текущий хранимый материал - последний в списке)
 * */
public final class Barrel {
    private final List<Material> storedMaterial;
    private final Double volume;
    private final String materialOfManufacture;

    public Barrel(double volume, List<Material> storedMaterial, String materialOfManufacture) {
        this.volume = volume;
        this.materialOfManufacture = materialOfManufacture;
        this.storedMaterial = storedMaterial.stream()
                .map(Material::new)
                .toList();
    }

    public Double getVolume() {
        return volume;
    }

    public String getMaterialOfManufacture() {
        return materialOfManufacture;
    }

    public List<Material> getStoredMaterial() {
        return storedMaterial;
    }
}