import java.util.ArrayList;

public class Square extends Figure implements Printable {
    private double a;

    Square(double a) {
        if (a <= 0) throw new IllegalArgumentException("Sides must be bigger than 0");
        this.a = a;
    }

    void setData(ArrayList<Double> data) {
        if (a <= 0) throw new IllegalArgumentException("Sides must be bigger than 0");
        this.a = data.get(0);
    }

    @Override
    boolean isTriangle() {
        return false;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public void print() {
        System.out.println("SQUARE");
        System.out.println("Sides of a square: " + a);
        System.out.println("Perimeter of a square: " + calculatePerimeter());
        System.out.println("Area of a square: " + calculateArea());
        System.out.println();
    }
}
