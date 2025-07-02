package org.example.view.emissor;

import org.example.dao.UsuarioEmissorLoginDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPageEmissor {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton entrarButton;
    private JLabel textCadastro;
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
        textCadastro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new CadastroPageEmissor();
                frame.dispose();
            }
        });
    }

    private void validarLogin() {
        String nome = textField1.getText();
        String senha = passwordField1.getText();

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }

        UsuarioEmissorLoginDAO dao = new UsuarioEmissorLoginDAO();
        boolean valido = dao.validarLogin(nome, senha);
        if (valido) {
            JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
            new contaEmissor();
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "credenciais incorretas");
        }

    }
}
