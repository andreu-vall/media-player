package vista;

import controlador.Constants;
import controlador.Controlador;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que representa una finestra que mostra la informació d'un àlbum
 * 
 * @author Andreu Vall i Rioduane Zaim
 */
public class Album extends JDialog {
    
    private DefaultTableModel defaultTableModel;
    private Controlador controlador;
    private String album;

    /**
     * Crea la finestra a partir d'un àlbum
     * 
     * @param parent finestra pare
     * @param controlador controlador
     * @param album àlbum
     */
    public Album(Window parent, Controlador controlador, String album) {
        super(parent, album);
        this.controlador = controlador;
        this.album = album;
        try {
            defaultTableModel = Controlador.getDefaultTableModel(controlador.getAlbum(album));
        } catch (Exception ex) { }
        initComponents();
        for (int i = 0; i < Constants.MIDES.length; i++)
            jTable.getColumnModel().getColumn(i).setPreferredWidth(Constants.MIDES[i]);
        super.setLocation(parent.getX() + 50, parent.getY() + 50);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jToolBar = new javax.swing.JToolBar();
        jButtonAfegeix = new javax.swing.JButton();
        jSeparator = new javax.swing.JToolBar.Separator();
        jButtonElimina = new javax.swing.JButton();
        jButtonReprodueix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setPreferredSize(new java.awt.Dimension(1200, 512));

        jTable.setModel(defaultTableModel);
        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(jTable);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        jToolBar.setRollover(true);

        jButtonAfegeix.setText("Afegeix");
        jButtonAfegeix.setToolTipText("Afegeix a l'àlbum el fitxer de la biblioteca seleccionat");
        jButtonAfegeix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfegeixActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonAfegeix);
        jToolBar.add(jSeparator);

        jButtonElimina.setText("Elimina");
        jButtonElimina.setToolTipText("Elimina de làlbum els fitxers seleccionats");
        jButtonElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminaActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonElimina);

        jButtonReprodueix.setText("Reprodueix");
        jButtonReprodueix.setToolTipText("Reprodueix el fitxer seleccionat");
        jButtonReprodueix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReprodueixActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonReprodueix);

        getContentPane().add(jToolBar, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAfegeixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfegeixActionPerformed
        new Biblioteca(this, controlador, album, defaultTableModel).setVisible(true);
    }//GEN-LAST:event_jButtonAfegeixActionPerformed

    private void jButtonEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaActionPerformed
        try {
            controlador.esborrarFitxer(album, jTable.getSelectedRow());
            jTable.removeRowSelectionInterval(jTable.getSelectedRow(), jTable.getSelectedRow() + 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonEliminaActionPerformed

    private void jButtonReprodueixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReprodueixActionPerformed
        try {
            controlador.reprodueixFitxer((String)jTable.getValueAt(jTable.getSelectedRow(), 1));
            super.dispose();
            super.getOwner().dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonReprodueixActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAfegeix;
    private javax.swing.JButton jButtonElimina;
    private javax.swing.JButton jButtonReprodueix;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JToolBar.Separator jSeparator;
    private javax.swing.JTable jTable;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
