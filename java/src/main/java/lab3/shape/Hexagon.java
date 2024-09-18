package lab3.shape;

import java.util.ArrayList;

class Hexagon extends Shape {

    Hexagon(ArrayList<Point> points) {
        n = 6;
        super.points = points;
        id = 'H';
    }

    @Override
    public void info() {
        System.out.println("Hexagon");
        super.printPoints();
    }

    @Override
    public float getArea() {
        float square = 0f;
        for (int i = 0; i < n; i++) {
            var nextI = (i+1) % n;
            square += points.get(i).x * points.get(nextI).y;
        }
        return Math.abs(square);
    }

    @Override
    public Point getCenter() {
        float xSum = 0;
        float ySum = 0;

        for (Point point: points) {
            xSum += point.x;
            ySum += point.y;
        }

        return new Point(xSum / n, ySum / n);
    }
}
