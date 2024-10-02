import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class Consulta1 extends JFrame{
    private JTextField campo;
    private JLabel label;
    private JButton btnE, btnV, btnT;
    private JPanel panel;

    public Consulta1(){
        super("Consultar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("N° Quarto");
        campo = new JTextField(20);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(new EmptyBorder(2, 2, 2, 2));

        btnE = new JButton("Consultar");
        btnT = new JButton("Todos");
        btnV = new JButton("Voltar");
        panel.add(btnE);
        panel.add(btnT);
        panel.add(btnV);

        Container janela;
        janela = getContentPane();
        janela.setLayout(new BorderLayout());
        janela.add(label, BorderLayout.NORTH);
        janela.add(campo, BorderLayout.CENTER);
        janela.add(panel, BorderLayout.SOUTH);

        btnV.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaP.setVisible(true);
        });
    }
}