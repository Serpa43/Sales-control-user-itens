/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import ClassesTabelas.Cliente;
import ClassesTabelas.Vendas;
import ConexaoBD.ConexaoBD;
import DAO.DAOVendas;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class FR_Venda extends javax.swing.JFrame {

    /**
     * Creates new form FR_Venda
     */
    public FR_Venda() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private Boolean ValidacaoVazio(){
        if(JFT_data_venda.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Data da venda vazio", "Novo Cliente", WIDTH);
            return false;
        }else if(JFT_hora.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hora vazio", "Novo Cliente", WIDTH);
            return false;
        }else if(JT_total.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Total vazio", "Novo Cliente", WIDTH);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_titulo = new javax.swing.JLabel();
        JL_data_venda = new javax.swing.JLabel();
        JL_hora = new javax.swing.JLabel();
        JL_total = new javax.swing.JLabel();
        JT_total = new javax.swing.JTextField();
        BTN_voltar = new javax.swing.JButton();
        BTN_salvar = new javax.swing.JButton();
        JL_Nome_cli = new javax.swing.JLabel();
        JC_Nome_cliente = new javax.swing.JComboBox<>();
        JFT_data_venda = new javax.swing.JFormattedTextField();
        JFT_hora = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        JL_titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JL_titulo.setText("Cadastro de vendas");

        JL_data_venda.setText("Data da venda:");

        JL_hora.setText("Hora da venda:");

        JL_total.setText("Total:");

        BTN_voltar.setText("Voltar");
        BTN_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_voltarActionPerformed(evt);
            }
        });

        BTN_salvar.setText("Salvar");
        BTN_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_salvarActionPerformed(evt);
            }
        });

        JL_Nome_cli.setText("Nome do Cliente:");

        try {
            JFT_data_venda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            JFT_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(87, Short.MAX_VALUE)
                        .addComponent(JL_titulo)
                        .addGap(126, 126, 126))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_total)
                                    .addComponent(JL_hora)
                                    .addComponent(JL_data_venda))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JFT_data_venda)
                                    .addComponent(JT_total, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(JFT_hora)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(BTN_voltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_salvar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_Nome_cli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JC_Nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_titulo)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_data_venda)
                    .addComponent(JFT_data_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_hora)
                    .addComponent(JFT_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_total)
                    .addComponent(JT_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nome_cli)
                    .addComponent(JC_Nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_voltar)
                    .addComponent(BTN_salvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_salvarActionPerformed
        if(ValidacaoVazio()){
            String[] separador = JFT_data_venda.getText().split("/");
            String data = separador[2] + "-" + separador[1] + "-" + separador[0];
            System.out.println(separador);
            
            Vendas vend = new Vendas();
            String[] idCli = JC_Nome_cliente.getSelectedItem().toString().split(" ");
            vend.salvarLocal(data, JFT_hora.getText(), Double.parseDouble(JT_total.getText()), Integer.parseInt(idCli[0]));
            
            DAOVendas venda = new Vendas();
            venda.SalvarBD(vend);
            
            FR_Cadastrar cadastro = new FR_Cadastrar();
            cadastro.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_BTN_salvarActionPerformed

    private void BTN_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_voltarActionPerformed
        FR_Cadastrar cadastro = new FR_Cadastrar();
        cadastro.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BTN_voltarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        JC_Nome_cliente.removeAllItems();
        try {
            ConexaoBD conect = new ConexaoBD();
            Connection connection = conect.Conexao_banco();
            
            Statement sta = connection.createStatement();
            String str = "Select * from Clientes";
            ResultSet result = sta.executeQuery(str);
            while(result.next()){
                JC_Nome_cliente.addItem(result.getInt(1)+" - "+result.getString(2));
            }
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Popularização do JCombo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FR_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FR_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FR_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FR_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FR_Venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_salvar;
    private javax.swing.JButton BTN_voltar;
    private javax.swing.JComboBox<String> JC_Nome_cliente;
    private javax.swing.JFormattedTextField JFT_data_venda;
    private javax.swing.JFormattedTextField JFT_hora;
    private javax.swing.JLabel JL_Nome_cli;
    private javax.swing.JLabel JL_data_venda;
    private javax.swing.JLabel JL_hora;
    private javax.swing.JLabel JL_titulo;
    private javax.swing.JLabel JL_total;
    private javax.swing.JTextField JT_total;
    // End of variables declaration//GEN-END:variables
}