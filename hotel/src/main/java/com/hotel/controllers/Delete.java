package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;

import java.sql.*;

public class Delete {

    public static int delete(Quarto q, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement a = con.prepareStatement("SELECT * FROM quartos WHERE N_Quarto = ?");
             PreparedStatement b = con.prepareStatement("DELETE FROM quartos WHERE N_Quarto = ?")) {

            a.setInt(1, q.getQuarto());
            ResultSet rs = a.executeQuery();

            if (rs.next()) {
                b.setInt(1, q.getQuarto());
                b.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Quarto excluído com sucesso");
                return 1;
            } else {
                JOptionPane.showMessageDialog(frame, "Quarto não encontrado");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}