package org.example.view.receptor;

import org.example.dao.UsuarioEmissorLoginDAO;
import org.example.dao.UsuarioReceptorDAO;
import org.example.dao.UsuarioReceptorLoginDAO;
import org.example.model.Usuario;
import org.example.view.emissor.CadastroPageEmissor;
import org.example.view.emissor.contaEmissor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        entrarButton.addActionListener(e -> validarLoginReceptor());
        textCadastro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new CadastroPageReceptor();
                frame.dispose();
            }
        });
    }
    private void validarLoginReceptor() {
        String nome = textField1.getText();
        String senha = passwordField1.getText();

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }

        UsuarioReceptorLoginDAO dao = new UsuarioReceptorLoginDAO();
        Usuario usuarioLogado = dao.buscarPorNome(nome);  // novo método que retorna o objeto

        if (usuarioLogado != null) {
            JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
            new contaReceptor(usuarioLogado);
            // passa o usuário para a próxima tela
        } else {
            JOptionPane.showMessageDialog(null, "Credenciais incorretas");
        }
    }
}
