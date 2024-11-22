package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;
import com.hotel.views.Edit;

import java.sql.*;

public class Consultar {
    public static void consultar(Quarto q, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds"; //informações para conectar com o banco
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT acomoda, varanda, microondas, frigobar, tv, cpf, ocupado FROM quartos WHERE N_Quarto = ?"; //monta o comando do select
            try (PreparedStatement a = con.prepareStatement(query)) {
                a.setInt(1, q.getQuarto()); //insere o numero do quarto no comando select
                try (ResultSet b = a.executeQuery()) { //roda o select
                    if (b.next()) { //se voltar resultado do select
                        q.setAcomoda(b.getInt("acomoda")); //define cada campo no modelo com o vindo do banco
                        q.setCPF(b.getString("cpf"));
                        q.setVarandac(b.getBoolean("varanda"));
                        q.setMicroondasc(b.getBoolean("microondas"));
                        q.setFrigobarc(b.getBoolean("frigobar"));
                        q.setTvc(b.getBoolean("tv"));
                        q.setOcupadoc(b.getBoolean("ocupado"));
                        
                        Edit.alterar(q); //preenche a janela
                    } else { //se não voltar nada do select erro
                        JOptionPane.showMessageDialog(frame, "Nenhum quarto encontrado com este número");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}