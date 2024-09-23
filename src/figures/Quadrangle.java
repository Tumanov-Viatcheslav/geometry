package figures;

import java.util.Arrays;

public class Quadrangle extends Figure {
    private Point[] points = new Point[4];

    public Quadrangle(Point p1, Point p2, Point p3, Point p4) {
        this.points[0] = p1;
        this.points[1] = p2;
        this.points[2] = p3;
        this.points[3] = p4;
    }

    public Quadrangle(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double p4X, double p4Y) {
        this.points[0] = new Point(p1X, p1Y);
        this.points[1] = new Point(p2X, p2Y);
        this.points[2] = new Point(p3X, p3Y);
        this.points[3] = new Point(p4X, p4Y);
    }

    public Quadrangle(Point[] points) {
        this.points = points;
    }

    public boolean isRectangle() {
        if (!(new Triangle(points[0], points[1], points[2]).isRight()))
            return false;
        if (!(new Triangle(points[1], points[2], points[3]).isRight()))
            return false;
        if (!(new Triangle(points[3], points[0], points[1]).isRight()))
            return false;
        return (new Triangle(points[2], points[3], points[0]).isRight());
    }

    @Override
    public double perimeter() {
        return points[0].distanceToPoint(points[1]) + points[1].distanceToPoint(points[2]) + points[2].distanceToPoint(points[3]) + points[3].distanceToPoint(points[0]);
    }

    //Only for convex quadrangle
    @Override
    public double area() {
        return new Triangle(points[0], points[1], points[2]).area() + new Triangle(points[2], points[3], points[0]).area();
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
