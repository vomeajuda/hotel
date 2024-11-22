package com.hotel.controllers;

import com.hotel.models.Quarto;
import com.hotel.views.Consulta1;
import com.hotel.views.Edit;
import com.hotel.views.Excluir;

import java.sql.*;

import javax.swing.JOptionPane;

public class NQuartos {

    public static void nquartos(int n) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds"; //informações para conectar com o banco
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password); //realiza a conexão
            Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM quartos"; //seta o comando
            ResultSet rs = stmt.executeQuery(query); //roda o comando e armazena o resultado em rs

            while (rs.next()) { //roda até não ter um próximo registro na resposta
                String x;

                x = rs.getString("N_Quarto"); //armazena o numero do quarto vindo do banco
                Quarto q1 = new Quarto(); //roda o construtor vazio de quarto
                q1.setQuartoc(x); //coloca o número do quarto neste modelo
                if (n == 1){ //utiliza o número passado para preencher a pagina certa
                    Edit.fill(q1); //se 1 carrega em edição
                }else if (n == 2){ 
                    Consulta1.fill(q1); //se 2 carrega em consulta
                }else if (n == 3){ 
                    Excluir.fill(q1); //se 3 carrega em excluir
                }else{
                    JOptionPane.showMessageDialog(null,"Erro");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
