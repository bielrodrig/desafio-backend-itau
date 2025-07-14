package org.example.view.receptor;

import javax.swing.*;
import java.awt.*;

public class contaReceptor {
    private JPanel panel1;
    public contaReceptor() {
        JFrame frame = new JFrame("Conta Receptor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }
}
