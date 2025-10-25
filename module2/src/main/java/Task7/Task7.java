package Task7;

import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        var students = new HashMap<String, Student>();

        System.out.println("Список студентов");
        students.put("1", new Student("Dmitry", 20, 9.5));
        students.put("2", new Student("Maria", 19, 8.0));
        students.put("3", new Student("Alex", 21, 6.7));

        for (Map.Entry<String, Student> student : students.entrySet()) {
            System.out.println(student.getKey() + ": " + student.getValue());
        }

        System.out.println("\nСтудент с id 2: " + students.get("2"));

        System.out.println("\nУдаление студента с id 2");
        students.remove("2");
        System.out.println("\nИтоговый список студентов");
        for (Map.Entry<String, Student> student : students.entrySet()) {
            System.out.println(student.getKey() + ": " + student.getValue());
        }
    }
}
