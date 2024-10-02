import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class Excluir extends JFrame{
    private JTextField campo;
    private JLabel label;
    private JButton btnE, btnV;
    private JPanel panel;

    public Excluir(){
        super("Excluir");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("N° Quarto");
        campo = new JTextField(20);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(new EmptyBorder(2, 2, 2, 2));

        btnE = new JButton("Excluir");
        btnV = new JButton("Voltar");
        panel.add(btnE);
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
