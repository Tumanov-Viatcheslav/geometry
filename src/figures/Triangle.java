package figures;

import java.util.Arrays;

public class Triangle {
    private Point[] points = new Point[3];

    public Triangle(Point p1, Point p2, Point p3) {
        this.points[0] = p1;
        this.points[1] = p2;
        this.points[2] = p3;
    }

    public Triangle(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y) {
        this.points[0] = new Point(p1X, p1Y);
        this.points[1] = new Point(p2X, p2Y);
        this.points[2] = new Point(p3X, p3Y);
    }

    public Triangle(Point[] points) {
        this.points = points;
    }

    public boolean isRight() {
        double sideSquared1 = points[0].distanceSquaredToPoint(points[1]),
                sideSquared2 = points[1].distanceSquaredToPoint(points[2]),
                sideSquared3 = points[2].distanceSquaredToPoint(points[0]),
                eps = 0.00001;

        if (sideSquared1 > sideSquared2 && sideSquared1 > sideSquared3)
            return Math.abs(sideSquared1 - sideSquared2 - sideSquared3) < eps;
        if (sideSquared2 > sideSquared1 && sideSquared2 > sideSquared3)
            return Math.abs(sideSquared2 - sideSquared1 - sideSquared3) < eps;
        if (sideSquared3 > sideSquared1 && sideSquared3 > sideSquared2)
            return Math.abs(sideSquared3 - sideSquared1 - sideSquared2) < eps;
        return false;
    }

    public boolean isIsosceles() {
        double side1 = points[0].distanceToPoint(points[1]),
                side2 = points[1].distanceToPoint(points[2]),
                side3 = points[2].distanceToPoint(points[0]);
        if (side1 == side2)
            return true;
        if (side2 == side3)
            return true;
        return side3 == side1;
    }

    public boolean isEquilateral() {
        double side1 = points[0].distanceToPoint(points[1]),
                side2 = points[1].distanceToPoint(points[2]),
                side3 = points[2].distanceToPoint(points[0]);
        return side1 == side2 && side1 == side3;
    }

    public double perimeter() {
        return points[0].distanceToPoint(points[1]) + points[1].distanceToPoint(points[2]) +points[2].distanceToPoint(points[0]);
    }

    public double area() {
        double side1 = points[0].distanceToPoint(points[1]),
                side2 = points[1].distanceToPoint(points[2]),
                side3 = points[2].distanceToPoint(points[0]),
                semiper = perimeter() / 2;
        return Math.sqrt(semiper * (semiper - side1) * (semiper - side2) * (semiper - side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
