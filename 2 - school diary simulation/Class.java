import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Class {
    private String groupName;
    private List<Student> listOfStudent;
    private int maxNumberOfStudent;

    public Class(String groupName, List<Student> listOfStudent, Integer maxNumberOfStudent) {
        this.groupName = groupName;
        this.listOfStudent = listOfStudent;
        this.maxNumberOfStudent = maxNumberOfStudent;
    }

    public List<Student> getListOfStudent() {
        return this.listOfStudent;
    }

    public String getGroupName() {
        return groupName;
    }

    public void addStudent(Student student) {
        if (listOfStudent.size() + 1 < maxNumberOfStudent) {
            if (listOfStudent.stream().filter(student1 -> student.getName().equals(student1.getName())).findAny().orElse(null) != null) {
                System.out.println("Student with that name exists already");
            } else {
                listOfStudent.add(student);
            }
        } else {
            System.err.println("In group is too many students");
        }
    }

    public void addPoints(Student student, double points) {
        for (Student oneStudent : listOfStudent) {
            if (oneStudent.equals(student)) {
                student.setPoints(student.getPoints() + points);
            }
        }
    }

    public void getStudent(Student student) {
        if (student.getPoints() == 0) {
            listOfStudent.remove(student);
        }
    }

    public void changeCondition(Student student, StudentCondition studentState) {
        for (Student oneStudent : listOfStudent) {
            if (oneStudent.equals(student)) {
                oneStudent.setStudentState(studentState);
            }
        }
    }

    public void removePoints(Student student, Double points) {
        for (Student oneStudent : listOfStudent) {
            if (oneStudent.equals(student)) {
                oneStudent.setPoints(oneStudent.getPoints() - points);
            }
        }
    }

    public Student search(String secondName) {
        for (Student student : listOfStudent) {
            if (student.getSecondName().compareTo(secondName) == 0) {
                return student;
            }
        }
        return null;
    }

    public List<Student> searchPartial(String word) {
        List<Student> allowList = new ArrayList();
        for (Student student : listOfStudent) {
            if (student.getSecondName().contains(word)) {
                allowList.add(student);
            }
        }
        return allowList;
    }

    public int countByCondition(StudentCondition state) {
        int counter = 0;
        for (Student student : listOfStudent) {
            if (student.getStudentCondition().equals(state)) {
                counter++;
            }
        }
        return counter ;
    }

    public void summary() {
        System.out.println("\n* * * CLASS * * *");
        for (Student student : listOfStudent) {
            student.print();
        }
    }

    public void sortByName() {
        Collections.sort(listOfStudent);
        for (Student student : listOfStudent) {
            System.out.println(student);
        }
    }

    public void sortByPoints() {
        listOfStudent.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return -1 * Double.compare(student1.getPoints(), student2.getPoints());
            }
        });
    }
}

