package view;

import logic.ClassContainer;
import logic.Class;

import javax.swing.table.AbstractTableModel;

public class StudentsFrame extends AbstractTableModel {

    private final ClassContainer classContainer;
    private String className;
    private Class tempClass;

    public StudentsFrame(ClassContainer classContainer, String className) {
        this.classContainer = classContainer;
        this.className = className;
        this.tempClass =  classContainer.getClassByKey(className);
    }

    public StudentsFrame(ClassContainer c) {
        this.classContainer = c;
    }

    @Override
    public int getRowCount() {
        return classContainer.getClassByKey(className).numberOfStudents();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columnIndex == 0 ? tempClass.getStudents().get(rowIndex).getName() :
                columnIndex == 1 ? tempClass.getStudents().get(rowIndex).getSecondName() :
                        tempClass.getStudents().get(rowIndex).getPoints();

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            tempClass.getStudents().get(rowIndex).setName(aValue.toString());
        } else if (columnIndex == 1) {
            tempClass.getStudents().get(rowIndex).setSecondName(aValue.toString());
        } else if (columnIndex == 2) {
            try {
                tempClass.getStudents().get(rowIndex).setPoints(Double.parseDouble(aValue.toString()));
            } catch (Exception e) {
                System.out.println("Input Error");
            }
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

    public void setClass(Class editClassname){
        this.tempClass = editClassname;
    }

}
