package org.example.view;

import org.example.dao.UsuarioEmissorDAO;

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

        cadastrarButton.addActionListener(e->realizarCadastro());
    }

    private void realizarCadastro() {
        String nome = textField1.getText();
        String senha = new String(passwordField1.getPassword());

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        System.out.println("Tentando cadastrar "+nome + " " + senha);
        UsuarioEmissorDAO dao = new UsuarioEmissorDAO();
        dao.cadastrarUsuario(nome, senha);
        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        new LoginPageEmissor();

    }

}
