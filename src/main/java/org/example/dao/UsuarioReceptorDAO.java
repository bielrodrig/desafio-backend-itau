package org.example.dao;

import org.example.model.Usuario;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioReceptorDAO {
    public static boolean cadastrarUsuarioReceptor(Usuario usuario) {
        String sql = "INSERT INTO receptor (nome, senha, valor) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setDouble(3, 0.0);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
