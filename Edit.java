import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Edit extends JFrame{
    private JLabel labelq, labelcpf, labela, labelt, labelo;
    private JTextField fieldq, fielda, fieldcpf;
    private JCheckBox checkV, checkM, checkF, checkT;
    private JRadioButton radio1, radio2;
    private ButtonGroup grupo;
    private JButton btnE, btnV;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;

    public Edit(){
        super("Editar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setBorder(new EmptyBorder(1, 1, 1, 1));

        labelq = new JLabel("N° Quarto");
        fieldq = new JTextField(20);

        panel1.add(labelq);
        panel1.add(fieldq);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        panel2.setBorder(new EmptyBorder(1, 1, 1, 1));

        labela = new JLabel("Acomoda");
        fielda = new JTextField(20);

        panel2.add(labela);
        panel2.add(fielda);

        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(panel1, BorderLayout.NORTH);
        panel3.add(panel2, BorderLayout.SOUTH);

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(3, 1));
        panel4.setBorder(new EmptyBorder(1, 1, 1, 1));

        labelo = new JLabel("Ocupado");
        radio1 = new JRadioButton("Sim", false);
        radio2 = new JRadioButton("Não", true);

        grupo = new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);

        panel4.add(labelo);
        panel4.add(radio1);
        panel4.add(radio2);

        panel5 = new JPanel();
        panel5.setLayout(new GridLayout(2, 1));
        panel5.setBorder(new EmptyBorder(1, 1, 1, 1));

        labelcpf = new JLabel("CPF");
        fieldcpf = new JTextField(20);

        panel5.add(labelcpf);
        panel5.add(fieldcpf);

        panel6 = new JPanel();
        panel6.setLayout(new BorderLayout());
        panel6.add(panel4, BorderLayout.NORTH);
        panel6.add(panel5, BorderLayout.SOUTH);

        panel7 = new JPanel();
        panel7.setLayout(new BorderLayout());
        panel7.add(panel3, BorderLayout.NORTH);
        panel7.add(panel6, BorderLayout.SOUTH);

        panel8 = new JPanel();
        panel8.setLayout(new GridLayout(5, 1));
        panel8.setBorder(new EmptyBorder(1, 1, 1, 1));

        labelt = new JLabel("Tem");
        checkV = new JCheckBox("Varanda");
        checkM = new JCheckBox("Micro-Ondas");
        checkF = new JCheckBox("Frigobar");
        checkT = new JCheckBox("Televisão");

        panel8.add(labelt);
        panel8.add(checkV);
        panel8.add(checkM);
        panel8.add(checkF);
        panel8.add(checkT);

        panel9 = new JPanel();
        panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel9.setBorder(new EmptyBorder(2, 2, 2, 2));

        btnE = new JButton("Enviar");
        btnV = new JButton("Voltar");
        panel9.add(btnE);
        panel9.add(btnV);

        Container janela;
        janela = getContentPane();
        janela.setLayout(new BorderLayout());

        janela.add(panel7, BorderLayout.WEST);
        janela.add(panel8, BorderLayout.EAST);
        janela.add(panel9, BorderLayout.SOUTH);

        pack();
    }
}