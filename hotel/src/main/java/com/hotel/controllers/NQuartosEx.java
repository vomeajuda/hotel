package com.hotel.controllers;

import com.hotel.models.Quarto;
import com.hotel.views.Excluir;

import java.sql.*;

public class NQuartosEx {

    public static void nquartos() {
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
                Excluir.fill(q1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
