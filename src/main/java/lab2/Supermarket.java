package lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Абстрактный класс супермаркета
abstract class Supermarket {
    protected String name;
    protected String address;
    protected Map<String, Integer> products; // Перечень товаров с количеством
    protected ArrayList<String> managers;
    protected String cashier;

    public Supermarket(String name, String address, Map<String, Integer> products, ArrayList<String> managers, String cashier) {
        this.name = name;
        this.address = address;
        this.products = products;
        this.managers = managers;
        this.cashier = cashier;
    }

    // Абстрактные методы для работы менеджера и кассира
    public abstract void purchaseProduct(String product, int quantity);
    public abstract void checkAndRestockProduct(String manager, String product, int minQuantity, int restockAmount);

}

