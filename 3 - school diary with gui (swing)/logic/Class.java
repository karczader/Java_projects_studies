package logic;

import java.util.*;
import java.util.stream.Collectors;

public class Class {
    private String groupName;
    private int maxNumberOfStudents;
    private List<Student> students = new ArrayList<Student>();


    public Class(final String groupName, final int maxNumberOfStudents) {
        this.groupName = groupName;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumber) {
        this.maxNumberOfStudents = maxNumber;
    }


    public List<Student> getStudents() {
        return students;
    }

    private boolean isStudentInGroup(final Student student) {
        return students.stream().filter(student1 -> student.getName().equals(student1.getName())).findAny().orElse(null) != null;
    }

    public void addStudent(final Student student) {
        if (students.size() + 1 < maxNumberOfStudents) {
            if (isStudentInGroup(student)) {
                System.err.println("The same student is added already");
            } else {
                students.add(student);
            }
        } else {
            System.err.println("Exceeded the number of student");
        }
    }

    public void editStudent(final Student student) {

    }

    public void addPoints(final Student student, final double points) {
        if (isStudentInGroup(student)) {
            student.setPoints(student.getPoints() + points);
        } else {
            System.err.println("Student doesn't belong to this group");
        }
    }

    public void removePoints(final Student student, final double points) {
        if (isStudentInGroup(student)) {
            student.setPoints(student.getPoints() - points > 0 ? student.getPoints() - points : 0);
        } else {
            System.err.println("Student doesn't belong to this group");
        }
    }

    public Student search(final String secondName) {
        return students.stream().filter(student -> student.getSecondName().compareTo(secondName) == 0).findFirst().orElse(null);
    }

    public List<Student> searchPartial(final String secondName) {
        return students.stream().filter(student -> student.getSecondName().contains(secondName)).collect(Collectors.toList());
    }

    Comparator<Student> compareByPoints = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getPoints() > o2.getPoints()) {
                return 1;
            } else if (o1.getPoints() < o2.getPoints()) {
                return -1;
            } else
                return 0;
        }
    };

    public List<Student> sortByName() {
        List<Student> studentsToReturn = students;
        Collections.sort(studentsToReturn, Student::compareTo);
        return studentsToReturn;
    }

    public List<Student> sortByPoints() {
        List<Student> studentsToReturn = students;
        Collections.sort(studentsToReturn, compareByPoints.reversed());
        return studentsToReturn;
    }

    public Student maxPoints() {
        Student studentToReturn;
        studentToReturn = Collections.max(students, compareByPoints);
        return studentToReturn;
    }

    public int countByCondition(final StudentCondition studentCondition) {
        return students.stream().filter(student -> student.getStudentStatus() == studentCondition).collect(Collectors.toList()).size();
    }

    public void getStudent(final Student student) {
        if (student.getPoints() == 0) {
            students.remove(student);
        }
    }

    public void removeStudent(final String student) {
        students = students.stream().filter(e -> !e.getName().equals(student)).collect(Collectors.toList());
    }

    public void changeCondition(final Student student, final StudentCondition condition) {
        student.setStudentStatus(condition);
    }

    public void summary() {
        students.forEach(Student::printStudent);
    }

    public int numberOfStudents() {
        return getStudents().size();
    }

}
