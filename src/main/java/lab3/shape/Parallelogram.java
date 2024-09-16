package lab3.shape;

import java.sql.SQLOutput;

class Parallelogram extends Shape {
    Parallelogram(Point[] points) {
        n = 4;
        super.points = points;
        id = 'P';
    }

    @Override
    public void info() {
        System.out.println("Parallelogram");
        System.out.println("Points:");
        for (int i = 0; i < n; i++) {
            System.out.println(points[i].x + "," + points[i].y);
        }
    }

    @Override
    public float getArea() {
        Point v1 = new Point(points[1].x - points[0].x, points[1].y - points[0].y);
        Point v2 = new Point(points[3].x - points[0].x, points[3].y - points[0].y);

        // векторное произведение
        return Math.abs(v1.x * v2.y - v1.y * v2.x);
    }

    @Override
    public Point getCenter() {
        float xCenter = (points[0].x + points[2].x) / 2;
        float yCenter = (points[0].y + points[2].y) / 2;
        return new Point(xCenter, yCenter);
    }
}
