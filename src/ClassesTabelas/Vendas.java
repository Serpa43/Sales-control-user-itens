/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesTabelas;

import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import DAO.DAOCliente;
import DAO.DAOVendas;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class Vendas implements DAOVendas{
    String Data_vendas;
    String Hora;
    Double Total;
    Itens item;
    int ID_cli;

    public String getData_vendas() {
        return Data_vendas;
    }

    public void setData_vendas(String Data_vendas) {
        this.Data_vendas = Data_vendas;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public Double getTotal() {
        return Total;
    }

    public int getCliente() {
        return ID_cli;
    }

    public void setCliente(int cliente) {
        this.ID_cli = cliente;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    @Override
    public void SalvarBD(Vendas venda) {
        try {
            ConexaoBD conect = new ConexaoBD();
            Connection connection = conect.Conexao_banco();            
            
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Vendas(Data_vend, Hora, Total, ID_cli) VALUES (?, ?, ?, ?)");
            statement.setDate(1, Date.valueOf(venda.getData_vendas()));
            statement.setTime(2, Time.valueOf(venda.getHora()));
            statement.setDouble(3, venda.getTotal());
            statement.setInt(4, venda.getCliente());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void salvarLocal(String data_vend, String hora, Double Total, int id_cli) {
        setData_vendas(data_vend);
        setHora(hora);
        setTotal(Total);
        setCliente(id_cli);
    }
}
