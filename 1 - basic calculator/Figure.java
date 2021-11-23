import java.util.ArrayList;

public abstract class Figure implements Printable {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    abstract void setData(ArrayList<Double> data);
    abstract boolean isTriangle();
}
