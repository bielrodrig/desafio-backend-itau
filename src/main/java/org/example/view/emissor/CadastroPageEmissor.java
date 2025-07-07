package org.example.view.emissor;

import org.example.dao.UsuarioEmissorDAO;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class CadastroPageEmissor extends Component {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton cadastrarButton;

    public CadastroPageEmissor() {
        JFrame frame = new JFrame("Cadastro de Emissor");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cadastrarButton.addActionListener(e -> realizarCadastro());
    }

    private void realizarCadastro() {
        String nome = textField1.getText();
        String senha = new String(passwordField1.getPassword());

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        if (validarSenha(senha)) {
            Usuario usuario = new Usuario(nome, senha);
            usuario.setNome(nome);
            usuario.setSenha(senha);
            System.out.println("Cadastrando " + nome + " " + senha);
            UsuarioEmissorDAO.cadastrarUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            new LoginPageEmissor();
        } else {
            JOptionPane.showMessageDialog(null, "Escolha uma senha que atenda os requisitos");
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
