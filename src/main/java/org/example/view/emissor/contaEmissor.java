package org.example.view.emissor;

import org.example.model.TipoTransferencia;
import org.example.model.TransferenciaService;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class contaEmissor {
    private Usuario emissor;
    private JTextField textField1; // Para o nome do receptor
    private JButton enviarButton;
    private JTextField textField2; // Para o valor da transferência
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
        // 1. Pega o texto do campo de valor e do nome do receptor
        String nomeReceptor = textField2.getText();
        String valorTexto = textField1.getText();

        // --- VALIDAÇÃO REFORÇADA ---

        // 2. Verifica se o nome do receptor foi preenchido
        if (nomeReceptor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome do receptor.");
            return; // Para a execução do método aqui
        }

        // 3. Verifica se o campo de valor está vazio
        if (valorTexto == null || valorTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo de valor não pode estar vazio.");
            return; // Para a execução do método aqui
        }

        // --- FIM DA VALIDAÇÃO ---


        try {
            // 4. Se passou nas validações, agora limpamos e convertemos o valor
            String valorLimpo = valorTexto.trim().replace(",", ".");
            double valor = Double.parseDouble(valorLimpo);

            // O restante do seu código continua aqui...
            TipoTransferencia tipo = TipoTransferencia.PIX;
            Usuario receptor = new org.example.dao.UsuarioReceptorLoginDAO().buscarPorNome(nomeReceptor);

            if (receptor == null) {
                JOptionPane.showMessageDialog(null, "Usuário receptor não encontrado.");
                return;
            }

            TransferenciaService service = new TransferenciaService();
            String resultado = service.realizarTransferencia(emissor, receptor, valor, tipo);

            JOptionPane.showMessageDialog(null, resultado);
            valorUser.setText("R$ " + String.format("%.2f", emissor.getSaldo()));

        } catch (NumberFormatException e) {
            // Se mesmo assim cair aqui, o usuário digitou algo como "abc" ou "50 e 25"
            JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite apenas números (ex: 50.25).");

            // DICA DE DEBUG: Imprima o que causou o erro no console
            System.err.println("Erro de conversão para o valor: '" + textField2.getText() + "'");
            e.printStackTrace(); // Mostra o erro completo no console de execução

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}