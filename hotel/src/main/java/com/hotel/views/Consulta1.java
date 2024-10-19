package com.hotel.views;
import com.hotel.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class Consulta1 extends JFrame{
    private JTextArea campo; //declaração de todos os objetos
    private JLabel label;
    private JButton btnE, btnV, btnT;
    private JPanel panel, panel2;
    String[] colunas = {"N° Quarto", "Acomoda", "Varanda", "Micro-Ondas", "Frigobar", "TV", "CPF", "Ocupado"};
    DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
    JTable tabela;
    JScrollPane scroll;

    public Consulta1(){
        super("Consultar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("N° Quarto"); //criação da label
        campo = new JTextArea(); //criação de um field

        panel = new JPanel(); //criação de painel
        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); //configuração de layout do painel
        panel.setBorder(new EmptyBorder(2, 2, 2, 2)); //configuração da borda do painel (tipo um padding)

        btnE = new JButton("Consultar"); //criação do botão
        btnT = new JButton("Todos"); //criação do botão
        btnV = new JButton("Voltar"); //criação do botão
        panel.add(btnE); //adição do botão
        panel.add(btnT); //adição do botão
        panel.add(btnV); //adição do botão

        panel2 = new JPanel(); //criação de painel
        panel2.setLayout(new BorderLayout()); //configuração de layout do painel
        panel2.add(label, BorderLayout.NORTH); //adição da label
        panel2.add(campo, BorderLayout.CENTER); //adição de um field
        panel2.add(panel, BorderLayout.SOUTH); //adição de painel

        JTable tabela = new JTable(modelo); //criação da tabela
        JScrollPane scroll = new JScrollPane(tabela); //criação do scroll

        Container janela; //criação da janela
        janela = getContentPane();
        janela.setLayout(new BorderLayout()); //layout da janela
        janela.add(panel2, BorderLayout.WEST); //adição de painel
        janela.add(scroll, BorderLayout.EAST); //adição do scroll

        pack();

        btnE.addActionListener((actionEvent) -> {
            carregar();
        });

        btnT.addActionListener((actionEvent) -> {
            todos();
        });

        btnV.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaP.setVisible(true);
        });
    }

    private void carregar(){
        String n = campo.getText();
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        Connection con = null;
        Statement a = null;
        ResultSet b = null;

        try{
            con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM quartos WHERE N_Quarto = " + n;
            a = con.createStatement();
            b = a.executeQuery(query);

            modelo.setRowCount(0);

            while (b.next()) {
                Vector<Object> linha = new Vector<>();
                linha.add(b.getInt("N_Quarto"));
                linha.add(b.getInt("acomoda"));
                linha.add(b.getString("varanda"));
                linha.add(b.getString("microondas"));
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

    private void todos(){
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        Connection con = null;
        Statement a = null;
        ResultSet b = null;

        try{
            con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM quartos";
            a = con.createStatement();
            b = a.executeQuery(query);

            modelo.setRowCount(0);

            while (b.next()) {
                Vector<Object> linha = new Vector<>();
                linha.add(b.getInt("N_Quarto"));
                linha.add(b.getInt("acomoda"));
                linha.add(b.getString("varanda"));
                linha.add(b.getString("microondas"));
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