import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите предложение для анализа:");
        String input = scanner.nextLine();

        String[] words = input.trim().split("\\s+");
        int wordCount = input.trim().isEmpty() ? 0 : words.length;

        String vowelsEng = "aeiou";
        String vowelsRus = "аеёиоуыэюя";
        int vowelsCount = 0;
        int consonantsCount = 0;

        String lowerInput = input.toLowerCase();

        for (int i = 0; i < lowerInput.length(); i++) {
            char ch = lowerInput.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
            else if (ch >= 'а' && ch <= 'я') {
                if (vowelsRus.indexOf(ch) != -1) {
                    vowelsCount++;
                } else if (ch != 'ь' && ch != 'ъ') {
                    consonantsCount++;
                }
            }
        }

        System.out.println("Количество слов: " + wordCount);
        System.out.println("Количество гласных букв: " + vowelsCount);
        System.out.println("Количество согласных букв: " + consonantsCount);

        scanner.close();
    }
}
