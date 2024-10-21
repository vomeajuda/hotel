package com.hotel.controllers;

import javax.swing.*;
import java.sql.*;

public class Editar {
    public static void editar(JTextField fieldq, JTextField fielda, JTextField fieldcpf, JCheckBox checkV, JCheckBox checkM, JCheckBox checkF, JCheckBox checkT, JRadioButton radio1, String nqo, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        String nq = fieldq.getText();
        String acomoda = fielda.getText();
        String cpf = fieldcpf.getText();
        boolean varanda = checkV.isSelected();
        boolean microondas = checkM.isSelected();
        boolean frigobar = checkF.isSelected();
        boolean tv = checkT.isSelected();
        boolean ocupado = radio1.isSelected();

        if (nq.isEmpty() || acomoda.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos");
            return;
        }

        if (!nq.equals(nqo)) {
            JOptionPane.showMessageDialog(frame, "Não altere o número do quarto");
            return;
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE quartos SET acomoda = ?, cpf = ?, varanda = ?, microondas = ?, frigobar = ?, tv = ?, ocupado = ? WHERE N_Quarto = ?";
            try (PreparedStatement a = con.prepareStatement(query)) {
                a.setInt(1, Integer.parseInt(acomoda));
                a.setString(2, cpf);
                a.setBoolean(3, varanda);
                a.setBoolean(4, microondas);
                a.setBoolean(5, frigobar);
                a.setBoolean(6, tv);
                a.setBoolean(7, ocupado);
                a.setString(8, nq);

                a.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Editado com sucesso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
