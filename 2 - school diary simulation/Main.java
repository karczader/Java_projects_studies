import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Jan", "Nowak", StudentCondition.PRESENT, 2000, 50.0);
        Student student2 = new Student("Zosia", "Nowak", StudentCondition.PRESENT, 1998, 100.0);
        student1.print();
        student2.print();
        if (student1.compareTo(student2) == 0) {
            System.out.println("\nStudents have the same name");
        } else {
            System.out.println("\nStudents do not have the same name ");
        }

        List<Student> students = new ArrayList<>();
        students.add(student1);
        Class class1 = new Class("Class A", students, 5);
        class1.addStudent(student1); //dodawie studenta o tym samym imieniu
        class1.addStudent(student2); //dodawanie innego studenta
        class1.changeCondition(student1, StudentCondition.ABSENT);
        class1.sortByPoints();
        class1.removePoints(student1, 10.0);
        System.out.println("Number of absent students: "+class1.countByCondition(StudentCondition.ABSENT));
        class1.summary();

        ClassContainer hashMap = new ClassContainer();
        hashMap.groups.put("Class A", class1);
        hashMap.addClass("Class B", 10);

        List<Class> emptyClasses = hashMap.findEmpty();
        System.out.println("\nEmpty class: ");
        for (Class emptyClass : emptyClasses) {
            System.out.println(emptyClass.getGroupName());
        }
    }

}
