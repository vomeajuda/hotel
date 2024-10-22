package com.hotel.controllers;

import com.hotel.models.Quarto;
import com.hotel.views.Consulta1;

import java.sql.*;
import java.util.Vector;

public class Carregar {

    public static void carregar(Quarto q){
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement a = con.createStatement()) {

            String query = "SELECT * FROM quartos WHERE N_Quarto = " + q.getQuarto();
            ResultSet rs = a.executeQuery(query);


            while (rs.next()) {
                Vector<Object> linha = new Vector<>();
                linha.add(rs.getInt("N_Quarto"));
                linha.add(rs.getInt("acomoda"));
                linha.add(rs.getString("varanda"));
                linha.add(rs.getString("microondas"));
                linha.add(rs.getString("frigobar"));
                linha.add(rs.getString("tv"));
                linha.add(rs.getString("cpf"));
                linha.add(rs.getString("ocupado"));

                Quarto q1 = new Quarto();
                q1.setLinha(linha);
                Consulta1.atualizar(q1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
