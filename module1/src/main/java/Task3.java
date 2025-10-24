import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Консольный калькулятор ===");
        System.out.println("Введите выражение в формате: число1 операция число2");
        System.out.println("Поддерживаемые операции: +, -, *, /");
        System.out.println("Для выхода введите: exit");

        while (true) {
            System.out.print("\nВведите выражение или 'exit': ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы...");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Ошибка: введите выражение в формате: число операция число");
                continue;
            }

            try {
                double num1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double num2 = Double.parseDouble(parts[2]);
                double result;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Ошибка: деление на ноль!");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Ошибка: неизвестная операция '" + operator + "'");
                        continue;
                }

                System.out.println("Результат: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введены некорректные числа.");
            }
        }

        scanner.close();
    }
}
