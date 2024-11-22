package com.hotel.controllers;

import com.hotel.models.Quarto;
import com.hotel.views.Consulta1;

import java.sql.*;
import java.util.Vector;

public class Todos {

    public static void todos() {
        String url = "jdbc:mysql://localhost:3306/hotel_ds"; //informações para conectar com o banco
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password); //realiza a conexão
            Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM quartos"; //armazena o comando sql
            ResultSet rs = stmt.executeQuery(query); //executa o comando e armazena o resultado em rs

            while (rs.next()) { //enquanto tiver mais posições a seguir no resultado
                Vector<Object> linha = new Vector<>(); //cria um vetor 
                linha.add(rs.getInt("N_Quarto")); //adiciona o numero do quarto ao vetor
                linha.add(rs.getInt("acomoda")); //adiciona quantos acomoda ao vetor
                if (rs.getInt("varanda") == 1){ //se retornar 1 (true) do banco coloca sim no vetor
                    linha.add("Sim");
                }else { //se retornar 0 (false) do banco coloca não no vetor
                    linha.add("Não");
                }
                if (rs.getInt("microondas") == 1){ //se retornar 1 (true) do banco coloca sim no vetor
                    linha.add("Sim");
                }else { //se retornar 0 (false) do banco coloca não no vetor
                    linha.add("Não");
                }
                if (rs.getInt("frigobar") == 1){ //se retornar 1 (true) do banco coloca sim no vetor
                    linha.add("Sim");
                }else { //se retornar 0 (false) do banco coloca não no vetor
                    linha.add("Não");
                }
                if (rs.getInt("tv") == 1){ //se retornar 1 (true) do banco coloca sim no vetor
                    linha.add("Sim");
                }else { //se retornar 0 (false) do banco coloca não no vetor
                    linha.add("Não");
                }
                linha.add(rs.getString("cpf")); //adiciona o cpf ao vetor
                if (rs.getInt("ocupado") == 1){ //se retornar 1 (true) do banco coloca sim no vetor
                    linha.add("Sim");
                }else { //se retornar 0 (false) do banco coloca não no vetor
                    linha.add("Não");
                }

                Quarto q1 = new Quarto(); //roda o construtor vazio de quarto
                q1.setLinha(linha); //adiciona o vetor de linha 
                Consulta1.atualizar(q1); //retorna o quarto com a linha para a tela de consulta
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}