package figures;

public class Circle {
    Point position;
    double radius;

    public Circle(double x, double y, double radius) {
        this.position = new Point(x, y);
        this.radius = radius;
    }

    public boolean intersects(Circle circle) {
        double distanceSquared = position.distanceSquaredToPoint(circle.position);
        return !(distanceSquared > (radius + circle.radius) * (radius + circle.radius)) &&
                !(radius * radius > (distanceSquared + circle.radius) * (distanceSquared + circle.radius)) &&
                !(circle.radius * circle.radius > (distanceSquared + radius) * (distanceSquared + radius));
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "position=" + position +
                ", radius=" + radius +
                '}';
    }
}
