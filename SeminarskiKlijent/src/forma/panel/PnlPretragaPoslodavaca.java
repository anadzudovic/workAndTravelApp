/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.panel;

import domen.Grad;
import domen.Poslodavac;
import domen.Student;
import forma.FrmDialog;
import forma.FrmForma;
import forma.IPanel;
import forma.ModForme;

import forma.model.ModelTabelePoslodavac;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class PnlPretragaPoslodavaca extends javax.swing.JPanel implements IPanel{

    ModelTabelePoslodavac model;

    /**
     * Creates new form PretragaPoslodavaca
     */
    public PnlPretragaPoslodavaca() {
        initComponents();
        pripremiFormu();
        btnIzbor.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNaziv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPoslodavci = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPronadji = new javax.swing.JButton();
        btnPrikaz = new javax.swing.JButton();
        btnKreiranje = new javax.swing.JButton();
        btnIzbor = new javax.swing.JButton();
        cbGrad = new javax.swing.JComboBox<>();
        btnVratiSve = new javax.swing.JButton();

        tblPoslodavci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPoslodavci);

        jLabel1.setText("Naziv kompanije:");

        jLabel2.setText("Grad:");

        btnPronadji.setText("Pronadji");
        btnPronadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiActionPerformed(evt);
            }
        });

        btnPrikaz.setText("Prikazi detalje");
        btnPrikaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikazActionPerformed(evt);
            }
        });

        btnKreiranje.setText("Kreiraj novog");
        btnKreiranje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreiranjeActionPerformed(evt);
            }
        });

        btnIzbor.setText("Izaberi");
        btnIzbor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzborActionPerformed(evt);
            }
        });

        cbGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnVratiSve.setText("Vrati sve");
        btnVratiSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiSveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(cbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(btnPronadji)
                .addGap(28, 28, 28)
                .addComponent(btnVratiSve)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKreiranje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrikaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIzbor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPronadji)
                    .addComponent(btnVratiSve))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKreiranje)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrikaz)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzbor))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPronadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiActionPerformed
        String naziv = txtNaziv.getText();
        Poslodavac p = new Poslodavac();
        if (!naziv.isEmpty()) {
            p.setNazivKompanije(naziv);
        }
        p.setGrad((Grad) cbGrad.getSelectedItem());
        List<Poslodavac> lista;
        try {
            lista = kontroler.Kontroler.getInstanca().vratiPoslodavce(p);
            model = new ModelTabelePoslodavac();
            for (Poslodavac s : lista) {
                System.out.println(s);
                model.ubaci(s);
            }
            tblPoslodavci.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(PnlPretragaStudenata.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnPronadjiActionPerformed

    private void btnVratiSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiSveActionPerformed
        try {
            List<Poslodavac> lista = kontroler.Kontroler.getInstanca().vratiSvePoslodavce();
            model = new ModelTabelePoslodavac();
            for (Poslodavac s : lista) {
                model.ubaci(s);

            }
            tblPoslodavci.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(PnlPretragaStudenata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVratiSveActionPerformed

    private void btnIzborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzborActionPerformed
        int index = tblPoslodavci.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red u tabeli");
            return;
        }
        Poslodavac p = model.getLista().get(index);
        sesija.Sesija.getInstanca().getMapa().put("trenutniPoslodavac", p);
        System.out.println(p);
        (((FrmForma) SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))).getPanel().popuniPodatke();
       ((FrmForma) SwingUtilities.getWindowAncestor(this)).dispose();
        
    }//GEN-LAST:event_btnIzborActionPerformed

    private void btnPrikazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikazActionPerformed
         pripremiDialog(ModForme.pregled);
        
    }//GEN-LAST:event_btnPrikazActionPerformed

    private void btnKreiranjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreiranjeActionPerformed
        pripremiDialog(ModForme.unos);
    }//GEN-LAST:event_btnKreiranjeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzbor;
    private javax.swing.JButton btnKreiranje;
    private javax.swing.JButton btnPrikaz;
    private javax.swing.JButton btnPronadji;
    private javax.swing.JButton btnVratiSve;
    private javax.swing.JComboBox<Object> cbGrad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPoslodavci;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() {
        try {
            ModelTabelePoslodavac model = new ModelTabelePoslodavac();
            tblPoslodavci.setModel(model);
            List<Grad> gradovi = kontroler.Kontroler.getInstanca().vratiSveGradove();
            cbGrad.removeAllItems();
            for (Grad g : gradovi) {
                cbGrad.addItem(g);

            }
        } catch (IOException ex) {
            Logger.getLogger(PnlPretragaPoslodavaca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PnlPretragaPoslodavaca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void izaberi() {
        btnIzbor.setVisible(true);
    }

    private void pripremiDialog(ModForme modForme) {
        if (modForme != ModForme.unos) {
            int index = tblPoslodavci.getSelectedRow();

            if (index == -1) {

                JOptionPane.showMessageDialog(this, "Morate izabrati red!");
                return;
            }
            Poslodavac s = model.getLista().get(index);
            sesija.Sesija.getInstanca().getMapa().put("trenutniPoslodavac",s);
        }
        
        PnlPoslodavac panel = new PnlPoslodavac(modForme);
        FrmDialog dialog= new FrmDialog((Frame) SwingUtilities.getWindowAncestor(this), true, panel);
        dialog.setVisible(true);
    }

    @Override
    public void popuniPodatke() {
        model= (ModelTabelePoslodavac) tblPoslodavci.getModel();
        if(sesija.Sesija.getInstanca().getMapa().get("trenutniPoslodavac")!=null){
        model.ubaci((Poslodavac) sesija.Sesija.getInstanca().getMapa().get("trenutniPoslodavac"));
        }
    }
    
}
