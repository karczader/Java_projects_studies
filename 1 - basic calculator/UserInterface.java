import java.util.ArrayList;

public class UserInterface {

    public static void generateUserInterface() {
        Figure myFigure = null;
        while (true) {
            System.out.println("__________________");
            System.out.println("Choose what do you want:\na -> choose figure\nb -> press data\nc -> show figure\nd -> exit program");
            String myChoice = EnterData.enterStringValue();
            switch (myChoice) {
                case "a":
                    myFigure = chooseFigure();
                    break;
                case "b":
                    if (myFigure != null) {
                        setData(myFigure);
                    } else {
                        myFigure = chooseFigure();
                    }
                    break;
                case "c":
                    if (myFigure != null) {
                        myFigure.print();
                    } else {
                        System.out.println("Figure is null");
                    }
                    break;
                case "d":
                    System.out.println("bye");
                    return;
                default:
                    System.out.println("Wrong value!");
                    break;
            }
        }
    }

    private static Figure chooseFigure() {
        System.out.println("Choose figure:\na->triangle\nb->square\nc->circle");
        String myChoice = EnterData.enterStringValue();
        Figure myFigure = null;
        while (myFigure == null) {
            switch (myChoice) {
                case "a":
                    double a = EnterData.enterDoubleValue();
                    double b = EnterData.enterDoubleValue();
                    double c = EnterData.enterDoubleValue();
                    myFigure = new Triangle(a, b, c);
                    break;
                case "b":
                    double x = EnterData.enterDoubleValue();
                    myFigure = new Square(x);
                    break;
                case "c":
                    double r = EnterData.enterDoubleValue();
                    myFigure = new Circle(r);
                    break;
                default:
                    System.out.println("Wrong value!");
                    break;
            }
        }
        return myFigure;
    }

    private static void setData(Figure figure) {
        double a = EnterData.enterDoubleValue();
        ArrayList<Double> data = new ArrayList<>();
        data.add(a);
        if (figure.isTriangle()) {
            double b = EnterData.enterDoubleValue();
            double c = EnterData.enterDoubleValue();
            data.add(b);
            data.add(c);
        }
        figure.setData(data);
    }
}
