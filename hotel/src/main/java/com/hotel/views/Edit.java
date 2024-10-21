package com.hotel.views;
import com.hotel.Main;
import com.hotel.controllers.Consultar;
import com.hotel.controllers.Editar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Edit extends JFrame{
    private JLabel labelq, labelcpf, labela, labelt, labelo; //declaração de todos os objetos
    private JTextField fieldq, fielda, fieldcpf;
    private JCheckBox checkV, checkM, checkF, checkT;
    private JRadioButton radio1, radio2;
    private ButtonGroup grupo;
    private JButton btnE, btnV, btnC;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
    String nqo;

    public Edit(){
        super("Editar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel1 = new JPanel(); //criação de painel
        panel1.setLayout(new GridLayout(3, 1)); //configuração de layout do painel
        panel1.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelq = new JLabel("N° Quarto"); //criação da label
        fieldq = new JTextField(20); //criação de um field
        btnC = new JButton("Consultar"); //criação de um botão

        panel1.add(labelq); //adição da label
        panel1.add(fieldq); //adição do field
        panel1.add(btnC);

        panel2 = new JPanel(); //criação de painel
        panel2.setLayout(new GridLayout(2, 1)); //configuração de layout do painel
        panel2.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labela = new JLabel("Acomoda"); //criação da label
        fielda = new JTextField(20); //criação do field

        panel2.add(labela); //adição da label
        panel2.add(fielda); //adição do field

        panel3 = new JPanel(); //criação de painel
        panel3.setLayout(new BorderLayout()); //configuração de layout do painel
        panel3.add(panel1, BorderLayout.NORTH); //adição de painel
        panel3.add(panel2, BorderLayout.SOUTH); //adição de painel

        panel4 = new JPanel(); //criação de painel
        panel4.setLayout(new GridLayout(3, 1)); //configuração de layout do painel
        panel4.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelo = new JLabel("Ocupado"); //criação da label
        radio1 = new JRadioButton("Sim", false); //criação de um radio
        radio2 = new JRadioButton("Não", true); //criação de um radio

        grupo = new ButtonGroup(); //adição de um grupo
        grupo.add(radio1); //adição de um radio
        grupo.add(radio2); //adição de um radio

        panel4.add(labelo); //adição da label
        panel4.add(radio1); //adição de um radio
        panel4.add(radio2); //adição de um radio

        panel5 = new JPanel(); //criação de painel
        panel5.setLayout(new GridLayout(2, 1)); //configuração de layout do painel
        panel5.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelcpf = new JLabel("CPF"); //criação da label
        fieldcpf = new JTextField(20); //criação do field

        panel5.add(labelcpf); //adição da label
        panel5.add(fieldcpf); //adição do field

        panel6 = new JPanel(); //criação de painel
        panel6.setLayout(new BorderLayout()); //configuração de layout do painel
        panel6.add(panel4, BorderLayout.NORTH); //adição de painel
        panel6.add(panel5, BorderLayout.SOUTH); //adição de painel

        panel7 = new JPanel(); //criação de painel
        panel7.setLayout(new BorderLayout()); //configuração de layout do painel
        panel7.add(panel3, BorderLayout.NORTH); //adição de painel
        panel7.add(panel6, BorderLayout.SOUTH); //adição de painel

        panel8 = new JPanel(); //criação de painel
        panel8.setLayout(new GridLayout(5, 1)); //configuração de layout do painel
        panel8.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelt = new JLabel("Tem"); //criação da label
        checkV = new JCheckBox("Varanda"); //criação de uma checkBox
        checkM = new JCheckBox("Micro-Ondas"); //criação de uma checkBox
        checkF = new JCheckBox("Frigobar"); //criação de uma checkBox
        checkT = new JCheckBox("Televisão"); //criação de uma checkBox

        panel8.add(labelt); //adição da label
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

        pack();

        btnC.addActionListener((actionEvent) -> {
            nqo = fieldq.getText();
            Consultar.consultar(fieldq, fielda, fieldcpf, checkV, checkM, checkF, checkT, radio1, radio2, this);
        });

        btnE.addActionListener((actionEvent) -> {
            Editar.editar(fieldq, fielda, fieldcpf, checkV, checkM, checkF, checkT, radio1, nqo, this);
            this.dispose();
            Main.telaP.setVisible(true);
        });

        btnV.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaP.setVisible(true);
        });
    }
}