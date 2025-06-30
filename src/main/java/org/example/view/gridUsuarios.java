package org.example.view;

import javax.swing.*;
import java.awt.*;


public class gridUsuarios {

    private JButton emissorButton;
    private JButton receptorButton;
    private JPanel panel1;

    public gridUsuarios() {
        JFrame frame = new JFrame("Escoha de Usuarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(panel1);
        frame.pack();

        emissorButton.addActionListener(e -> new LoginPageEmissor());

    }
}
