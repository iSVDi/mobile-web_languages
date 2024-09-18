package lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab2 {
    public static void main(String[] args) {
        Map<String, Integer> productsA = new HashMap<>();
        productsA.put("Молоко", 50);
        productsA.put("Хлеб", 30);
        productsA.put("Сыр", 20);

        Map<String, Integer> productsB = new HashMap<>();
        productsB.put("Яйца", 60);
        productsB.put("Масло", 40);
        productsB.put("Колбаса", 15);

        SupermarketA supermarketA = new SupermarketA(
                "Супермаркет А",
                "ул. Ленина, 5",
                productsA,
                new ArrayList<>(List.of("Иванов", "Петров")),
                "Сидоров"
        );

        Supermarket supermarketB = new SupermarketB(
                "Супермаркет B",
                "ул. Советская, 10",
                productsB,
                new ArrayList<>(List.of("Смирнов", "Николаев")),
                "Лебедев"
        );

        supermarketA.purchaseProduct("Молоко", 5);
        supermarketA.checkAndRestockProduct("Иванов", "Молоко", 10, 20);
        supermarketB.purchaseProduct("Колбаса", 10);
        supermarketB.checkAndRestockProduct("Смирнов", "Колбаса", 5, 20);
    }
}
