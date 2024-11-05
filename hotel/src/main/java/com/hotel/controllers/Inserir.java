package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;

import java.sql.*;

public class Inserir {

    public static int inserir(Quarto q, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        boolean ocupado = q.getOcupadoc();

        try{
        if (q.getCPF().isEmpty() && ocupado == true){
            JOptionPane.showMessageDialog(frame,"Insira o CPF da reserva no caso de ocupado");
            return 0;
        }}catch (Exception e){
            
        }
        
        try{
        if (q.getCPF().length() >= 1 && ocupado == false){
                JOptionPane.showMessageDialog(frame,"Não insira um cpf se não estiver ocupado");
                return 0;
        }}catch (Exception e){
                
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String checkQuery = "SELECT COUNT(*) FROM quartos WHERE N_Quarto = ?";
            try (PreparedStatement check = con.prepareStatement(checkQuery)) {
                check.setInt(1, q.getQuarto());
                
                try (ResultSet rs = check.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(frame, "Quarto já existe");
                        return 0;
                    }
                }
            }
            
            String query = "INSERT INTO quartos (N_Quarto, acomoda, varanda, microondas, frigobar, tv, cpf, ocupado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement a = con.prepareStatement(query)) {

                a.setInt(1, q.getQuarto());
                a.setInt(2, q.getAcomoda());
                a.setBoolean(3, q.getVarandac());
                a.setBoolean(4, q.getMicroondasc());
                a.setBoolean(5, q.getFrigobarc());
                a.setBoolean(6, q.getTvc());
                a.setString(7, q.getCPF());
                a.setBoolean(8, q.getOcupadoc());

                a.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Inserido com sucesso");
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}