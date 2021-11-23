import java.lang.Comparable;

public class Student implements Comparable<Student> {
    private String name;
    private String secondName;
    private StudentCondition studentState;
    private int dateOfBirth;
    private double points;

    public Student(String name, String secondName, StudentCondition studentState, Integer dateOfBirth, Double points) {
        this.name = name;
        this.secondName = secondName;
        this.studentState = studentState;
        this.dateOfBirth = dateOfBirth;
        this.points = points;
    }

    public String getName() {
        return this.name;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public StudentCondition getStudentCondition() {
        return this.studentState;
    }

    public void setStudentState(StudentCondition value) {
        this.studentState = value;
    }

    public int getDateOfBirth() {
        return this.dateOfBirth;
    }

    public double getPoints() {
        return this.points;
    }

    public void setPoints(double value) {
        this.points = value;
    }

    public void print() {
        System.out.println("\n*** STUDENT ***");
        System.out.println("Imie: " + this.name);
        System.out.println("Nazwisko:: " + this.secondName);
        System.out.println("Stan: " + this.studentState);
        System.out.println("Rok urodzenia: " + this.dateOfBirth);
        System.out.println("Ilosc punktow: " + this.points);
    }

    @Override
    public int compareTo(Student student) {
        int compare = this.secondName.compareTo(student.secondName);
        return compare;
    }

}
