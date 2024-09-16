package lab3.shape;

class Hexagon extends Shape {

    Hexagon(Point[] points) {
        n = 6;
        super.points = points;
        id = 'H';
    }

    @Override
    public void info() {
        System.out.println("Hexagon");
        System.out.println("Points:");
        for (int i = 0; i < n; i++) {
            System.out.println(points[i].x + "," + points[i].y);
        }
    }

    @Override
    public float getArea() {
        float square = points[5].x * points[0].y;
        for (int i = 0; i < n-1; i++) {
            square += points[i].x * points[i+1].y;
        }
        return square;
    }

    @Override
    public Point getCenter() {
        float xSum = 0;
        float ySum = 0;
        for (int i = 0; i < n; i++) {
            xSum += points[i].x;
            ySum += points[i].y;
        }

        return new Point(xSum / 6, ySum / 6);
    }
}
