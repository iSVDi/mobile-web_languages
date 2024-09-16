package lab2;

import java.util.ArrayList;
import java.util.Map;

class SupermarketB extends Supermarket {

    public SupermarketB(String name, String address, Map<String, Integer> products, ArrayList<String> managers, String cashier) {
        super(name, address, products, managers, cashier);
    }

    @Override
    public void purchaseProduct(String product, int quantity) {
        if (products.containsKey(product)) {
            int availableQuantity = products.get(product);
            if (availableQuantity >= quantity) {
                products.put(product, availableQuantity - quantity);
                System.out.println(cashier + " продал " + quantity + " шт. " + product);
            } else {
                System.out.println("Недостаточно товара: " + product);
            }
        } else {
            System.out.println("Товар " + product + " не найден.");
        }
    }

    @Override
    public void checkAndRestockProduct(String manager, String product, int minQuantity, int restockAmount) {
        if (managers.contains(manager)) {
            if (products.containsKey(product)) {
                int currentQuantity = products.get(product);
                if (currentQuantity < minQuantity) {
                    products.put(product, currentQuantity + restockAmount);
                    System.out.println(manager + " пополнил товар " + product + " на " + restockAmount + " шт.");
                }
            } else {
                System.out.println("Товар " + product + " не найден для пополнения.");
            }
        } else {
            System.out.println("Менеджер " + manager + " не найден");
        }
    }
}


