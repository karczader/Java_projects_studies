package view;

import logic.Class;
import logic.ClassContainer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SchoolDiary extends JFrame {
    private String currentClass = "";
    private String currentStudent = "";
    private JTable studentsFrame;
    private JTable classesFrame;
    private JButton addStudentButton;
    private JButton deleteStudentButton;
    private JPanel mainPanel;
    private JLabel name;
    private JLabel secondName;
    private JButton sortStudentByNameButton;
    private JButton addClassButton;
    private JButton deleteClassButton;
    private JButton sortByClassnameButton;
    private JButton changeInfoAboutStudentButton;
    private JButton changeInfoAboutClassButton;
    private JTextField searchStudentName;


    public SchoolDiary(ClassContainer classContainer) {
        this.classesFrame.setModel(new ClassesFrame(classContainer));

        //studentsFrame.addPropertyChangeListener(evt -> System.out.println("Data changed"));

        //choose current class and student
        classesFrame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if (target.getSelectedRow() != -1) {
                    List<Class> tmp = new ArrayList<Class>(classContainer.getClasses().values());
                    currentClass = tmp.get(target.getSelectedRow()).getGroupName();
                    currentStudent = classContainer.getClassByKey(currentClass).getStudents().get(target.getSelectedRow()).getName();
                    studentsFrame.setModel(new StudentsFrame(classContainer, currentClass));
                }
            }
        });

        //delete student or class
        deleteStudentButton.addActionListener(e -> {
            if (currentStudent.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose student", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                classContainer.getClassByKey(currentClass).removeStudent(currentStudent);
                currentStudent = "";
                studentsFrame.updateUI();
            }
        });

        deleteClassButton.addActionListener(e -> {
            if (currentClass.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose class!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                if (classContainer.getClasses().size() == 1) {
                    classesFrame.setModel(new AbstractTableModel() {
                        @Override
                        public int getRowCount() {
                            return 0;
                        }

                        @Override
                        public int getColumnCount() {
                            return 0;
                        }

                        @Override
                        public Object getValueAt(int rowIndex, int columnIndex) {
                            return null;
                        }
                    });

                }
                classContainer.removeClass(currentClass);
                currentClass = "";
                currentStudent = "";

                studentsFrame.setModel(new AbstractTableModel() {
                    @Override
                    public int getRowCount() {
                        return 0;
                    }

                    @Override
                    public int getColumnCount() {
                        return 0;
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return null;
                    }
                });
                if (classContainer.getClasses().size() != 0) {
                    classesFrame.updateUI();
                }

            }
        });

        //change info about student or class
        changeInfoAboutStudentButton.addActionListener(e -> {
            if (currentStudent.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose student", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                //change student
                //it doest nothing so far
                new ChangeInfoStudent().setVisible(true);
            }
        });
        changeInfoAboutClassButton.addActionListener(e -> {
            if (currentClass.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose class", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                new ChangeInfoClass(classContainer, currentClass, classesFrame).setVisible(true);
            }
        });

        //add new student or class
        addStudentButton.addActionListener(e -> {
            if (currentClass.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose class", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                new AddStudent(classContainer, currentClass, studentsFrame, classesFrame).setVisible(true);
            }
        });
        addClassButton.addActionListener(e -> new AddClasses(classContainer, classesFrame).setVisible(true));

        //sort by classname
        sortByClassnameButton.addActionListener(e -> {
            classContainer.sortByClassname();
            classesFrame.updateUI();
        });

        //sort by student name
        sortStudentByNameButton.addActionListener(e -> {
            if (classContainer.getKeySet().size() > 0 && classesFrame.getSelectedRow() != -1) {
                classContainer.getClasses().get(currentClass).sortByName();
                studentsFrame.updateUI();
            }
        });

        //search partial
        //error.........
        searchStudentName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (classContainer.getKeySet().size() > 0 && classesFrame.getSelectedRow() != -1) {
                    Class cl = classContainer.getClasses().get(currentClass);
                    StudentsFrame newStudentFrame = new StudentsFrame(classContainer, currentClass);
                    newStudentFrame.setClass(cl.searchPartialAndReturnClass(searchStudentName.getText()));
                    studentsFrame.setModel(newStudentFrame);
                    studentsFrame.updateUI();
                }
                super.keyReleased(e);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
