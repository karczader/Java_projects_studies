package view;

import logic.Class;
import logic.ClassContainer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClassesFrame extends AbstractTableModel {

    private final ClassContainer classTable;

    public ClassesFrame(ClassContainer classTable) {
        this.classTable = classTable;
    }

    @Override
    public int getRowCount() {
        return classTable.getClasses().size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Class> tmp = new ArrayList<Class>(classTable.getClasses().values());
        return columnIndex == 0 ? tmp.get(rowIndex).getGroupName() :
                tmp.get(rowIndex).getStudents().size();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        List<Class> tmp = new ArrayList<Class>(classTable.getClasses().values());
        if (columnIndex == 0) {
            tmp.get(rowIndex).setGroupName(aValue.toString());
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }
}
