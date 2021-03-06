package view;

import javax.swing.*;
import logic.Class;
import logic.ClassContainer;


public class ChangeInfoClass extends JDialog {
    private JPanel changeClass;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField classnameField;
    private JTextField maxNumberField;

    ChangeInfoClass(ClassContainer classContainer, String className, JTable classesFrame) {
        Class editClassname = classContainer.getClassByKey(className);
        String oldClassname = editClassname.getGroupName();
        this.add(changeClass);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        classnameField.setText(editClassname.getGroupName());
        maxNumberField.setText(String.valueOf(editClassname.getMaxNumberOfStudents()));

        buttonOK.addActionListener((e) -> {
            try {
                classContainer.editClassname(oldClassname, classnameField.getText(), Integer.parseInt(maxNumberField.getText()));
                this.setVisible(false);
                classesFrame.updateUI();
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Wrong data!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
