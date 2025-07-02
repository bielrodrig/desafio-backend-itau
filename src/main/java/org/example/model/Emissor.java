package org.example.model;

import javax.swing.*;

public class Emissor {
    public static void regraPIX() {
        Usuario usuario = new Usuario();
        usuario.getValor();
        if (usuario.getValor() > 5.000) {
            JOptionPane.showMessageDialog(null, "Limite atingido " + usuario.getValor() + " e maior que 5.000");
        } else {
            JOptionPane.showMessageDialog(null, "Transferencia permitida!");
        }
    }
}
