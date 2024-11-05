package com.hotel.views;
import com.hotel.Main;

import javax.swing.*;
import java.awt.*;

public class Inicial extends JFrame{
    private JLabel titulo; //declaração de todos os objetos
    private JButton btnI, btnC, btnEd, btnEx, btnS;

    public Inicial(){
        super("Inicio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        titulo = new JLabel("Bem-Vindo ao Banco de Quartos do hotel"); //criação da label
        btnI = new JButton("Inserir"); //criação do botão
        btnC = new JButton("Consultar"); //criação do botão
        btnEd = new JButton("Editar"); //criação do botão
        btnEx = new JButton("Excluir"); //criação do botão
        btnS = new JButton("Sair"); //criação do botão

        Container janela; //criação da janela
        janela = getContentPane();
        janela.setLayout(new GridLayout(6, 1)); //layout da janela

        janela.add(titulo); //adição da label
        janela.add(btnI); //adição do botão
        janela.add(btnC); //adição do botão
        janela.add(btnEd); //adição do botão
        janela.add(btnEx); //adição do botão
        janela.add(btnS); //adição do botão

        btnI.addActionListener((actionEvent) -> {
            this.dispose();
            Insert.reset();
            Main.telaI.setVisible(true);
        });

        btnC.addActionListener((actionEvent) -> {
            this.dispose();
            Consulta1.reset();
            Main.telaC1.setVisible(true);
        });

        btnEd.addActionListener((actionEvent) -> {
            this.dispose();
            Edit.reset();
            Main.telaEd.setVisible(true);
        });

        btnEx.addActionListener((actionEvent) -> {
            this.dispose();
            Excluir.reset();
            Main.telaEx.setVisible(true);
            Main.telaEx.setSize(200, 150);
        });

        btnS.addActionListener((actionEvent) -> {
            System.exit(0);
        });
    }
}
