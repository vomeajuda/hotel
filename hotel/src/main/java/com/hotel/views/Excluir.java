package com.hotel.views;
import com.hotel.controllers.*;
import com.hotel.models.Quarto;
import com.hotel.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Excluir extends JFrame{
    private static JTextField campo; //declaração de todos os objetos
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

            reset();
    
            btnE.addActionListener((actionEvent) -> {
                int x;
                Quarto q = new Quarto();
                try{
                q = new Quarto(Integer.parseInt(campo.getText()));
                }catch (Exception e){
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos");
                    x = 0;
                }
                x = Delete.delete(q, this);
                if (x == 1){
                this.dispose();
                Main.telaP.setVisible(true);
                }
            });
    
            btnV.addActionListener((actionEvent) -> {
                this.dispose();
                Main.telaP.setVisible(true);
            });
        }
    
        public static void reset(){
            campo.setText("");
    }
}