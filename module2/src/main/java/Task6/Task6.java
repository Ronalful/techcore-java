package Task6;

import java.util.ArrayList;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(10));
        shapes.add(new Rectangle(5,2));

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
