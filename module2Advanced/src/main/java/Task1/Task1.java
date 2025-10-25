package Task1;

public class Task1 {
    public static void main(String[] args) {
        // Корректный банковский аккаунт
        BankAccount bankAccount1 = new BankAccount("Dmitry", 100);

        // Некорректный банковский аккаунт
        BankAccount bankAccount2 = new BankAccount("John", -100);
    }
}
