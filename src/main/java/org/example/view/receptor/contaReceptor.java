package org.example.view.receptor;

import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class contaReceptor {
    private Usuario receptor;
    private JPanel panel1;
    private JLabel userName;
    private JLabel valorUser;
    public contaReceptor(Usuario receptor) {

        this.receptor = receptor;

        JFrame frame = new JFrame("Conta Receptor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        userName.setText(receptor.getNome());
        valorUser.setText(String.format("%.2f", receptor.getSaldo()));



    }
}
