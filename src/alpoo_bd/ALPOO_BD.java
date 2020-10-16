/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpoo_bd;

import Frames.FR_Inicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class ALPOO_BD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FR_Inicio frame = new FR_Inicio();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
}
