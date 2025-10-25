package Task2;

public class Task2 {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Dmitry", 20);
        Student student3 = new Student("Dmitry", 20, 5);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}
