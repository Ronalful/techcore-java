package Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Apple", 1.5, 0.2));
        products.add(new Product("Banana", 0.8, 0.25));
        products.add(new Product("Orange", 1.2, 0.3));
        products.add(new Product("Milk", 2.0, 1.0));
        products.add(new Product("Bread", 1.0, 0.5));
        products.add(new Product("Cheese", 5.0, 0.4));
        products.add(new Product("Eggs", 3.0, 0.6));
        products.add(new Product("Tomato", 0.9, 0.2));
        products.add(new Product("Potato", 0.5, 0.3));
        products.add(new Product("Chicken", 7.0, 1.5));

        System.out.println("Продукты");
        for (Product p : products) {
            System.out.println(p.getName() + " - Price: " + p.getPrice() + ", Weight: " + p.getWeight());
        }

        Collections.sort(products);
        System.out.println("\n\nЕстественная сортировка");
        for (Product p : products) {
            System.out.println(p.getName() + " - Price: " + p.getPrice() + ", Weight: " + p.getWeight());
        }

        products.sort(Comparator.comparing(Product::getName));
        System.out.println("\n\nСортировка по названию");
        for (Product p : products) {
            System.out.println(p.getName() + " - Price: " + p.getPrice() + ", Weight: " + p.getWeight());
        }

        products.sort(Comparator.comparing(Product::getWeight).reversed());
        System.out.println("\n\nСортировка по весу (в обратном порядке)");
        for (Product p : products) {
            System.out.println(p.getName() + " - Price: " + p.getPrice() + ", Weight: " + p.getWeight());
        }
    }
}
