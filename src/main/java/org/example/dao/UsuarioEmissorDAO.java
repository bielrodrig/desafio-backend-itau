package org.example.dao;

import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioEmissorDAO {

    public static boolean cadastrarUsuario(String nome, Double valor, String senha) {
        String sql = "INSERT INTO emissor (nome, valor, senha) VALUES (?, ?, ?)";

       try(Connection conn = Conexao.conectar();
       PreparedStatement stmt = conn.prepareStatement(sql)) {
           stmt.setString(1, nome);
           stmt.setDouble(2, valor);
           stmt.setString(3, senha);

           stmt.executeUpdate();

       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
        return false;
    }
}
