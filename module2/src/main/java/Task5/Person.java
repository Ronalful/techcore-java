package Task5;

public class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("Я человек с именем " + name);
    }
}
