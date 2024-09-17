package lab3.shape;

import java.util.ArrayList;

public class FactoryShape {
    public Shape createShape(char id, ArrayList<Point> points) {
        return switch (id) {
            case 'P' -> new Parallelogram(points);
            case 'H' -> new Hexagon(points);
            default -> {
                System.out.println("Shape with such id cannot be crated");
                yield null;
            }
        };
    };
}
