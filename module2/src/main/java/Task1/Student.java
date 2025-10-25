package Task1;

public class Student {
    private String name;
    private int age;
    private double averageGrade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        if (averageGrade < 0 || averageGrade > 10) {
            throw new IllegalArgumentException("averageGrade должно быть от 0 до 10");
        }
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", averageGrade=" + averageGrade;
    }
}
