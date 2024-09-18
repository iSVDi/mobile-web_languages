package lab3.shape;

import java.util.List;
import java.util.Scanner;

public abstract class Shape {
    List<Point> points;
    char id;
    int n;
    public Scanner in = new Scanner(System.in);
    public abstract void info();

    public abstract float getArea();

    public List<Point> getPoints() {
        return points;
    }

    public abstract Point getCenter();

    public int getN() {
        return n;
    }

    protected void printPoints() {
        System.out.println("Points:");
        points.forEach(point -> System.out.println(point.x + "," + point.y));
    }

    public void move(MoveDirectional direct, float distance) {
        switch (direct) {
            case UP -> {
                points.forEach(point -> {point.y += distance;});
            }
            case RIGHT -> {
                points.forEach(point -> {point.x += distance;});
            }
            case DOWN -> {
                points.forEach(point -> {point.y -= distance;});
            }
            case LEFT -> {
                points.forEach(point -> {point.x -= distance;});

            }
        }
    }

    public void rotate() {
        Point center = getCenter();
        points = points.stream().map(point -> rotatePoint90DegClockwiseAroundCenter(point, center)).toList();
    }
    private Point rotatePoint90DegClockwiseAroundCenter(Point point, Point center) {
        // Переносим точку в начало координат относительно центра
        float xShifted = point.x - center.x;
        float yShifted = point.y - center.y;

        // Применяем матрицу поворота на 90 градусов
        float xNew = -yShifted;  // x' = -y
        float yNew = xShifted;   // y' = x

        // Возвращаем точку обратно к центру
        return new Point(xNew + center.x, yNew + center.y);
    }
}

