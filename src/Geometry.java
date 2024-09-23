import figures.Circle;
import figures.Figure;
import figures.Quadrangle;
import figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Circle c = new Circle(2, 0, 1);
        System.out.println(c + "\nperimeter=" + c.perimeter() + " area=" + c.area());
        Triangle tr1 = new Triangle(0, 0, 3, 0, 0, 4);
        System.out.println(tr1 + "\nisRight=" + tr1.isRight() + " isIsosceles=" + tr1.isIsosceles() + " isEquilateral=" + tr1.isEquilateral() +
                            "\nperimeter=" + tr1.perimeter() + " area=" + tr1.area());
        Quadrangle quad = new Quadrangle(0,0,1,0,1,1,0,1);
        System.out.println(quad + "\nisRectangle=" + quad.isRectangle() +
                            "\nperimeter=" + quad.perimeter() + " area=" + quad.area());
        Figure[] figs = {c, tr1, quad};
        double sum = 0;
        for (Figure fig: figs) {
            sum += fig.area();
        }
        System.out.println("total_area=" + sum);
    }
}