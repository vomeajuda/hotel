package com.hotel.views;
import com.hotel.controllers.*;
import com.hotel.models.Quarto;
import com.hotel.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Insert extends JFrame{
    private JLabel labelq, labelcpf, labela, labelo; //declaração de todos os objetos
    private static JTextField fieldq;
    private static JTextField fielda;
    private static JTextField fieldcpf;
    private static JCheckBox checkV, checkM, checkF, checkT;
    private static JRadioButton radio1, radio2;
    private ButtonGroup grupo;
    private JButton btnE, btnV;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;

    public Insert(){
        super("Criação");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel1 = new JPanel(); //criação de painel
        panel1.setLayout(new GridLayout(2, 1)); //configuração de layout do painel
        panel1.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelq = new JLabel("N° do Quarto"); //criação da label
        fieldq = new JTextField(20); //criação de um field

        panel1.add(labelq);
        panel1.add(fieldq);

        panel2 = new JPanel(); //criação de painel
        panel2.setLayout(new GridLayout(2, 1)); //configuração de layout do painel
        panel2.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labela = new JLabel("Acomoda (n° pessoas)"); //criação da label
        fielda = new JTextField(20); //criação de um field

        panel2.add(labela);
        panel2.add(fielda);

        panel3 = new JPanel(); //criação de painel
        panel3.setLayout(new BorderLayout()); //configuração de layout do painel
        panel3.add(panel1, BorderLayout.NORTH);
        panel3.add(panel2, BorderLayout.SOUTH);

        panel4 = new JPanel(); //criação de painel
        panel4.setLayout(new GridLayout(3, 1)); //configuração de layout do painel
        panel4.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelo = new JLabel("Ocupado"); //criação da label
        radio1 = new JRadioButton("Sim", false); //criação de um radio
        radio2 = new JRadioButton("Não", true); //criação de um radio

        grupo = new ButtonGroup(); //criação de um grupo de radio
        grupo.add(radio1); //criação de um radio
        grupo.add(radio2); //criação de um radio

        panel4.add(labelo); //adição da label
        panel4.add(radio1); //adição de um radio
        panel4.add(radio2); //adição de um radio

        panel5 = new JPanel(); //criação de painel
        panel5.setLayout(new GridLayout(2, 1)); //configuração de layout do painel
        panel5.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelcpf = new JLabel("CPF"); //criação da label
        fieldcpf = new JTextField(20); //adição de um textField

        panel5.add(labelcpf); //adição da label
        panel5.add(fieldcpf); //adição de um textField

        panel6 = new JPanel(); //criação de painel
        panel6.setLayout(new BorderLayout()); //configuração de layout do painel
        panel6.add(panel4, BorderLayout.NORTH);
        panel6.add(panel5, BorderLayout.SOUTH);

        panel7 = new JPanel(); //criação de painel
        panel7.setLayout(new BorderLayout()); //configuração de layout do painel
        panel7.add(panel3, BorderLayout.NORTH);
        panel7.add(panel6, BorderLayout.SOUTH);

        panel8 = new JPanel(); //criação de painel
        panel8.setLayout(new GridLayout(4, 1)); //configuração de layout do painel
        panel8.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        checkV = new JCheckBox("Varanda"); //adição de uma checkBox
        checkM = new JCheckBox("Micro-Ondas"); //adição de uma checkBox
        checkF = new JCheckBox("Frigobar"); //adição de uma checkBox
        checkT = new JCheckBox("Televisão"); //adição de uma checkBox

        panel8.add(checkV); //adição de uma checkBox
        panel8.add(checkM); //adição de uma checkBox
        panel8.add(checkF); //adição de uma checkBox
        panel8.add(checkT); //adição de uma checkBox

        panel9 = new JPanel(); //criação de painel
        panel9.setLayout(new FlowLayout(FlowLayout.CENTER)); //configuração de layout do painel
        panel9.setBorder(new EmptyBorder(2, 2, 2, 2)); //configuração da borda do painel (tipo um padding)

        btnE = new JButton("Enviar"); //criação do botão
        btnV = new JButton("Voltar"); //criação do botão
        panel9.add(btnE); //adição do botão
        panel9.add(btnV); //adição do botão

        Container janela; //criação da janela
        janela = getContentPane();
        janela.setLayout(new BorderLayout()); //layout da janela

        janela.add(panel7, BorderLayout.WEST); //adição de painel
        janela.add(panel8, BorderLayout.EAST); //adição de painel
        janela.add(panel9, BorderLayout.SOUTH); //adição de painel

        reset();
        pack();

        btnE.addActionListener((actionEvent) -> { //ação do btnE
            int x;
            Quarto q = new Quarto(); ////Roda o construtor de quarto
            try{
            q = new Quarto(Integer.parseInt(fieldq.getText()), Integer.parseInt(fielda.getText()), fieldcpf.getText(), checkV.isSelected(), checkM.isSelected(), checkF.isSelected(), checkT.isSelected(), radio1.isSelected()); //Roda o construtor de quarto de instrução
            x = Inserir.inserir(q, this); //Roda a inserção de um quarto
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos");
                x = 0;
            }
            if (x == 1){
            this.dispose(); //fecha a tela
            Main.telaP.setVisible(true); //abre a tela principal
            }
        });

        btnV.addActionListener((actionEvent) -> { //ação do btnV
            this.dispose(); //fecha a tela
            Main.telaP.setVisible(true); //abre a tela principal
        });
    }

    public static void reset(){ //limpa a tela
        fieldq.setText("");
        fielda.setText("");
        fieldcpf.setText("");
        checkV.setSelected(false);
        checkM.setSelected(false);
        checkF.setSelected(false);
        checkT.setSelected(false);
        radio1.setSelected(false);
        radio2.setSelected(true);
    }
}