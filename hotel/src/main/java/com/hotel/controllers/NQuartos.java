package com.hotel.controllers;

import com.hotel.models.Quarto;
import com.hotel.views.Consulta1;
import com.hotel.views.Edit;
import com.hotel.views.Excluir;

import java.sql.*;

import javax.swing.JOptionPane;

public class NQuartos {

    public static void nquartos(int n) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM quartos";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String x;

                x = rs.getString("N_Quarto");

                Quarto q1 = new Quarto();
                q1.setQuartoc(x);
                if (n == 1){
                    Edit.fill(q1);
                }else if (n == 2){
                    Consulta1.fill(q1);
                }else if (n == 3){
                    Excluir.fill(q1);
                }else{
                    JOptionPane.showMessageDialog(null,"Erro");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
