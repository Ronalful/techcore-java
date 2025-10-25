package Task5;

public class Student extends Person {

    public Student(String name) {
        super(name);
    }

    @Override
    public void introduce() {
        System.out.println("Я студент с именем " + name);
    }
}
