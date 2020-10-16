/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesTabelas;

import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DAO.DAOCliente;
import DAO.DAODistribuidores;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class Distribuidores implements DAODistribuidores{
    String Nome;
    String Razao_social;
    String Telefone;
    String Email;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRazao_social() {
        return Razao_social;
    }

    public void setRazao_social(String Razao_social) {
        this.Razao_social = Razao_social;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public void SalvarBD(Distribuidores distri) {
        try {
            ConexaoBD conect = new ConexaoBD();
            Connection connection = conect.Conexao_banco();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Distribuidores(Nome, Razao_social, Telefone, Email) VALUES (?, ?, ?, ?)");
            statement.setString(1, distri.getNome());
            statement.setString(2, distri.getRazao_social());
            statement.setString(3, distri.getTelefone());
            statement.setString(4, distri.getEmail());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrar", JOptionPane.INFORMATION_MESSAGE);
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex.getMessage(), "Cadastrar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void salvarLocal(String Nome, String Razao_social,String Telefone, String Email) {
        setNome(Nome);
        setRazao_social(Razao_social);
        setTelefone(Telefone);
        setEmail(Email);
    }
    
}
