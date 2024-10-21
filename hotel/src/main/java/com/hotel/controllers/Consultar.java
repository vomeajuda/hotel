package com.hotel.controllers;

import javax.swing.*;
import java.sql.*;

public class Consultar {
    public static void consultar(JTextField fieldq, JTextField fielda, JTextField fieldcpf, JCheckBox checkV, JCheckBox checkM, JCheckBox checkF, JCheckBox checkT, JRadioButton radio1, JRadioButton radio2, JFrame frame) {
        String url = "jdbc:mysql://localhost:3306/hotel_ds";
        String user = "root";
        String password = "";

        String n = fieldq.getText();
        if (n.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira o número do quarto.");
            return;
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT acomoda, varanda, microondas, frigobar, tv, cpf, ocupado FROM quartos WHERE N_Quarto = ?";
            try (PreparedStatement a = con.prepareStatement(query)) {
                a.setString(1, n);
                try (ResultSet b = a.executeQuery()) {
                    if (b.next()) {
                        fielda.setText(String.valueOf(b.getInt("acomoda")));
                        fieldcpf.setText(b.getString("cpf"));
                        checkV.setSelected(b.getBoolean("varanda"));
                        checkM.setSelected(b.getBoolean("microondas"));
                        checkF.setSelected(b.getBoolean("frigobar"));
                        checkT.setSelected(b.getBoolean("tv"));
                        boolean ocupado = b.getBoolean("ocupado");
                        if (ocupado) {
                            radio1.setSelected(true);
                        } else {
                            radio2.setSelected(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Nenhum quarto encontrado com este número");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}