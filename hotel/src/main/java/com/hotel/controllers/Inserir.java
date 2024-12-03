package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;

import java.sql.*;

public class Inserir {

    public static int inserir(Quarto q, JFrame frame) { //informações para conectar com o banco
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        boolean ocupado = q.getOcupadoc(); //armazena se o quanto esta ocupado em um bool

        try{
        if (q.getCPF().isEmpty() && ocupado == true){ //checa se cpf está vazio e o quarto está ocupado para mandar um erro
            JOptionPane.showMessageDialog(frame,"Insira o CPF da reserva no caso de ocupado");
            return 0;
        }}catch (Exception e){
            
        }
        
        try{
        if (q.getCPF().length() >= 1 && ocupado == false){ //checa se tem cpf escrito e não esta ocupado para mostrar erro
                JOptionPane.showMessageDialog(frame,"Não insira um cpf se não estiver ocupado");
                return 0;
        }}catch (Exception e){
                
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String checkQuery = "SELECT COUNT(*) FROM quartos WHERE N_Quarto = ?"; //comando do sql para puxar os quartos do banco
            try (PreparedStatement check = con.prepareStatement(checkQuery)) {
                check.setInt(1, q.getQuarto());
                
                try (ResultSet rs = check.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) { //checa se o quarto que tentou criar já existe no banco
                        JOptionPane.showMessageDialog(frame, "Quarto já existe");
                        return 0;
                    }
                }
            }
            
            String query = "INSERT INTO quartos (N_Quarto, acomoda, varanda, microondas, frigobar, tv, cpf, ocupado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; //comando para inserir no banco
            try (PreparedStatement a = con.prepareStatement(query)) {

                a.setInt(1, q.getQuarto()); //definindo cada campo
                a.setInt(2, q.getAcomoda());
                a.setBoolean(3, q.getVarandac());
                a.setBoolean(4, q.getMicroondasc());
                a.setBoolean(5, q.getFrigobarc());
                a.setBoolean(6, q.getTvc());
                a.setString(7, q.getCPF());
                a.setBoolean(8, q.getOcupadoc());

                a.executeUpdate(); //mandando para o banco as infos

                JOptionPane.showMessageDialog(frame, "Inserido com sucesso");
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco", "Erro", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
    }
}