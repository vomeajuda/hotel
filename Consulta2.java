import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Consulta2 extends JFrame{
    String[] colunas = {"N° Quarto", "Acomoda", "Varanda", "Micro-Ondas", "Frigobar", "TV", "CPF", "Ocupado"};
    Object[][] dados = {
        {0, 0, "Não", "Não", "Não", "Não", "0", "0"},
    };
    DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
    JTable tabela;
    JScrollPane scroll;
    JButton btnV;

    public Consulta2(){
        super("Consulta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnV = new JButton("Voltar");

        Container janela;
        janela = getContentPane();
        janela.setLayout(new BorderLayout());
        janela.add(scroll, BorderLayout.NORTH);
        janela.add(btnV, BorderLayout.SOUTH);

        pack();

        btnV.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaC1.setVisible(true);
        });
    }
    
}
