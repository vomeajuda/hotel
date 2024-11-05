package com.hotel.views;
import com.hotel.Main;
import com.hotel.controllers.Consultar;
import com.hotel.controllers.Editar;
import com.hotel.models.Quarto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Edit extends JFrame{
    private static JLabel labelq, labelcpf, labela, labelo; //declaração de todos os objetos
    @SuppressWarnings("rawtypes")
    private static JComboBox combo;
    private static JTextField fielda;
    private static JTextField fieldcpf;
    private static JCheckBox checkV, checkM, checkF, checkT;
    private static JRadioButton radio1, radio2;
    private static ButtonGroup grupo;
    private static JButton btnE, btnV, btnC;
    private static JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
    int nqo;

    public Edit(){
        super("Editar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel1 = new JPanel(); //criação de painel
        panel1.setLayout(new GridLayout(3, 1)); //configuração de layout do painel
        panel1.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labelq = new JLabel("N° do Quarto"); //criação da label
        combo = new JComboBox<>(); //criação de um field
        btnC = new JButton("Consultar"); //criação de um botão

        panel1.add(labelq); //adição da label
        panel1.add(combo); //adição do field
        panel1.add(btnC);

        panel2 = new JPanel(); //criação de painel
        panel2.setLayout(new GridLayout(2, 1)); //configuração de layout do painel
        panel2.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        labela = new JLabel("Acomoda (n° pessoas)"); //criação da label
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
        panel8.setLayout(new GridLayout(4, 1)); //configuração de layout do painel
        panel8.setBorder(new EmptyBorder(1, 1, 1, 1)); //configuração da borda do painel (tipo um padding)

        checkV = new JCheckBox("Varanda"); //criação de uma checkBox
        checkM = new JCheckBox("Micro-Ondas"); //criação de uma checkBox
        checkF = new JCheckBox("Frigobar"); //criação de uma checkBox
        checkT = new JCheckBox("Televisão"); //criação de uma checkBox

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
        reset();

        btnC.addActionListener((actionEvent) -> {
            try{
            nqo = Integer.parseInt(combo.getSelectedItem().toString());
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Por favor, preencha o campo");
            }
            Quarto q1 = new Quarto();
            try{
                q1 = new Quarto(Integer.parseInt(combo.getSelectedItem().toString()=="" ? "0" : combo.getSelectedItem().toString()));
                Consultar.consultar(q1, this);
            }catch(Exception e){
                
            }
        });

        btnE.addActionListener((actionEvent) -> {
            Quarto q2 = new Quarto();
            int x;
            try{
            q2 = new Quarto(Integer.parseInt(combo.getSelectedItem().toString()), Integer.parseInt(fielda.getText()), fieldcpf.getText(), checkV.isSelected(), checkM.isSelected(), checkF.isSelected(), checkT.isSelected(), radio1.isSelected());
            x = Editar.editar(q2, nqo, this);
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos");
                x = 0;
            }
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

    public static void alterar(Quarto q3){
        fielda.setText(String.valueOf(q3.getAcomoda()));
        fieldcpf.setText(q3.getCPF());
        checkV.setSelected(q3.getVarandac());
        checkM.setSelected(q3.getMicroondasc());
        checkF.setSelected(q3.getFrigobarc());
        checkT.setSelected(q3.getTvc());
        if (q3.getOcupadoc() == true){
            radio1.setSelected(true);
            radio2.setSelected(false);
        }else{
            radio1.setSelected(false);
            radio2.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    public static void fill(Quarto q4){
        combo.addItem(q4.getQuartoc());
    }

    public static void reset(){
        fielda.setText("");
        fieldcpf.setText("");
        checkV.setSelected(false);
        checkM.setSelected(false);
        checkF.setSelected(false);
        checkT.setSelected(false);
    }
}