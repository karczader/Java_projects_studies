package view;

import logic.ClassContainer;

import javax.swing.*;

public class AddClasses extends JFrame {
    private JPanel addGroup;
    private JTextField groupName;
    private JTextField quantity;
    private JButton addGroupButton;

    public AddClasses(ClassContainer studentClass, JTable tableToUpdate) {
        this.add(addGroup);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addGroupButton.addActionListener((e) -> {
            try {
                studentClass.addClass(groupName.getText(), Integer.parseInt(quantity.getText()));
                this.setVisible(false);
                tableToUpdate.updateUI();
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "You can't enter a empty data!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
