package com.hotel.controllers;

import com.hotel.models.Quarto;
import com.hotel.views.Consulta1;

import java.sql.*;
import java.util.Vector;

public class Carregar {

    public static void carregar(Quarto q){
        String url = "jdbc:mysql://localhost:3306/hotel_ds"; //informações para conectar com o banco
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement a = con.createStatement()) {

            String query = "SELECT * FROM quartos WHERE N_Quarto = " + q.getQuarto(); //monta o comando de select com o numero do quarto
            ResultSet rs = a.executeQuery(query); //executa o select


            while (rs.next()) { //enquanto houver prõximos registros no resultado
                Vector<Object> linha = new Vector<>(); //cria um vetor para as linhas da tabela
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

                Quarto q1 = new Quarto(); //roda o construtor vazio
                q1.setLinha(linha); //manda o vetor de linha para o modelo
                Consulta1.atualizar(q1); //preenche a tabela da tela de consulta
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
