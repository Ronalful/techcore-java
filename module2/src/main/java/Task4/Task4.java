package Task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task4 {
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

        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("\n\nОтсортированный список студентов по имени");
        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getAverageGrade(), o1.getAverageGrade());
            }
        });

        System.out.println("\n\nОтсортированный список студентов по averageGrade по убыванию");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
