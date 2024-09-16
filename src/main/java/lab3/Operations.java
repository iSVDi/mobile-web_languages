package lab3;
import lab3.shape.Point;
import lab3.shape.Shape;

import java.awt.geom.Line2D;

public class Operations {
    int compareAreas(Shape shape, Shape withShape) {
        var diffAreas =shape.getArea() - withShape.getArea();
        if (diffAreas > 0) {
            return 1;
        } else if (diffAreas < 0) {
            return -1;
        }
        return 0;
    }


    //TODO: implement?
//    boolean isInclude(Shape shape, Shape inShape) {
//        var inShapeCenter = inShape.getCenter();
//    }

    boolean isIntersect(Shape shape, Shape withShape) {
        var shapePoints = shape.getPoints();
        var withShapePoints = withShape.getPoints();

        for (int i = 0; i < shapePoints.length; i++) {
            var nextI = i+1 == shapePoints.length ? 0 : i+1;
            for (int j = 0; j < withShapePoints.length; j++) {
                var nextJ = j+1 == withShapePoints.length ? 0 : j+1;
                if (isLinesIntersect(shapePoints[i], shapePoints[nextI], withShapePoints[j], withShapePoints[nextJ])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isLinesIntersect(Point p1, Point p2, Point q1, Point q2) {
        return Line2D.linesIntersect(p1.x, p1.y, p2.x, p2.y, q1.x, q1.y, q2.x, q2.y);
    }

//    // Метод для проверки, находится ли точка внутри треугольника
//    private boolean isPointInTriangle(Point p1, Point p2, Point p3, Point point) {
//        // Площадь исходного треугольника
//        float originalArea = triangleArea(p1, p2, p3);
//
//        // Площади треугольников с точкой P
//        double area1 = triangleArea(point, p2, p3);
//        double area2 = triangleArea(p1, point, p3);
//        double area3 = triangleArea(p1, p2, point);
//
//        // Если сумма площадей равна исходной площади, точка внутри треугольника
//        return originalArea == area1 + area2 + area3;
//    }
//
//    private static float triangleArea(Point p1, Point p2, Point p3) {
//        return (float) Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0);
//    }



}
