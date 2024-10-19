package com.hotel.views;

import com.hotel.Main;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

public class Excluir extends JFrame{
    private JTextField campo; //declaração de todos os objetos
    private JLabel label;
    private JButton btnE, btnV;
    private JPanel panel;

    public Excluir(){
        super("Excluir");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("N° Quarto"); //criação da label
        campo = new JTextField(20); //criação de um field

        panel = new JPanel(); //criação de painel
        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); //configuração de layout do painel
        panel.setBorder(new EmptyBorder(2, 2, 2, 2)); //configuração da borda do painel (tipo um padding)

        btnE = new JButton("Excluir"); //criação do botão
        btnV = new JButton("Voltar"); //criação do botão
        panel.add(btnE); //adição do botão
        panel.add(btnV); //adição do botão

        Container janela; //criação da janela
        janela = getContentPane();
        janela.setLayout(new BorderLayout()); //layout da janela
        janela.add(label, BorderLayout.NORTH); //adição da label
        janela.add(campo, BorderLayout.CENTER); //adição de um field
        janela.add(panel, BorderLayout.SOUTH); //adição de painel

        btnE.addActionListener((actionEvent) -> {
            delete();
            this.dispose();
            Main.telaP.setVisible(true);
        });

        btnV.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaP.setVisible(true);
        });
    }

    private void delete(){
        String n = campo.getText();
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        Connection con = null;
        PreparedStatement a = null;
        PreparedStatement a2 = null;
        ResultSet b = null;

        try{
        con = DriverManager.getConnection(url, user, password);

        String query2 = "SELECT * FROM quartos WHERE N_Quarto = ?";
        a2 = con.prepareStatement(query2);
        a2.setString(1, n);
        b = a2.executeQuery();

        if (b.next()){
            String query = "DELETE FROM quartos WHERE N_Quarto = " + n;
            a = con.prepareStatement(query);
            a.executeUpdate();
    
            JOptionPane.showMessageDialog(null,"Quarto excluido");
        }else{
            JOptionPane.showMessageDialog(null,"Quarto não existe");
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}