package org.example.view.emissor;

import org.example.model.TipoTransferencia;
import org.example.model.TransferenciaService;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class contaEmissor {
    private Usuario emissor;
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

    public contaEmissor(Usuario emissor) {
        this.emissor = emissor;

        JFrame frame = new JFrame("Conta Emissor");
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Atualiza o nome e saldo do usuário na interface
        userName.setText(emissor.getNome());
        valorUser.setText("R$ " + String.format("%.2f", emissor.getSaldo()));

        // Ação do botão
        enviarButton.addActionListener(e -> processarTransferencia());
    }

    private void processarTransferencia() {
        try {
            String nomeReceptor = textField1.getText(); // Nome do receptor
            double valor = Double.parseDouble(textField2.getText()); // Valor da transferência

            if (nomeReceptor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o nome do receptor.");
                return;
            }

            // Tipo de transferência fixo por enquanto (pode melhorar depois com JComboBox)
            TipoTransferencia tipo = TipoTransferencia.PIX;

            // Buscar o receptor no banco
            Usuario receptor = new org.example.dao.UsuarioReceptorLoginDAO().buscarPorNome(nomeReceptor);

            if (receptor == null) {
                JOptionPane.showMessageDialog(null, "Usuário receptor não encontrado.");
                return;
            }

            TransferenciaService service = new TransferenciaService();
            String resultado = service.realizarTransferencia(emissor, receptor, valor, tipo);

            JOptionPane.showMessageDialog(null, resultado);

            // Atualiza o saldo na tela
            valorUser.setText("R$ " + String.format("%.2f", emissor.getSaldo()));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido para a transferência.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }


}
