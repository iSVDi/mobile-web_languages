package lab3.shape;

import java.sql.SQLOutput;
import java.util.ArrayList;

class Parallelogram extends Shape {
    Parallelogram(ArrayList<Point> points) {
        n = 4;
        super.points = points;
        id = 'P';
    }

    @Override
    public void info() {
        System.out.println("Parallelogram");
        super.printPoints();
    }

    @Override
    public float getArea() {
        Point v1 = new Point(points.get(1).x - points.get(0).x, points.get(1).y - points.get(0).y);
        Point v2 = new Point(points.get(3).x - points.get(0).x, points.get(3).y - points.get(0).y);

        // векторное произведение
        return Math.abs(v1.x * v2.y - v1.y * v2.x);
    }

    @Override
    public Point getCenter() {
        float xCenter = (points.get(0).x + points.get(2).x) / 2;
        float yCenter = (points.get(0).y + points.get(2).y) / 2;
        return new Point(xCenter, yCenter);
    }
}
