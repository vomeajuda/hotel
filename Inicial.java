import javax.swing.*;
import java.awt.*;

public class Inicial extends JFrame{
    private JLabel titulo;
    private JButton btnI, btnC, btnEd, btnEx;

    public Inicial(){
        super("Inicio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        titulo = new JLabel("Bem-Vindo");
        btnI = new JButton("Inserir");
        btnC = new JButton("Consultar");
        btnEd = new JButton("Editar");
        btnEx = new JButton("Excluir");

        Container janela;
        janela = getContentPane();
        janela.setLayout(new GridLayout(5, 1));

        janela.add(titulo);
        janela.add(btnI);
        janela.add(btnC);
        janela.add(btnEd);
        janela.add(btnEx);

        btnI.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaI.setVisible(true);
        });

        btnC.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaC1.setVisible(true);
            Main.telaC1.setSize(300, 150);
        });

        btnEd.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaEd.setVisible(true);
        });

        btnEx.addActionListener((actionEvent) -> {
            this.dispose();
            Main.telaEx.setVisible(true);
            Main.telaEx.setSize(200, 150);
        });
    }
}
