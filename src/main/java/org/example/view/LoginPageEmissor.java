package org.example.view;

import org.example.dao.UsuarioEmissorLoginDAO;

import javax.swing.*;
import java.awt.*;

public class LoginPageEmissor {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton entrarButton;
    private JFrame frame;

    public LoginPageEmissor() {
        frame = new JFrame("Login Page Emissor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        entrarButton.addActionListener(e -> validarLogin());
    }

    private void validarLogin() {
        String nome = textField1.getText();
        String senha = passwordField1.getText();

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }

        UsuarioEmissorLoginDAO dao = new UsuarioEmissorLoginDAO();
        dao.validarLogin(nome, senha);

    }
}
