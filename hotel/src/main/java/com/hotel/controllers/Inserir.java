package com.hotel.controllers;

import javax.swing.*;
import java.sql.*;

public class Inserir {

    public static int inserir(JTextField fieldq, JTextField fielda, JTextField fieldcpf, JCheckBox checkV, JCheckBox checkM, JCheckBox checkF, JCheckBox checkT,JRadioButton radio1, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        String nq = fieldq.getText();
        String ac = fielda.getText();
        String cpf = fieldcpf.getText();

        if (nq.isEmpty() || ac.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos");
            return 0;
        }

        if (cpf.isEmpty() && radio1.isSelected()){
            JOptionPane.showMessageDialog(frame,"Insira o CPF da reserva no caso de ocupado");
            return 0;
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String checkQuery = "SELECT COUNT(*) FROM quartos WHERE N_Quarto = ?";
            try (PreparedStatement check = con.prepareStatement(checkQuery)) {
                int quarto = Integer.parseInt(nq);
                check.setInt(1, quarto);
                
                try (ResultSet rs = check.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(frame, "Quarto já existe");
                        return 0;
                    }
                }
            }
            
            String query = "INSERT INTO quartos (N_Quarto, acomoda, varanda, microondas, frigobar, tv, cpf, ocupado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement a = con.prepareStatement(query)) {
                int quarto = Integer.parseInt(nq);
                int acomoda = Integer.parseInt(ac);
                int varanda = checkV.isSelected() ? 1 : 0;
                int microondas = checkM.isSelected() ? 1 : 0;
                int frigobar = checkF.isSelected() ? 1 : 0;
                int tv = checkT.isSelected() ? 1 : 0;
                int ocupado = radio1.isSelected() ? 1 : 0;

                a.setInt(1, quarto);
                a.setInt(2, acomoda);
                a.setInt(3, varanda);
                a.setInt(4, microondas);
                a.setInt(5, frigobar);
                a.setInt(6, tv);
                a.setString(7, cpf);
                a.setInt(8, ocupado);

                a.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Inserido com sucesso");
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}