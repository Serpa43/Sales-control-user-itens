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
import javax.swing.JOptionPane;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class Cliente implements DAOCliente{
    String Nome;
    String Data_nasc;
    String Endereco;
    String Telefone;
    String Email;
    Vendas vend;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getData_nasc() {
        return Data_nasc;
    }

    public void setData_nasc(String Data_nasc) {
        this.Data_nasc = Data_nasc;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
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
    public void salvarBD(Cliente cli) {
        try {
            ConexaoBD conect = new ConexaoBD();
            Connection connection = conect.Conexao_banco();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Clientes(Nome, Data_nasc, Endereco, Telefone, Email) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, cli.getNome());
            statement.setDate(2, java.sql.Date.valueOf(cli.getData_nasc()));
            statement.setString(3, cli.getEndereco());
            statement.setString(4, cli.getTelefone());
            statement.setString(5, cli.getEmail());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void salvarLocal(String Nome, String Data_nasc, String Endereco, String Telefone, String Email) {
        setNome(Nome);
        setData_nasc(Data_nasc);
        setEndereco(Endereco);
        setTelefone(Telefone);
        setEmail(Email);
    }
    
    
}
