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

    public void delete() {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM quartos WHERE N_Quarto = ?");
             PreparedStatement stmt2 = con.prepareStatement("DELETE FROM quartos WHERE N_Quarto = ?")) {

            // Verifica se o quarto existe
            stmt1.setString(1, numeroQuarto);
            ResultSet rs = stmt1.executeQuery();

            if (rs.next()) {
                // Exclui o quarto
                stmt2.setString(1, numeroQuarto);
                stmt2.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Quarto excluído com sucesso");
            } else {
                JOptionPane.showMessageDialog(frame, "Quarto não encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao excluir o quarto");
        }
    }
}