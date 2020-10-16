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
import DAO.DAOItens;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class Itens implements DAOItens{
    int Quantidade;
    double Sub_total;
    int produtos;
    int venda;

    public int getProdutos() {
        return produtos;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public double getSub_total() {
        return Sub_total;
    }

    public void setSub_total(double Sub_total) {
        this.Sub_total = Sub_total;
    }

    @Override
    public void SalvarBD(Itens item) {
        
        try {
            ConexaoBD conect = new ConexaoBD();
            Connection connection = conect.Conexao_banco();;
            
            Statement sta = connection.createStatement();
            String str = "Select * from Produtos where ID_prod = '" + item.getProdutos() +"'";
            ResultSet ID_Prod = sta.executeQuery(str);
            ID_Prod.next();
            
            sta = connection.createStatement();
            str = "Select * from Produtos where ID_prod = '" + item.getProdutos() +"'";
            ResultSet Total = sta.executeQuery(str);
            Total.next();
            item.setSub_total(Total.getDouble("Preco_venda") * item.getQuantidade());
            
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Itens_venda(Quantidade, Sub_total, ID_venda, ID_prod) VALUES (?, ?, ?, ?)");
            statement.setInt(1, item.getQuantidade());
            statement.setDouble(2, item.getSub_total());
            statement.setDouble(3, item.getVenda());
            statement.setDouble(4, ID_Prod.getInt("ID_prod"));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage() , "Erro", JOptionPane.INFORMATION_MESSAGE);;
        }
    }

    public void salvarLocal(int quant, int vend, int prod) {
        setQuantidade(quant);
        setProdutos(prod);
        setVenda(vend);
    }
    
}
