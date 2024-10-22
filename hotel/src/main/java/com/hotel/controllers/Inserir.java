package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;

import java.sql.*;

public class Inserir {

    public static int inserir(Quarto q, JRadioButton radio1, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        if (q.getCPF().isEmpty() && radio1.isSelected()){
            JOptionPane.showMessageDialog(frame,"Insira o CPF da reserva no caso de ocupado");
            return 0;
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String checkQuery = "SELECT COUNT(*) FROM quartos WHERE N_Quarto = ?";
            try (PreparedStatement check = con.prepareStatement(checkQuery)) {
                check.setInt(1, q.getQuarto());
                
                try (ResultSet rs = check.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(frame, "Quarto já existe");
                        return 0;
                    }
                }
            }
            
            String query = "INSERT INTO quartos (N_Quarto, acomoda, varanda, microondas, frigobar, tv, cpf, ocupado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement a = con.prepareStatement(query)) {

                a.setInt(1, q.getQuarto());
                a.setInt(2, q.getAcomoda());
                a.setInt(3, q.getVaranda());
                a.setInt(4, q.getMicroondas());
                a.setInt(5, q.getFrigobar());
                a.setInt(6, q.getTv());
                a.setString(7, q.getCPF());
                a.setInt(8, q.getOcupado());

                a.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Inserido com sucesso");
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}