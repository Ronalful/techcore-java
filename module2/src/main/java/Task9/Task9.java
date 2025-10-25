package Task9;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task9 {
    public static void main(String[] args) {
        readFile("data.txt"); // Чтение не существующего файла
        System.out.println("\n\n");
        readFile("test.txt");
    }

    public static void readFile(String fileName) {
        BufferedReader reader = null;

        try {
            InputStream inputStream = Task9.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new IOException("Файл не найден: " + fileName);
            }

            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(streamReader);
            String line;
            System.out.println("Содержимое файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("Файл закрыт.");
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии файла: " + e.getMessage());
                }
            } else {
                System.out.println("Файл не был открыт, закрытие не требуется.");
            }
        }
    }
}
