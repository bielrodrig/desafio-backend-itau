package org.example.view.receptor;

import org.example.dao.UsuarioEmissorDAO;
import org.example.dao.UsuarioReceptorDAO;
import org.example.dao.UsuarioReceptorLoginDAO;
import org.example.model.Usuario;
import org.example.view.emissor.LoginPageEmissor;

import javax.swing.*;
import java.awt.*;

public class CadastroPageReceptor {
    private JPanel panel1;
    private JTextField textField1;
    private JButton cadastrarButton;
    private JPasswordField passwordField1;

    public CadastroPageReceptor() {
        JFrame frame = new JFrame("Cadastro Page Receptor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cadastrarButton.addActionListener(e -> realizarCadastroReceptor());
    }

    private void realizarCadastroReceptor() {
        String nome = textField1.getText();
        String senha = new String(passwordField1.getPassword());

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }

        if (validarSenha(senha)) {
            Usuario usuario = new Usuario(nome, senha);
            usuario.setNome(nome);
            usuario.setSenha(senha);
            System.out.println("Cadastrando " + nome + " " + senha);
            UsuarioReceptorDAO.cadastrarUsuarioReceptor(usuario);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            new LoginPageEmissor();
        } else {
            JOptionPane.showMessageDialog(null, "Escolha uma senha que atendas todos os requisitos");
        }
    }

    public static boolean validarSenha(String senha) {
        if (senha.length() < 8) {
            return false;
        }
        boolean letraMaiuscula = false;
        boolean letraMinuscula = false;
        boolean caracterEspeciail = false;
        boolean digito = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                letraMaiuscula = true;
            } else if (Character.isLowerCase(c)) {
                letraMinuscula = true;
            } else if (Character.isDigit(c)) {
                digito = true;
            } else if (!Character.isLetterOrDigit(c)) {
                caracterEspeciail = true;
            }
        }
        return letraMaiuscula && letraMinuscula && caracterEspeciail && digito;
    }

}
