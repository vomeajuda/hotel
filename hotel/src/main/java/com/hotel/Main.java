package com.hotel;

import com.hotel.views.*;

public class Main{
    public static Insert telaI = new Insert(); //Carrega a tela de insert
    public static Edit telaEd = new Edit(); //Carrega a tela de edição
    public static Inicial telaP = new Inicial(); //Carrega a tela principal
    public static Excluir telaEx = new Excluir(); //Carrega a tela de excluir
    public static Consulta1 telaC1 = new Consulta1(); //Carrega a tela de consulta
    public static void main(String[] args) {
        telaP.setVisible(true); //abre a tela
        telaP.setSize(300, 200); //define o tamanho
    }
}