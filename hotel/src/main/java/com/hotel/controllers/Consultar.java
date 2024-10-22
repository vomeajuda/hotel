package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;
import com.hotel.views.Edit;

import java.sql.*;

public class Consultar {
    public static void consultar(Quarto q, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT acomoda, varanda, microondas, frigobar, tv, cpf, ocupado FROM quartos WHERE N_Quarto = ?";
            try (PreparedStatement a = con.prepareStatement(query)) {
                a.setInt(1, q.getQuarto());
                try (ResultSet b = a.executeQuery()) {
                    if (b.next()) {
                        q.setAcomoda(b.getInt("acomoda"));
                        q.setCPF(b.getString("cpf"));
                        q.setVarandac(b.getBoolean("varanda"));
                        q.setMicroondasc(b.getBoolean("microondas"));
                        q.setFrigobarc(b.getBoolean("frigobar"));
                        q.setTvc(b.getBoolean("tv"));
                        q.setOcupadoc(b.getBoolean("ocupado"));
                        
                        Edit.alterar(q);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Nenhum quarto encontrado com este número");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}