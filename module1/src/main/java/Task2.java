public class Task2 {
    public static void main(String[] args) {
        byte byteMin = Byte.MIN_VALUE;
        byte byteMax = Byte.MAX_VALUE;
        short shortMin = Short.MIN_VALUE;
        short shortMax = Short.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;
        int intMax = Integer.MAX_VALUE;
        long longMin = Long.MIN_VALUE;
        long longMax = Long.MAX_VALUE;

        float floatMin = Float.MIN_VALUE;
        float floatMax = Float.MAX_VALUE;
        double doubleMin = Double.MIN_VALUE;
        double doubleMax = Double.MAX_VALUE;

        boolean boolTrue = true;
        boolean boolFalse = false;

        char charMin = Character.MIN_VALUE;
        char charMax = Character.MAX_VALUE;

        String text = "Привет, Java!";

        System.out.println("=== Примитивные типы данных ===");
        System.out.println("byte:    " + byteMin + " .. " + byteMax + " | размер: 1 байт");
        System.out.println("short:   " + shortMin + " .. " + shortMax + " | размер: 2 байта");
        System.out.println("int:     " + intMin + " .. " + intMax + " | размер: 4 байта");
        System.out.println("long:    " + longMin + " .. " + longMax + " | размер: 8 байт");
        System.out.println("float:   " + floatMin + " .. " + floatMax + " | размер: 4 байта");
        System.out.println("double:  " + doubleMin + " .. " + doubleMax + " | размер: 8 байт");
        System.out.println("boolean: " + boolTrue + ", " + boolFalse + " | размер: 1 бит");
        System.out.println("char:    '" + (int) charMin + "' .. '" + (int) charMax + "' | размер: 2 байта");

        System.out.println("\n=== Ссылочный тип ===");
        System.out.println("String: " + text);
    }
}
