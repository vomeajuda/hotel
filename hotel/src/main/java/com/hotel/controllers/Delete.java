package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;

import java.sql.*;

public class Delete {

    public static int delete(Quarto q, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";//informações para conectar com o banco
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement b = con.prepareStatement("DELETE FROM quartos WHERE N_Quarto = ?")) { //deleta o quarto selecionado

                b.setInt(1, q.getQuarto()); //coloca o numero do quarto no comando de delete
                b.executeUpdate(); //roda o delete
                JOptionPane.showMessageDialog(frame, "Quarto excluído com sucesso");
                return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco", "Erro", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
    }
}