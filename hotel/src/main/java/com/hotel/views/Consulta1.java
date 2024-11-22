package com.hotel.views;
import com.hotel.controllers.*;
import com.hotel.models.Quarto;
import com.hotel.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Consulta1 extends JFrame{
    @SuppressWarnings("rawtypes")
    private static JComboBox combo; //declaração de todos os objetos
    private JLabel label;
    private JButton btnE, btnV, btnT;
    private JPanel panel, panel2, panel3;
    static String[] colunas = {"N° Quarto", "Acomoda", "Varanda", "Micro-Ondas", "Frigobar", "TV", "CPF", "Ocupado"};
    static DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
    JTable tabela;
    JScrollPane scroll;
    int x;

    public Consulta1(){
        super("Consultar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("N° Quarto"); //criação da label
        combo = new JComboBox<>(); //criação de um field

        panel = new JPanel(); //criação de painel
        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); //configuração de layout do painel
        panel.setBorder(new EmptyBorder(2, 2, 2, 2)); //configuração da borda do painel (tipo um padding)

        btnE = new JButton("Consultar"); //criação do botão
        btnT = new JButton("Todos"); //criação do botão
        btnV = new JButton("Voltar"); //criação do botão
        panel.add(btnE); //adição do botão
        panel.add(btnT); //adição do botão
        panel.add(btnV); //adição do botão

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 1));
        panel3.add(label);
        panel3.add(combo);

        panel2 = new JPanel(); //criação de painel
        panel2.setLayout(new BorderLayout()); //configuração de layout do painel
        panel2.add(panel3, BorderLayout.NORTH); //adição de painel
        panel2.add(panel, BorderLayout.SOUTH); //adição de painel

        JTable tabela = new JTable(modelo); //criação da tabela
        JScrollPane scroll = new JScrollPane(tabela); //criação do scroll

        Container janela; //criação da janela
        janela = getContentPane();
        janela.setLayout(new BorderLayout()); //layout da janela
        janela.add(panel2, BorderLayout.WEST); //adição de painel
        janela.add(scroll, BorderLayout.EAST); //adição do scroll

        pack();

        btnE.addActionListener((actionEvent) -> { //ação do btnE
            modelo.setRowCount(0);
            Quarto q = new Quarto(); //rodando o construtor de quarto
            try{
                q.setQuarto(Integer.parseInt(combo.getSelectedItem().toString())); //rodando o construtor de quarto com informações
                Carregar.carregar(q); //carrega um registro especifico do banco
            }catch (Exception e){
                
            }
        });

        btnT.addActionListener((actionEvent) -> { //ação do btnT
            modelo.setRowCount(0); //volta para a primeira linha da tabela
            Todos.todos(); //carrega todos os registros do banco
        });

        btnV.addActionListener((actionEvent) -> { //ação do btnV
            this.dispose(); //Fecha a tela
            Main.telaP.setVisible(true); // carrega a tela principal
        });
    }

    public static void atualizar(Quarto q1){ //atualiza a tela preenchendo a tabela
        modelo.addRow(q1.getLinha());
    }

    @SuppressWarnings("unchecked")
    public static void fill(Quarto q2){ //preenche a combobox com os quartos
        combo.addItem(q2.getQuartoc());
    }

    public static void reset(){ //limpa a tela
        combo.removeAllItems();
        modelo.setRowCount(0);
    }
}