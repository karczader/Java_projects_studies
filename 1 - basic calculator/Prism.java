public class Prism implements Printable {
    private Figure base;
    private double h;

    Prism(Figure base, double h) {
        if (h <= 0) throw new IllegalArgumentException("Height must be bigger than 0");
        this.base = base;
        this.h = h;
    }

    public double calculateArea() { //powierzchnia
        return base.calculatePerimeter() * h;
    }

    public double calculateVolume() { //objetosc
        return base.calculateArea() * h;
    }

    @Override
    public void print() {
        System.out.println("PRISM");
        System.out.println("Height: " + h);
        System.out.println("Base area: " + base.calculateArea());
        System.out.println("Area: " + calculateArea());
        System.out.println("Volume: " + calculateVolume());
        System.out.println();
    }
}
