package org.example.view.emissor;

import javax.swing.*;
import java.awt.*;

public class contaEmissor {
    private JTextField textField1;
    private JButton enviarButton;
    private JTextField textField2;
    private JPanel panel1;
    private JLabel userName;
    private JLabel valorUser;
    private JLabel textWelcome;
    private JLabel textSaldo;
    private JLabel textTransfer;
    private JLabel textRemetente;

    public contaEmissor() {
        JFrame frame = new JFrame("Conta Emissor");
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
