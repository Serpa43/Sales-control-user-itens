/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class ConexaoBD {
    
    public Connection Conexao_banco(){
        final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=Loja";
        Connection connection = null;
        try {
            Class.forName(DRIVER); 
            connection = DriverManager.getConnection(DATABASE_URL, "sa", "123");
        } catch (SQLException|ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex.getMessage(), "Cadastrar", JOptionPane.INFORMATION_MESSAGE);
        }
        return connection;
    }
    
}
