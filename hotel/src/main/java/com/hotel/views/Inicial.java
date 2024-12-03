package com.hotel.views;
import com.hotel.Main;
import com.hotel.controllers.NQuartos;

import javax.swing.*;
import java.awt.*;

public class Inicial extends JFrame{
    private JLabel titulo; //declaração de todos os objetos
    private JButton btnI, btnC, btnEd, btnEx, btnS;
    private int x;

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

        btnI.addActionListener((actionEvent) -> { //ação do btnI
            this.dispose(); //fecha a tela
            Insert.reset(); //Limpa a tela
            Main.telaI.setVisible(true); //Abre a tela de inserir
        });

        btnC.addActionListener((actionEvent) -> { //ação do btnC
            this.dispose(); //fecha a tela
            Consulta1.reset(); //limpa a tela
            x = NQuartos.nquartos(2); //preenche a combobox da pag
            if (x == 1){
            Main.telaC1.setVisible(true); //abre a tela de consulta
            } else {
                Main.telaP.setVisible(true); //abre a tela
                Main.telaP.setSize(300, 200); //define o tamanho
            }
        });

        btnEd.addActionListener((actionEvent) -> { //ação do btnEd
            this.dispose(); //fecha a tela
            Edit.reset(); //limpa a tela
            x = NQuartos.nquartos(1); //preenche a combobox da pag
            if (x == 1){
            Main.telaEd.setVisible(true); //abre a tela de Edição
            } else {
                Main.telaP.setVisible(true); //abre a tela
                Main.telaP.setSize(300, 200); //define o tamanho
            }
        });

        btnEx.addActionListener((actionEvent) -> { //ação do btnEx
            this.dispose(); //fecha a tela
            Excluir.reset(); //limpa a tela
            x = NQuartos.nquartos(3); //preenche a combobox da pag
            if (x == 1){
            Main.telaEx.setVisible(true); //abre a tela de exclusão
            Main.telaEx.setSize(200, 150); //define o tamanho
            } else {
                Main.telaP.setVisible(true); //abre a tela
                Main.telaP.setSize(300, 200); //define o tamanho
            }
        });

        btnS.addActionListener((actionEvent) -> { //ação do btnS
            System.exit(0); //fecha o programa
        });
    }
}
