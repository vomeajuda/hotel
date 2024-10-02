import javax.swing.*;
import java.awt.*;

public class Insert extends JFrame{
    private JLabel labelq, labelcpf, labela, labelt;
    private JTextField fieldq, fielda, fieldcpf;
    private JCheckBox checkV, checkM, checkF, checkMic;
    private JRadioButton radio1, radio2;
    private ButtonGroup grupo;
    private JButton btnE, btnV;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;

    public Insert(){
        super("Criação");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        
    }
}