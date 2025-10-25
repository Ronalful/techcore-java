package Task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task8 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        System.out.println("Список студентов");
        students.add(new Student("Dmitry", 20, 9.5));
        students.add(new Student("Maria", 19, 8.0));
        students.add(new Student("Alex", 21, 6.7));
        students.add(new Student("Olga", 22, 7.3));
        students.add(new Student("Ivan", 18, 5.5));
        students.add(new Student("Svetlana", 25, 9.9));
        students.add(new Student("Nikita", 23, 4.2));
        students.add(new Student("Andrew", 24, 8.3));

        for (Student s : students) {
            System.out.println(s);
        }

        double avg = students.stream()
                .filter(s -> s.getAge() > 20)
                .filter(s -> s.getName().startsWith("A"))
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0.0);

        System.out.println("\nСредний балл студентов старше 20 лет, чьи имена начинаются на 'A': " + avg);
    }
}
