package lab3.shape;

public class FactoryShape {
    public Shape createShape(char id, Point[] points) {
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
