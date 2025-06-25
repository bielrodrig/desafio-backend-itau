package org.example.view;

import javax.swing.*;
import java.awt.*;

public class LoginPage {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton entrarButton;
    private JFrame frame;
    public LoginPage() {
        frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
