public class BasicFigureGenerator {

    public static void printBasicFigure() {
        Triangle triangle = new Triangle(3, 4, 5);
        triangle.print();

        Square square = new Square(5);
        square.print();

        Circle circle = new Circle(3);
        circle.print();

        Prism prism = new Prism(triangle, 3);
        prism.print();
    }
}
