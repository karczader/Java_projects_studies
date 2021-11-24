package view;

import logic.ClassContainer;
import logic.Student;
import logic.StudentCondition;

import javax.swing.*;

public class AddStudent extends JFrame {

    private JPanel newStudent;
    private JTextField secondName;
    private JTextField name;
    private JButton addStudentButton;
    private JTextField index;

    AddStudent(ClassContainer studentClass, String currentClass, JTable tableToUpdate1, JTable tableToUpdate2) {
        this.add(newStudent);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addStudentButton.addActionListener((e) -> {
            try {
                studentClass.getClassByKey(currentClass).addStudent(new Student(name.getText(), secondName.getText(),
                        StudentCondition.PRESENT, 0, Integer.parseInt(index.getText())));
                this.setVisible(false);
                tableToUpdate1.updateUI();
                tableToUpdate2.updateUI();

            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Wrong data!", "Error",
                        JOptionPane.ERROR_MESSAGE);

            }

        });
    }


}
