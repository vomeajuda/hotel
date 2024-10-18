package com.hotel.views;
import com.hotel.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class Consulta2 extends JFrame{
    String[] colunas = {"N° Quarto", "Acomoda", "Varanda", "Micro-Ondas", "Frigobar", "TV", "CPF", "Ocupado"};
    DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
    JTable tabela;
    JScrollPane scroll;
    JButton btnV;

    public Consulta2(){
        super("Consulta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnV = new JButton("Voltar");

        Container janela;
        janela = getContentPane();
        janela.setLayout(new BorderLayout());
        janela.add(scroll, BorderLayout.NORTH);
        janela.add(btnV, BorderLayout.SOUTH);

        pack();

        carregar();

        btnV.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaC1.setVisible(true);
        });
    }


    private void carregar() {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        Connection con = null;
        Statement a = null;
        ResultSet b = null;
        try {
            con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM quartos";
            a = con.createStatement();
            b = a.executeQuery(query);

            modelo.setRowCount(0);

            while (b.next()) {
                Vector<Object> linha = new Vector<>();
                linha.add(b.getInt("numero_quarto"));
                linha.add(b.getInt("acomoda"));
                linha.add(b.getString("varanda"));
                linha.add(b.getString("micro_ondas"));
                linha.add(b.getString("frigobar"));
                linha.add(b.getString("tv"));
                linha.add(b.getString("cpf"));
                linha.add(b.getString("ocupado"));

                modelo.addRow(linha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}