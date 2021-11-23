import java.util.ArrayList;

public class Triangle extends Figure implements Printable {
    private double a;
    private double b;
    private double c;

    Triangle(double a, double b, double c) {
        if (a <= 0 && b <= 0 && c <= 0) throw new IllegalArgumentException("Sides must be bigger than 0");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    void setData(ArrayList<Double> data) {
        if (a <= 0 && b <= 0 && c <= 0) throw new IllegalArgumentException("Sides must be bigger than 0");
        this.a = data.get(0);
        this.b = data.get(1);
        this.c = data.get(2);
    }

    @Override
    public double calculateArea() {
        double perimeter = calculatePerimeter() / 2;
        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public void print() {
        System.out.println("TRIANGLE");
        System.out.println("Sides of a triangle: " + a + ", " + b + ", " + c);
        System.out.println("Perimeter of a triangle: " + calculatePerimeter());
        System.out.println("Area of a triangle: " + calculateArea());
        System.out.println();
    }

    public boolean isTriangle() {
        return true;
    }
}
