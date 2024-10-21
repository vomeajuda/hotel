package com.hotel.controllers;

import javax.swing.*;
import java.sql.*;

public class Delete {
    private String numeroQuarto;
    private JFrame frame;

    public Delete(String numeroQuarto, JFrame frame) {
        this.numeroQuarto = numeroQuarto;
        this.frame = frame;
    }

    public int delete() {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement a = con.prepareStatement("SELECT * FROM quartos WHERE N_Quarto = ?");
             PreparedStatement b = con.prepareStatement("DELETE FROM quartos WHERE N_Quarto = ?")) {

            a.setString(1, numeroQuarto);
            ResultSet rs = a.executeQuery();

            if (rs.next()) {
                b.setString(1, numeroQuarto);
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