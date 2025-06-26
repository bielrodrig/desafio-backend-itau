package org.example.dao;

import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioEmissorDAO {

    public static boolean cadastrarUsuario(String nome, String senha) {
        String sql = "INSERT INTO emissor (nome, senha) VALUES (?, ?)";

       try(Connection conn = Conexao.conectar();
       PreparedStatement stmt = conn.prepareStatement(sql)) {
           stmt.setString(1, nome);
           stmt.setString(2, senha);

           stmt.executeUpdate();

       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
        return false;
    }
}
