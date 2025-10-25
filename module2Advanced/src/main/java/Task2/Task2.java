package Task2;

import java.util.HashSet;

public class Task2 {
    public static void main(String[] args) {
        Currency c1 = new Currency("USD", "Dollar");
        Currency c2 = new Currency("USD", "US Dollar");

        System.out.println("c1.equals(c2) = " + c1.equals(c2)); // true

        HashSet<Currency> set = new HashSet<>();
        set.add(c1);
        set.add(c2);

        System.out.println("HashSet size = " + set.size());

        System.out.println("set.contains(c1): " + set.contains(c1));
        System.out.println("set.contains(c2): " + set.contains(c2));
    }
}
