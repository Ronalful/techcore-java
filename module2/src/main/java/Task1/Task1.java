package Task1;

public class Task1 {
    public static void main(String[] args) {
        Student student1 = new Student();
        // Корректный случай
        student1.setAge(20);
        student1.setName("Dmitry");
        try {
            student1.setAverageGrade(3.5);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Было выброшено IllegalArgumentException");
        }
        System.out.println(student1);

        // Случай с ошибкой
        Student student2 = new Student();
        student2.setName("Ivan");
        student2.setAge(20);
        try {
            student2.setAverageGrade(-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Было выброшено IllegalArgumentException");
        }
        System.out.println(student2);
    }
}
