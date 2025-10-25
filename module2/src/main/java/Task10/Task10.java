package Task10;

import java.util.HashMap;
import java.util.Map;

public class Task10 {
    public static void main(String[] args) {
        var students = new HashMap<String, Student>();

        System.out.println("Список студентов");
        students.put("1", new Student("Dmitry", 20, 9.5));
        students.put("2", new Student("Maria", 19, 8.0));
        students.put("3", new Student("Alex", 21, 6.7));

        for (Map.Entry<String, Student> student : students.entrySet()) {
            System.out.println(student.getKey() + ": " + student.getValue());
        }

        findStudentWithId(students, "1");
        findStudentWithId(students, "3");
        findStudentWithId(students, "10");
    }

    public static void findStudentWithId(HashMap<String, Student> students, String id) {
        var student = students.get(id);
        if (student == null) {
            throw new StudentNotFoundException("Студен с id %s не был найден".formatted(id));
        }
        System.out.println(student);
    }
}
