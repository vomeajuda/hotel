package com.hotel.views;
import com.hotel.controllers.*;
import com.hotel.models.Quarto;
import com.hotel.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Excluir extends JFrame{
    @SuppressWarnings("rawtypes")
    private static JComboBox combo; //declaração de todos os objetos
        private JLabel label;
        private JButton btnE, btnV;
        private JPanel panel;
    
        public Excluir(){
            super("Excluir");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    
            label = new JLabel("N° Quarto"); //criação da label
            combo = new JComboBox<>(); //criação de um field
    
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
            janela.add(combo, BorderLayout.CENTER); //adição de um field
            janela.add(panel, BorderLayout.SOUTH); //adição de painel
    
            btnE.addActionListener((actionEvent) -> { //ação do btnE
                int x;
                Quarto q = new Quarto(); //Roda o construtor de quarto
                try{
                q = new Quarto(Integer.parseInt(combo.getSelectedItem().toString())); //Roda o construtor de quarto com informações
                }catch (Exception e){
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos");
                    x = 0;
                }
                x = Delete.delete(q, this); //deleta o quarto selecionado
                if (x == 1){
                this.dispose(); //fecha a tela
                Main.telaP.setVisible(true); //carrega a tela principal
                }
            });
    
            btnV.addActionListener((actionEvent) -> { //ação do btnV
                this.dispose(); //fecha a tela
                Main.telaP.setVisible(true); //carrega a tela principal
            });
        }
    
        @SuppressWarnings("unchecked")
        public static void fill(Quarto q1){ //preenche a combobox de quartos
            combo.addItem(q1.getQuartoc());
        }

        public static void reset(){ //remove os quartos da combobox
            combo.removeAllItems();
        }
}