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
             PreparedStatement a = con.prepareStatement("SELECT * FROM quartos WHERE N_Quarto = ?"); //define e executa a verificação se o quarto selecionado existe
             PreparedStatement b = con.prepareStatement("DELETE FROM quartos WHERE N_Quarto = ?")) { //deleta o quarto selecionado

            a.setInt(1, q.getQuarto()); //coloca no select o numero do quarto
            ResultSet rs = a.executeQuery(); //roda o select

            if (rs.next()) { //roda se tiver resultado vindo do select
                b.setInt(1, q.getQuarto()); //coloca o numero do quarto no comando de delete
                b.executeUpdate(); //roda o delete
                JOptionPane.showMessageDialog(frame, "Quarto excluído com sucesso");
                return 1;
            } else { //se não tiver resultado do select dar erro
                JOptionPane.showMessageDialog(frame, "Quarto não encontrado");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}