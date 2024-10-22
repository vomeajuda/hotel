package com.hotel.controllers;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class Todos {
    private DefaultTableModel modelo;

    public Todos(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public void todos() {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM quartos";
            ResultSet rs = stmt.executeQuery(query);

            modelo.setRowCount(0);

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

                modelo.addRow(linha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}