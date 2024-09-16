package lab3.shape;

import java.util.Scanner;

public abstract class Shape {
    Point[] points;
    char id;
    int n;
    public Scanner in = new Scanner(System.in);
    public abstract void info();

    public abstract float getArea();

    public Point[] getPoints() {
        return points;
    }

    public abstract Point getCenter();

    public int getN() {
        return n;
    }

    public void move(MoveDirectional direct, float distance) {
        switch (direct) {

            case UP -> {
                for (int i = 0; i < n; i++) {
                    points[i].y += distance;
                }
            }
            case RIGHT -> {
                for (int i = 0; i < n; i++) {
                    points[i].x += distance;
                }
            }
            case DOWN -> {
                for (int i = 0; i < n; i++) {
                    points[i].y -= distance;
                }
            }
            case LEFT -> {
                for (int i = 0; i < n; i++) {
                    points[i].x -= distance;
                }
            }
        }
    }


    public void rotate() {

        Point center = getCenter();
        for (int i = 0; i < n; i++) {
            points[i] = rotatePoint90DegAroundCenter(points[i], center);
        }

    }

    private Point rotatePoint90DegAroundCenter(Point point, Point center) {
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

