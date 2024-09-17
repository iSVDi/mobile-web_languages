package lab3;

import lab3.shape.FactoryShape;
import lab3.shape.MoveDirectional;
import lab3.shape.Point;
import lab3.shape.Shape;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab3 {

    public static void main(String[] args) {

        var operations = new Operations();
        var factory = new FactoryShape();

        ArrayList<Point> pPoints1 = new ArrayList<>(Arrays.asList(
                new Point(0, 0),
                new Point(1, 2),
                new Point(5, 2),
                new Point(4, 0)));

        ArrayList<Point> pPoints2 = new ArrayList<>(Arrays.asList(
                new Point(1, 0),
                new Point(1, 2),
                new Point(4, 2),
                new Point(4, 0)));

        ArrayList<Point> hPoints1 = new ArrayList<>(Arrays.asList(
                new Point(5, 0),
                new Point(2.5f, -4.33f),
                new Point(-2.5f, -4.33f),
                new Point(-5, 0),
                new Point(-2.5f, 4.33f),
                new Point(2.5f, 4.33f)));

        ArrayList<Point> hPoints2 = new ArrayList<>(Arrays.asList(
                new Point(4, 10),
                new Point(9, 7),
                new Point(11, 2),
                new Point(2, 2),
                new Point(1, 5),
                new Point(4, 7)));

        var p1 = factory.createShape('P', pPoints1);
        var p2 = factory.createShape('P', pPoints2);

        var h1 = factory.createShape('H', hPoints1);
        var h2 = factory.createShape('H', hPoints2);

        System.out.println("--------------------OPERATIONS ABOVE PARALLELOGRAM--------------------");

        System.out.println("Compare area result - " + operations.compareAreas(p1, p2));
        System.out.println("is intersect result - " + operations.isIntersect(p1, p2));
        System.out.println("is include result - " + operations.isInclude(p1, p2));

        System.out.println("--------------------OPERATIONS ABOVE HEXAGON--------------------");

        System.out.println("Compare area result - " + operations.compareAreas(h1, h2));
        System.out.println("is intersect result - " + operations.isIntersect(h1, h2));
        System.out.println("is include result - " + operations.isInclude(h1, h2));

        System.out.println("--------------------APPLY SHAPE METHODS FOR PARALLELOGRAM--------------------");
        applyShapeMethods(p1);
        System.out.println("--------------------APPLY SHAPE METHODS FOR HEXAGON--------------------");

        applyShapeMethods(h1);

    }

    static void applyShapeMethods(Shape shape) {
        System.out.println("Area = " + shape.getArea());
        System.out.println("Center = " + shape.getCenter().x + " , " + +shape.getCenter().y);

        System.out.println("Before move up");
        shape.info();
        shape.move(MoveDirectional.UP, 10);
        System.out.println("After move up");
        shape.info();

        shape.rotate();
        System.out.println("After shape rotate");
        shape.info();
    }

}
