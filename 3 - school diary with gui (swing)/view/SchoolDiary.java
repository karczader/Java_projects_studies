package view;

import logic.Class;
import logic.ClassContainer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
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
    private JButton sortByNameButton;
    private JButton addClassButton;
    private JButton deleteClassButton;
    private JButton sortByPointsButton;
    private JButton changeInfoAboutStudentButton;
    private JButton changeInfoAboutClassButton;


    public SchoolDiary(ClassContainer classContainer) {
        this.classesFrame.setModel(new ClassesFrame(classContainer));

        //studentsFrame.addPropertyChangeListener(evt -> System.out.println("Data changed"));

        //choose current student
        studentsFrame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if (target.getSelectedRow() != -1) {
                    currentStudent = classContainer.getClassByKey(currentClass).getStudents().get(target.getSelectedRow()).getName();
                }
            }
        });

        //choose current class
        classesFrame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if (target.getSelectedRow() != -1) {
                    List<Class> tmp = new ArrayList<Class>(classContainer.getClasses().values());
                    currentClass = tmp.get(target.getSelectedRow()).getGroupName();
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
        changeInfoAboutStudentButton.addActionListener(e-> {
            if (currentStudent.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose student", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                //it doest nothing so far
                new ChangeInfoStudent().setVisible(true);
            }
        });
        changeInfoAboutClassButton.addActionListener(e-> {
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
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
