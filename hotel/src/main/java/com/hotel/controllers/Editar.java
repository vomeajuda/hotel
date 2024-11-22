package com.hotel.controllers;

import javax.swing.*;

import com.hotel.models.Quarto;

import java.sql.*;

public class Editar {
    public static int editar(Quarto q, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds"; //informações para conectar com o banco
        String user = "root";
        String password = "";

        int nq = q.getQuarto(); //puxa do quarto que vai editar as informações
        int acomoda = q.getAcomoda();
        String cpf = q.getCPF();
        boolean varanda = q.getVarandac();
        boolean microondas = q.getMicroondasc();
        boolean frigobar = q.getFrigobarc();
        boolean tv = q.getTvc();
        boolean ocupado = q.getOcupadoc();
        
        try{
        if (cpf.isEmpty() && ocupado == true){ //checa se esta sem cpf e ocupado para dar erro
            JOptionPane.showMessageDialog(frame,"Insira o CPF da reserva no caso de ocupado");
            return 0;
        }}catch(Exception e){
            
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE quartos SET acomoda = ?, cpf = ?, varanda = ?, microondas = ?, frigobar = ?, tv = ?, ocupado = ? WHERE N_Quarto = ?"; //comando para realizar o update
            try (PreparedStatement a = con.prepareStatement(query)) {
                a.setInt(1, (acomoda)); //define cada dado
                a.setString(2, cpf);
                a.setBoolean(3, varanda);
                a.setBoolean(4, microondas);
                a.setBoolean(5, frigobar);
                a.setBoolean(6, tv);
                a.setBoolean(7, ocupado);
                a.setInt(8, nq);

                a.executeUpdate(); //executa o update
                JOptionPane.showMessageDialog(frame, "Editado com sucesso");
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
