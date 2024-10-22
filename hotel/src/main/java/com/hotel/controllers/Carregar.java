package com.hotel.controllers;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class Carregar {
    private DefaultTableModel modelo;
    private String numeroQuarto;

    public Carregar(DefaultTableModel modelo, String numeroQuarto) {
        this.modelo = modelo;
        this.numeroQuarto = numeroQuarto;
    }

    public void carregar() {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM quartos WHERE N_Quarto = " + numeroQuarto;
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
