package org.example.dao;

import org.example.model.Usuario;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioEmissorDAO {

    public static boolean cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO emissor (nome, senha, saldo) VALUES (?, ?, ?)";

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
