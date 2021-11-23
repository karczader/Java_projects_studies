package logic;

public class Student implements Comparable<Student> {
    private String name;
    private String secondName;
    private StudentCondition studentStatus;
    private double points = 0;
    private int index;

    public Student(String name, String secondName, StudentCondition studentStatus, int points, int index) {
        this.name = name;
        this.secondName = secondName;
        this.studentStatus = studentStatus;
        this.points = points;
        this.index = index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setStudentStatus(StudentCondition studentStatus) {
        this.studentStatus = studentStatus;
    }


    public StudentCondition getStudentStatus() {
        return studentStatus;
    }

    public void printStudent() {
        System.out.println("Name: " + name + "\nSecond name:" + secondName + "\nCondition: " +
                studentStatus + "\nPoints" + points + "\nIndex: " + index);
    }

    @Override
    public int compareTo(Student o) {
        return secondName.compareTo(o.secondName);

    }


}
