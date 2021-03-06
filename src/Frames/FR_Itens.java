/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import ClassesTabelas.Cliente;
import ClassesTabelas.Itens;
import ConexaoBD.ConexaoBD;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import DAO.DAOCliente;
import DAO.DAOItens;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Erick hayakawa & Lucas Serpa
 */
public class FR_Itens extends javax.swing.JFrame {

    /**
     * Creates new form FR_Itens
     */
    public FR_Itens() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private Boolean ValidacaoVazio(){
        if(JT_quant.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Quantidade vazio", "Novo Cliente", WIDTH);
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
        JL_quant = new javax.swing.JLabel();
        JT_quant = new javax.swing.JTextField();
        BTN_voltar = new javax.swing.JButton();
        BTN_salvar = new javax.swing.JButton();
        JL_sub_total1 = new javax.swing.JLabel();
        JL_sub_total2 = new javax.swing.JLabel();
        JC_nome_prod = new javax.swing.JComboBox<>();
        JC_id_venda = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        JL_titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JL_titulo.setText("Cadastro de itens");

        JL_quant.setText("Quantidade:");

        JT_quant.setText("0");
        JT_quant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JT_quantFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_quantFocusLost(evt);
            }
        });

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

        JL_sub_total1.setText("Data da venda:");

        JL_sub_total2.setText("Nome do produto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JL_titulo)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_sub_total2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JC_nome_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_quant)
                            .addComponent(JL_sub_total1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JT_quant, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(JC_id_venda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTN_voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_salvar)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_titulo)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_quant)
                    .addComponent(JT_quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_sub_total1)
                    .addComponent(JC_id_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_sub_total2)
                    .addComponent(JC_nome_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_voltar)
                    .addComponent(BTN_salvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_salvarActionPerformed
        if(ValidacaoVazio()){
            //populando Local
            Itens item = new Itens();
            String[] ID_prod = JC_nome_prod.getSelectedItem().toString().split(" ");
            String[] ID_vend = JC_id_venda.getSelectedItem().toString().split(" ");
            item.salvarLocal(Integer.parseInt(JT_quant.getText()),Integer.parseInt(ID_vend[0]) , Integer.parseInt(ID_prod[0]));
            //populando BD
            DAOItens daoCliente = new Itens();
            daoCliente.SalvarBD(item);
            
            FR_Cadastrar cadastro = new FR_Cadastrar();
            cadastro.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_BTN_salvarActionPerformed

    private void JT_quantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_quantFocusGained
        if(JT_quant.getText().equals("0")){
            JT_quant.setText("");
        }
    }//GEN-LAST:event_JT_quantFocusGained

    private void JT_quantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_quantFocusLost
        if(JT_quant.getText().isEmpty()){
            JT_quant.setText("0");
        }
    }//GEN-LAST:event_JT_quantFocusLost

    private void BTN_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_voltarActionPerformed
        FR_Cadastrar cadastro = new FR_Cadastrar();
        cadastro.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BTN_voltarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        JC_nome_prod.removeAllItems();
        try {
            ConexaoBD conect = new ConexaoBD();
            Connection connection = conect.Conexao_banco();
            
            Statement sta = connection.createStatement();
            String str = "Select * from Produtos";
            ResultSet result = sta.executeQuery(str);
            while(result.next()){
                JC_nome_prod.addItem(result.getInt(1)+" - "+result.getString(3));
            }
            
            str = "Select * from Vendas";
            result = sta.executeQuery(str);
            while(result.next()){
                String[] separador = result.getString(2).split("-");
                JC_id_venda.addItem(result.getInt(1)+" - "+ separador[2] + "/" + separador[1] + "/" + separador[0]);
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
            java.util.logging.Logger.getLogger(FR_Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FR_Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FR_Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FR_Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FR_Itens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_salvar;
    private javax.swing.JButton BTN_voltar;
    private javax.swing.JComboBox<String> JC_id_venda;
    private javax.swing.JComboBox<String> JC_nome_prod;
    private javax.swing.JLabel JL_quant;
    private javax.swing.JLabel JL_sub_total1;
    private javax.swing.JLabel JL_sub_total2;
    private javax.swing.JLabel JL_titulo;
    private javax.swing.JTextField JT_quant;
    // End of variables declaration//GEN-END:variables
}
