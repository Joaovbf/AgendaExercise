/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import modelo.*;
import bll.AgendaBL;

/**
 *
 * @author joao
 */
public class InicioUI extends javax.swing.JFrame {

    private Agenda agenda;
    
    /**
     * Creates new form InicioUI
     */
    public InicioUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaItens = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnInfo = new javax.swing.JButton();
        btnNovoEvento = new javax.swing.JButton();
        btnNovaMeta = new javax.swing.JButton();
        btnNovoLembrete = new javax.swing.JButton();
        btnFlush = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        listaItens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaItens);

        jLabel1.setText("Itens da Agenda");

        btnInfo.setText("Info");
        btnInfo.setToolTipText("Clique duas vezes sobre um item para ver os detalhes e poder altera-lá");
        btnInfo.setName(""); // NOI18N
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        btnNovoEvento.setText("Criar Novo Evento");
        btnNovoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoEventoActionPerformed(evt);
            }
        });

        btnNovaMeta.setText("Criar Nova Meta");
        btnNovaMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaMetaActionPerformed(evt);
            }
        });

        btnNovoLembrete.setText("Criar Novo Lembrete");

        btnFlush.setText("Apagar Agenda");
        btnFlush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlushActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFlush, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNovoEvento)
                                    .addComponent(btnNovaMeta)
                                    .addComponent(btnNovoLembrete))
                                .addGap(4, 4, 4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovoEvento)
                        .addGap(18, 18, 18)
                        .addComponent(btnNovaMeta)
                        .addGap(18, 18, 18)
                        .addComponent(btnNovoLembrete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(btnFlush)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        JOptionPane.showMessageDialog(null, ((JButton)evt.getSource()).getToolTipText());
    }//GEN-LAST:event_btnInfoActionPerformed

    private void listaItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaItensMouseClicked
        if (evt.getClickCount() == 2) {
            ItemAgenda item = (ItemAgenda)((JList)evt.getSource()).getSelectedValue();
            System.out.print(item.toString());
        }
    }//GEN-LAST:event_listaItensMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.agenda = AgendaBL.carregarAgenda();
        
        this.listaItens.setListData(this.agenda.getItens());
    }//GEN-LAST:event_formWindowOpened

    private void btnNovoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoEventoActionPerformed
        AgendaBL.cadastrarEvento(this.agenda);
        this.listaItens.setListData(this.agenda.getItens());
    }//GEN-LAST:event_btnNovoEventoActionPerformed

    private void btnNovaMetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaMetaActionPerformed
        AgendaBL.cadastrarMeta(this.agenda);
        this.listaItens.setListData(this.agenda.getItens());
    }//GEN-LAST:event_btnNovaMetaActionPerformed

    private void btnFlushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlushActionPerformed
        agenda = new Agenda();
        agenda.gravar();
        this.listaItens.setListData(this.agenda.getItens());
    }//GEN-LAST:event_btnFlushActionPerformed

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
            java.util.logging.Logger.getLogger(InicioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFlush;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovaMeta;
    private javax.swing.JButton btnNovoEvento;
    private javax.swing.JButton btnNovoLembrete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaItens;
    // End of variables declaration//GEN-END:variables
}
