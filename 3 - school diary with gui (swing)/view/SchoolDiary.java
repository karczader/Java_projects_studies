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
    private final ClassContainer studentClass;
    private String currentClass = "";
    private String currentStudent = "";
    private JTable StudentsTable;
    private JTable GroupsTable;
    private JButton addStudentStudent;
    private JButton deleteStudentButton;
    private JPanel mainPanel;
    private JLabel name;
    private JLabel secondName;
    private JButton sortByNameButton;
    private JButton addGroupButton;
    private JButton deleteGroupButton;
    private JButton sortByPointsButton;


    public SchoolDiary(ClassContainer classContainer) {
        this.studentClass = classContainer;
        this.GroupsTable.setModel(new ClassesFrame(classContainer));


        addStudentStudent.addActionListener(e -> {
            if (currentClass.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose class", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                new AddStudent(classContainer, currentClass, StudentsTable, GroupsTable).setVisible(true);

            }
        });

        addGroupButton.addActionListener(e -> new AddClasses(classContainer, GroupsTable).setVisible(true));
        StudentsTable.addPropertyChangeListener(evt -> System.out.println("Data changed"));


        StudentsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if (target.getSelectedRow() != -1) {
                    currentStudent = classContainer.getClassByKey(currentClass).getStudents().get(target.getSelectedRow()).getName();
                }
            }
        });

        GroupsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if (target.getSelectedRow() != -1) {
                    List<Class> tmp = new ArrayList<Class>(classContainer.getClasses().values());
                    currentClass = tmp.get(target.getSelectedRow()).getGroupName();
                    StudentsTable.setModel(new StudentsFrame(classContainer, currentClass));
                }
            }
        });


        deleteStudentButton.addActionListener(e -> {
            if (currentStudent.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose student", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                classContainer.getClassByKey(currentClass).removeStudent(currentStudent);
                currentStudent = "";
                StudentsTable.updateUI();
            }
        });

        deleteGroupButton.addActionListener(e -> {
            if (currentClass.equals("")) {
                JOptionPane.showMessageDialog(null, "You must choose class!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                if (classContainer.getClasses().size() == 1) {
                    GroupsTable.setModel(new AbstractTableModel() {
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

                StudentsTable.setModel(new AbstractTableModel() {
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
                    GroupsTable.updateUI();
                }

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
