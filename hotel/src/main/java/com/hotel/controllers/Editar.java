package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;

import java.sql.*;

public class Editar {
    public static int editar(Quarto q, int nqo, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        int nq = q.getQuarto();
        int acomoda = q.getAcomoda();
        String cpf = q.getCPF();
        boolean varanda = q.getVarandac();
        boolean microondas = q.getMicroondasc();
        boolean frigobar = q.getFrigobarc();
        boolean tv = q.getTvc();
        boolean ocupado = q.getOcupadoc();
        
        try{
        if (cpf.isEmpty() && ocupado == true){
            JOptionPane.showMessageDialog(frame,"Insira o CPF da reserva no caso de ocupado");
            return 0;
        }}catch(Exception e){
            
        }

        try{
            if (q.getCPF().length() >= 1 && ocupado == false){
                    JOptionPane.showMessageDialog(frame,"Não insira um cpf se não estiver ocupado");
                    return 0;
            }}catch (Exception e){
                    
            }

        if (nq != nqo) {
            JOptionPane.showMessageDialog(frame, "Não altere o número do quarto");
            return 0;
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE quartos SET acomoda = ?, cpf = ?, varanda = ?, microondas = ?, frigobar = ?, tv = ?, ocupado = ? WHERE N_Quarto = ?";
            try (PreparedStatement a = con.prepareStatement(query)) {
                a.setInt(1, (acomoda));
                a.setString(2, cpf);
                a.setBoolean(3, varanda);
                a.setBoolean(4, microondas);
                a.setBoolean(5, frigobar);
                a.setBoolean(6, tv);
                a.setBoolean(7, ocupado);
                a.setInt(8, nq);

                a.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Editado com sucesso");
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
