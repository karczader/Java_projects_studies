import java.util.ArrayList;

public class Circle extends Figure implements Printable {
    private double r;

    Circle(double r) {
        if (r <= 0) throw new IllegalArgumentException("Radius must be >0");
        this.r = r;
    }

    void setData(ArrayList<Double> data) {
        if (r <= 0) throw new IllegalArgumentException("Radius must be >0");
        this.r = data.get(0);
    }

    @Override
    boolean isTriangle() {
        return false;
    }

    @Override
    public double calculateArea() {
        return Math.PI * r * r;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public void print() {
        System.out.println("CIRCLE");
        System.out.println("Radius of the circle: " + r);
        System.out.println("Perimeter of a circle: " + calculatePerimeter());
        System.out.println("Area of a circle: " + calculateArea());
        System.out.println();
    }
}
