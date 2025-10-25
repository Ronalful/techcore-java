package Task3;

public class Task3 {
    public static void main(String[] args) {
        Student student1 = new Student("Dmitry", 20, 5);
        Student student2 = new Student("Maria", 19, 4);
        Student student3 = new Student("Dmitry", 20, 5);

        System.out.println("Студент 1: " + student1);
        System.out.println("Студент 2: " + student2);
        System.out.println("Студент 3: " + student3);

        System.out.println("Студент 1 равен студенту 2?: " + student1.equals(student2));
        System.out.println("Студент 1 равен студенту 3?: " + student1.equals(student3));
    }
}
