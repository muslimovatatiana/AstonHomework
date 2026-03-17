package ru.aston.hometask1;

import java.util.ArrayList;
import java.util.List;

/**
 * Программа отображает количество элементов в списке хранимых материалов в бочке
 * Barrel - неизменяемый класс, поэтому после создания объекта,
 * изменения списка хранимых материалов не затрагивают данные в объекте Barrel
 */
public class BarrelDemo {
    public static void main(String[] args) {
        List<StoredMaterial> storedMaterials = new ArrayList<>();
        storedMaterials.add(new StoredMaterial("vine", "liquid"));
        storedMaterials.add(new StoredMaterial("water", "liquid"));
        storedMaterials.add(new StoredMaterial("wheat", "loose"));

        Barrel barrel = new Barrel(100, storedMaterials, "wood");

        storedMaterials.add(new StoredMaterial("beer", "liquid")); //добавили в список материал, в данных по бочке ничего не должно меняться

        System.out.println(barrel.getStoredMaterial().size() + " materials were stored in the barrel.");
    }
}
