package Task5;

public class Teacher extends Person{
    public Teacher(String name) {
        super(name);
    }

    @Override
    public void introduce() {
        System.out.println("Я учитель с именем " + name);
    }
}
