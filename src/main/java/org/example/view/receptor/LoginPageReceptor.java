package org.example.view.receptor;

import javax.swing.*;
import java.awt.*;

public class LoginPageReceptor {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton entrarButton;
    private JLabel textCadastro;
    private JPanel panel1;

    public LoginPageReceptor() {
        JFrame frame = new JFrame("Login Page Receptor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
