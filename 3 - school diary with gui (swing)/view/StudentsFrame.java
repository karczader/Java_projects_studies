package view;

import logic.ClassContainer;

import javax.swing.table.AbstractTableModel;

public class StudentsFrame extends AbstractTableModel {

    private ClassContainer studentTable;
    private String className;

    public StudentsFrame(ClassContainer studentTable, String className) {
        this.studentTable = studentTable;
        this.className = className;
    }

    public StudentsFrame(ClassContainer c) {
        this.studentTable = c;
    }

    @Override
    public int getRowCount() {
        return studentTable.getClassByKey(className).numberOfStudents();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columnIndex == 0 ? studentTable.getClassByKey(className).getStudents().get(rowIndex).getName() :
                columnIndex == 1 ? studentTable.getClassByKey(className).getStudents().get(rowIndex).getSecondName() :
                        studentTable.getClassByKey(className).getStudents().get(rowIndex).getPoints();

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            studentTable.getClassByKey(className).getStudents().get(rowIndex).setName(aValue.toString());
        } else if (columnIndex == 1) {
            studentTable.getClassByKey(className).getStudents().get(rowIndex).setSecondName(aValue.toString());
        } else if (columnIndex == 2) {
            try {
                studentTable.getClassByKey(className).getStudents().get(rowIndex).setPoints(Double.parseDouble(aValue.toString()));
            } catch (Exception e) {
                System.out.println("Input Error");
            }
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

}
