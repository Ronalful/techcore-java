package task7;

public class Task7 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Dmitry", 20, 4.95),
                new Student("Anna", 19, 4.8),
                new Student("Ivan", 21, 4.6),
                new Student("Elena", 20, 5.0),
                new Student("Alexey", 22, 4.7)
        };

        for (Student student : students) {
            System.out.println(student);
        }

        var studentWithMaxAverageGrade = students[0];
        for (Student student : students) {
            if (student.getAverageGrade() > studentWithMaxAverageGrade.getAverageGrade()) {
                studentWithMaxAverageGrade = student;
            }
        }
        System.out.println("\nСтудент с лучшей успеваемостью " + studentWithMaxAverageGrade);
    }
}
