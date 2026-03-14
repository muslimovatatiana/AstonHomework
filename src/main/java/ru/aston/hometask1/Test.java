package ru.aston.hometask1;

import java.util.ArrayList;
import java.util.List;

/**
 * Программа отображает количество элементов в списке хранимых материалов в бочке
 * Barrel - неизменяемый класс, поэтому после создания объекта,
 * изменения списка хранимых материалов не затрагивают данные в объекте Barrel
 * */
public class Test {
    public static void main(String[] args) {
        List<Material> materials = new ArrayList<>();
        materials.add(new Material("vine", "liquid"));
        materials.add(new Material("water", "liquid"));
        materials.add(new Material("wheat", "loose"));

        Barrel barrel = new Barrel(100, materials, "wood");
        //barrel.getStoredMaterial().add(new Material("buckwheat", "loose")); //проверка на выбрасывание исключения java.lang.UnsupportedOperationException

        materials.add(new Material("beer", "liquid")); //добавили в список материал, в данных по бочке ничего не должно меняться

        System.out.println(barrel.getStoredMaterial().size() + " materials were stored in the barrel.");
    }
}
