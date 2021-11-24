package view;

import logic.ClassContainer;

import javax.swing.*;

public class AddClasses extends JFrame {
    private JPanel addGroup;
    private JTextField classname;
    private JTextField quantity;
    private JButton addClassButton;

    public AddClasses(ClassContainer studentClass, JTable tableToUpdate) {
        this.add(addGroup);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addClassButton.addActionListener((e) -> {
            try {
                studentClass.addClass(classname.getText(), Integer.parseInt(quantity.getText()));
                this.setVisible(false);
                tableToUpdate.updateUI();
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Wrong data!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
