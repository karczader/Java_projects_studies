package view;

import javax.swing.*;
import java.awt.event.*;

public class ChangeInfoStudent extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel ChangeInfoAboutStudent;
    private JTextField nameField;
    private JTextField secondNameField;
    private JTextField conditionField;
    private JTextField PointsField;
    private JTextField IndexField;

    ChangeInfoStudent(){
        this.add(contentPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
