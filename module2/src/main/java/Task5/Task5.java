package Task5;

public class Task5 {
    public static void main(String[] args) {
        Person[] people = {
                new Student("Dmitry"),
                new Teacher("Ivan")
        };

        people[0].introduce();
        people[1].introduce();
    }
}
