package org.example.view;

import javax.swing.*;
import java.awt.*;

public class tiposTransferencias {
    private JButton PIXButton;
    private JPanel panel1;
    private JButton TEDButton;
    private JButton DOCButton;

    public tiposTransferencias() {
        JFrame frame = new JFrame("Tipos de Transferencias");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}



