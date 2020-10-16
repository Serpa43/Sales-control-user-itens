/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesTabelas;

import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DAO.DAOProdutos;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class Produtos implements DAOProdutos{
    double Preco_venda;
    String Descricao;
    String Data_validade;
    double Preco_custo;
    int Estoque;
    int distribuidores;
    int itens;

    public double getPreco_venda() {
        return Preco_venda;
    }

    public void setPreco_venda(double Preco_venda) {
        this.Preco_venda = Preco_venda;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getData_validade() {
        return Data_validade;
    }

    public void setData_validade(String Data_validade) {
        this.Data_validade = Data_validade;
    }

    public double getPreco_custo() {
        return Preco_custo;
    }

    public void setPreco_custo(double Preco_custo) {
        this.Preco_custo = Preco_custo;
    }

    public int getDistribuidores() {
        return distribuidores;
    }

    public void setDistribuidores(int distribuidores) {
        this.distribuidores = distribuidores;
    }

    public int getItens() {
        return itens;
    }

    public void setItens(int itens) {
        this.itens = itens;
    }

    public int getEstoque() {
        return Estoque;
    }

    public void setEstoque(int Estoque) {
        this.Estoque = Estoque;
    }

    @Override
    public void SalvarBD(Produtos prod) {
        try {
            ConexaoBD conect = new ConexaoBD();
            Connection connection = conect.Conexao_banco();
            
            Statement sta = connection.createStatement();
            String str = "Select * from Distribuidores where ID_dist = '" + prod.getDistribuidores() +"'";
            ResultSet ID_prod = sta.executeQuery(str);
            ID_prod.next();
            
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Produtos(Preco_venda, Descricao, Data_validade, Preco_custo, Estoque, ID_itens, ID_dist) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setDouble(1, prod.getPreco_venda());
            statement.setString(2, prod.getDescricao());
            statement.setDate(3, java.sql.Date.valueOf(prod.getData_validade()));
            statement.setDouble(4, prod.getPreco_custo());
            statement.setInt(5, prod.getEstoque());
            statement.setInt(6, prod.getItens());
            statement.setInt(7, ID_prod.getInt("ID_dist"));
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void salvarLocal(double preco_venda, String descricao, String data_validade, double preco_custo, int estoque, int ID_item, int distribuidor) {
        setData_validade(data_validade);
        setDescricao(descricao);
        setEstoque(estoque);
        setPreco_custo(preco_custo);
        setPreco_venda(preco_venda);
        setDistribuidores(distribuidor);
        setItens(ID_item);
    }
    
}
