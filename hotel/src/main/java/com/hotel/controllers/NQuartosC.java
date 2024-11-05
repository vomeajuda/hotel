package com.hotel.controllers;

import com.hotel.models.Quarto;
import com.hotel.views.Consulta1;

import java.sql.*;

public class NQuartosC {

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
                Consulta1.fill(q1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
