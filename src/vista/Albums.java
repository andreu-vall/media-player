package vista;

import controlador.Controlador;

import java.awt.Window;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Classe que representa la finestra per visualitzar el llista d'àlbums
 * 
 * @author Andreu Vall i Rioduane Zaim
 */
public class Albums extends JDialog {
    
    private Controlador controlador;
    private DefaultListModel<String> defaultListModel;

    /**
     * Crea la finestrea
     * 
     * @param parent finestra pare
     * @param controlador controlador
     */
    public Albums(Window parent, Controlador controlador) {
        super(parent);
        this.controlador = controlador;
        initDefaultListModel();
        initComponents();
        super.setLocation(parent.getX() + 25, parent.getY() + 75);
    }
    
    private void initDefaultListModel() {
        defaultListModel = new DefaultListModel<>();
        controlador.getLlistatAlbums().forEach((element) -> {
            defaultListModel.addElement(element);
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jToolBarAccions = new javax.swing.JToolBar();
        jButtonCrea = new javax.swing.JButton();
        jButtonEdita = new javax.swing.JButton();
        jButtonElimina = new javax.swing.JButton();
        jButtonReprodueix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Àlbums");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(854, 480));

        jList.setModel(defaultListModel);
        jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(jList);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        jToolBarAccions.setRollover(true);

        jButtonCrea.setText("Crea");
        jButtonCrea.setToolTipText("Crea un nou àlbum");
        jButtonCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreaActionPerformed(evt);
            }
        });
        jToolBarAccions.add(jButtonCrea);

        jButtonEdita.setText("Edita");
        jButtonEdita.setToolTipText("Edita l'àlbum seleccionat");
        jButtonEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditaActionPerformed(evt);
            }
        });
        jToolBarAccions.add(jButtonEdita);

        jButtonElimina.setText("Elimina");
        jButtonElimina.setToolTipText("Elimina els àlbums seleccionats");
        jButtonElimina.setFocusable(false);
        jButtonElimina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonElimina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminaActionPerformed(evt);
            }
        });
        jToolBarAccions.add(jButtonElimina);

        jButtonReprodueix.setText("Reprodueix");
        jButtonReprodueix.setToolTipText("Reprodueix els fitxers de l'àlbum seleccionat");
        jButtonReprodueix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReprodueixActionPerformed(evt);
            }
        });
        jToolBarAccions.add(jButtonReprodueix);

        getContentPane().add(jToolBarAccions, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreaActionPerformed
        String album = JOptionPane.showInputDialog(this, "Introdueix el nom del nou àlbum:");
        try {
            controlador.afegirAlbum(album);
            defaultListModel.addElement(album);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonCreaActionPerformed

    private void jButtonEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditaActionPerformed
        if (jList.getSelectedIndex() != -1)
            new Album(this, controlador, jList.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_jButtonEditaActionPerformed

    private void jButtonEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaActionPerformed
        try {
            controlador.esborrarAlbum(jList.getSelectedValue());
            defaultListModel.remove(jList.getSelectedIndex());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonEliminaActionPerformed

    private void jButtonReprodueixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReprodueixActionPerformed
        try {
            controlador.reproduirCarpeta(controlador.getAlbum(jList.getSelectedValue()));
            super.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonReprodueixActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrea;
    private javax.swing.JButton jButtonEdita;
    private javax.swing.JButton jButtonElimina;
    private javax.swing.JButton jButtonReprodueix;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JToolBar jToolBarAccions;
    // End of variables declaration//GEN-END:variables
}
