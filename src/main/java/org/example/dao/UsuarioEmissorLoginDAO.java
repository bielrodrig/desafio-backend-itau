package org.example.dao;


import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioEmissorLoginDAO {
    public boolean validarLogin(String nome, String senha) {
        String sql = "select * from emissor where nome = ? and senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
