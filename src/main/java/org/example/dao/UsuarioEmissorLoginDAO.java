package org.example.dao;


import org.example.model.Usuario;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioEmissorLoginDAO {
    public Usuario buscarPorNome(String nome) {
        String sql = "SELECT * FROM emissor WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario emissor = new Usuario();
                emissor.setNome(rs.getString("nome"));
                emissor.setSenha(rs.getString("senha")); // se precisar
                emissor.setSaldo(rs.getDouble("saldo")); // se o campo no banco se chama 'valor'
                return emissor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
