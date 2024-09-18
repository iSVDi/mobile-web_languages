package lab3;
import lab3.shape.Point;
import lab3.shape.Shape;
import java.awt.geom.Line2D;

public class Operations {
    public int compareAreas(Shape shape, Shape withShape) {
        var diffAreas = shape.getArea() - withShape.getArea();
        if (diffAreas > 0) {
            return 1;
        } else if (diffAreas < 0) {
            return -1;
        }
        return 0;
    }

    public boolean isIntersect(Shape shape, Shape withShape) {
        var shapePoints = shape.getPoints();
        var withShapePoints = withShape.getPoints();

        for (int i = 0; i < shape.getN(); i++) {
            var nextI = (i+1) % shape.getN();
            for (int j = 0; j < withShape.getN(); j++) {
                var nextJ = (j+1) % withShape.getN();
                if (isLinesIntersect(shapePoints.get(i), shapePoints.get(nextI), withShapePoints.get(j), withShapePoints.get(nextJ))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Метод для проверки, находится ли один многоугольник внутри другого
    public boolean isInclude(Shape innerPolygon, Shape outerShape) {

        // Проверяем, находятся ли все вершины внутреннего многоугольника внутри внешнего
        for (Point point: innerPolygon.getPoints()) {
            if (!isPointInsidePolygon(outerShape, point)) {
                return false;
            }
        }

        // Проверяем, не пересекаются ли стороны многоугольников
        if (isIntersect(innerPolygon, outerShape)) {
            return false;
        }

        return true;
    }

    // Метод для проверки, находится ли точка внутри многоугольника (алгоритм Ray-Casting)
    boolean isPointInsidePolygon(Shape shape, Point checkedPoint) {
        int intersectCount = 0;
        var shapePoinst = shape.getPoints();

        for (int i = 0; i < shape.getN(); i++) {
            Point vertex1 = shapePoinst.get(i);
            Point vertex2 = shapePoinst.get((i + 1) % shape.getN());

            // Проверяем, пересекает ли луч от точки линию многоугольника
            if (isLinesIntersect(
                    checkedPoint,
                    new Point(Float.MAX_VALUE, checkedPoint.y),
                    vertex1,
                    vertex2)) {
                intersectCount++;
            }
        }

        // Если количество пересечений нечётное, точка внутри многоугольника
        return (intersectCount % 2) == 1;
    }

    private boolean isLinesIntersect(Point p1, Point p2, Point q1, Point q2) {
        return Line2D.linesIntersect(p1.x, p1.y, p2.x, p2.y, q1.x, q1.y, q2.x, q2.y);
    }

}
