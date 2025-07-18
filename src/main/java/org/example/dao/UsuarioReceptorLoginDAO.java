package org.example.dao;

import org.example.model.Usuario;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioReceptorLoginDAO {
    public Usuario buscarPorNome(String nome) {
        String sql = "SELECT * FROM receptor WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario receptor = new Usuario();
                receptor.setNome(rs.getString("nome"));
                receptor.setSenha(rs.getString("senha")); // se precisar
                receptor.setSaldo(rs.getDouble("saldo")); // se o campo no banco se chama 'valor'
                return receptor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean atualizarSaldo(Usuario usuario) {
        String sql = "UPDATE receptor SET saldo = ? WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, usuario.getSaldo());
            stmt.setString(2, usuario.getNome());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
