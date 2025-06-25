package org.example.view;

import javax.swing.*;
import java.awt.*;

public class CadastroPageEmissor {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton cadastrarButton;

    public CadastroPageEmissor() {
        JFrame frame = new JFrame("Cadastro de Emissor");
        frame.setPreferredSize(new Dimension(300,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}
