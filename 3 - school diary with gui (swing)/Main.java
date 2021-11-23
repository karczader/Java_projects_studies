import logic.ClassContainer;
import logic.Student;
import logic.StudentCondition;
import view.SchoolDiary;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClassContainer container = new ClassContainer();
        Student student1 = new Student("Alice", "Newton", StudentCondition.ABSENT, 50, 234567);
        Student student2 = new Student("Caroline", "Holland", StudentCondition.SICK, 60, 7553247);
        Student student3 = new Student("Tom", "O'Brien", StudentCondition.SICK, 100, 986443);
        Student student4 = new Student("Jan", "Nowak", StudentCondition.PRESENT, 10, 3468764);
        Student student5 = new Student("Zosia", "Nowak", StudentCondition.PRESENT, 80, 2334566);
        container.addClass("ClassA", 5);
        container.addClass("ClassB", 5);
        container.getClassByKey("ClassA").addStudent(student1);
        container.getClassByKey("ClassA").addStudent(student2);
        container.getClassByKey("ClassA").addStudent(student3);
        container.getClassByKey("ClassB").addStudent(student4);
        container.getClassByKey("ClassB").addStudent(student5);

        JFrame schoolDiary = new JFrame("School Diary");
        schoolDiary.setContentPane(new SchoolDiary(container).getMainPanel());
        schoolDiary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        schoolDiary.pack();
        schoolDiary.setVisible(true);
    }
}
