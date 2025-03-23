
 package gui;

import services.DepenseService;
import beans.Depense;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DepenseForm extends javax.swing.JInternalFrame {

    private final DepenseService depenseService = new DepenseService();
    private final DefaultTableModel model;

    public DepenseForm() {
        initComponents();
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ListeDepense.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        model = (DefaultTableModel) ListeDepense.getModel(); // Lier le modèle de la JTable
        loadDepense(); // Charger les données dans la table au démarrage
        bnSupprimer.setText("Supprimer");
        bnSupprimer.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        bnSupprimerActionPerformed(evt);
    }
});

    }
    

    //Charger les dépenses dans la JTable
    private void loadDepense() {
        model.setRowCount(0); // Vider la JTable
        List<Depense> depenses = depenseService.findAll();
        for (Depense d : depenses) {
            model.addRow(new Object[]{d.getId(), d.getLibelle(), d.getMontant(), d.getDate()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtlibelle = new javax.swing.JLabel();
        txtmontant = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        bnAjouter = new javax.swing.JButton();
        txtLibelle = new javax.swing.JTextField();
        txtMontant = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        bnSupprimer = new javax.swing.JButton();
        bnUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeDepense = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("gestion des depences"));

        txtlibelle.setText("Libellé :");

        txtmontant.setText("Montant:");

        txtdate.setText("Date:");

        bnAjouter.setText("Ajouter");
        bnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAjouterActionPerformed(evt);
            }
        });

        txtLibelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLibelleActionPerformed(evt);
            }
        });

        txtMontant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontantActionPerformed(evt);
            }
        });

        bnSupprimer.setText("Supprimer");
        bnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnSupprimerActionPerformed(evt);
            }
        });

        bnUpdate.setText("Modifier");
        bnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtlibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmontant, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtmontant, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMontant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des depense"));

        ListeDepense.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " id", "libelle", "mantant", "date"
            }
        ));
        jScrollPane1.setViewportView(ListeDepense);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(834, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = ListeDepense.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "❌ Veuillez sélectionner une dépense à modifier !");
            return;
        }

        try {
            // Récupérer l'ID de la dépense sélectionnée
            int id = (int) model.getValueAt(selectedRow, 0);

            // Vérifier que les champs sont remplis
            String libelle = txtLibelle.getText().trim();
            String montantStr = txtMontant.getText().trim();
            String dateStr = txtDate.getText().trim();

            if (libelle.isEmpty() || montantStr.isEmpty() || dateStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, " Tous les champs sont obligatoires !");
                return;
            }

            // Vérification du montant
            double montant;
            try {
                montant = Double.parseDouble(montantStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Le montant doit être un nombre valide !");
                return;
            }

            // Vérification de la date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = sdf.parse(dateStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, " La date doit être au format yyyy-MM-dd !");
                return;
            }

            // Mettre à jour la dépense
            Depense d = new Depense(id, libelle, montant, date);
            if (depenseService.update(d)) {
                JOptionPane.showMessageDialog(this, "Dépense modifiée avec succès !");
                loadDepense(); // Recharger la table
                clearFields(); // Vider les champs
            } else {
                JOptionPane.showMessageDialog(this, " Erreur lors de la modification !");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage());
        }
    }//GEN-LAST:event_bnUpdateActionPerformed

    private void bnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSupprimerActionPerformed
        // TODO add your handling code here:
        int selectedRow = ListeDepense.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une dépense à supprimer !");
            return;
        }

        int id = (int) model.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette dépense ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        Depense d = depenseService.findById(id);
        if (d != null && depenseService.delete(d)) {
            JOptionPane.showMessageDialog(this, " Dépense supprimée avec succès !");
            loadDepense();
        } else {
            JOptionPane.showMessageDialog(this, " Erreur lors de la suppression !");
        }
    }//GEN-LAST:event_bnSupprimerActionPerformed

    private void txtMontantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontantActionPerformed

    private void txtLibelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLibelleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLibelleActionPerformed

    private void bnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAjouterActionPerformed
        try {
            String libelle = txtLibelle.getText().trim();
            String montantStr = txtMontant.getText().trim();
            String dateString = txtDate.getText().trim();

            if (libelle.isEmpty() || montantStr.isEmpty() || dateString.isEmpty()) {
                JOptionPane.showMessageDialog(this, " Tous les champs sont obligatoires !");
                return;
            }

            double montant;
            try {
                montant = Double.parseDouble(montantStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Le montant doit être un nombre valide !");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = sdf.parse(dateString);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "❌ La date doit être au format yyyy-MM-dd !");
                return;
            }

            Depense depense = new Depense(libelle, montant, date);
            if (depenseService.create(depense)) {
                JOptionPane.showMessageDialog(this, " Dépense ajoutée avec succès !");
                loadDepense();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vérifiez vos données : " + e.getMessage());
        }
    }//GEN-LAST:event_bnAjouterActionPerformed
     // Action du bouton Ajouter
    private void clearFields() {
        txtLibelle.setText("");
        txtMontant.setText("");
        txtDate.setText("");
    }
       

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListeDepense;
    private javax.swing.JButton bnAjouter;
    private javax.swing.JButton bnSupprimer;
    private javax.swing.JButton bnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtLibelle;
    private javax.swing.JTextField txtMontant;
    private javax.swing.JLabel txtdate;
    private javax.swing.JLabel txtlibelle;
    private javax.swing.JLabel txtmontant;
    // End of variables declaration//GEN-END:variables
}
