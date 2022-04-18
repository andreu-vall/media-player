package vista;

import controlador.Constants;
import controlador.Controlador;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que representa la visualització de la biblioteca
 * 
 * @author Andreu Vall i Rioduane Zaim
 */
public class Biblioteca extends JDialog {
    
    private Controlador controlador;
    private DefaultTableModel defaultTableModel, albumDefaultTableModel;
    private String album;

    /**
     * Crea la biblioteca
     * 
     * @param parent finestra pare
     * @param controlador controlador
     * @param album àlbum
     * @param albumDefaultTableModel taula àlbum
     */
    public Biblioteca(Window parent, Controlador controlador, String album, DefaultTableModel albumDefaultTableModel) {
        super(parent);
        this.controlador = controlador;
        this.album = album;
        this.albumDefaultTableModel = albumDefaultTableModel;
        defaultTableModel = Controlador.getDefaultTableModel(controlador.getBiblioteca());
        initComponents();
        for (int i = 0; i < Constants.MIDES.length; i++)
            jTable.getColumnModel().getColumn(i).setPreferredWidth(Constants.MIDES[i]);
        if (album == null) {
            super.setLocationRelativeTo(parent);
            jButtonAfegeixAlbum.setVisible(false);
            jSeparator.setVisible(false);
        }
        else
            super.setLocation(parent.getX() + 120, parent.getY() + 50);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jToolBar = new javax.swing.JToolBar();
        jButtonAfegeixAlbum = new javax.swing.JButton();
        jSeparator = new javax.swing.JToolBar.Separator();
        jButtonAfegeixBiblioteca = new javax.swing.JButton();
        jButtonElimina = new javax.swing.JButton();
        jButtonReprodueix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Biblioteca");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(1200, 512));

        jTable.setModel(defaultTableModel);
        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(jTable);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        jToolBar.setRollover(true);

        jButtonAfegeixAlbum.setText("Afegeix a l'àlbum");
        jButtonAfegeixAlbum.setToolTipText("Afegeix el fitxer seleccionat a l'àlbum");
        jButtonAfegeixAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfegeixAlbumActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonAfegeixAlbum);
        jToolBar.add(jSeparator);

        jButtonAfegeixBiblioteca.setText("Afegeix a la Biblioteca");
        jButtonAfegeixBiblioteca.setToolTipText("Afegeix un fitxer a la biblioteca");
        jButtonAfegeixBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfegeixBibliotecaActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonAfegeixBiblioteca);

        jButtonElimina.setText("Elimina");
        jButtonElimina.setToolTipText("Elimina el fitxer seleccionat");
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

    private void jButtonAfegeixBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfegeixBibliotecaActionPerformed
        new AfegirFitxer(this, controlador, defaultTableModel).setVisible(true);
    }//GEN-LAST:event_jButtonAfegeixBibliotecaActionPerformed

    private void jButtonEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaActionPerformed
        try {
            controlador.esborrarFitxer(jTable.getSelectedRow());
            defaultTableModel.removeRow(jTable.getSelectedRow());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonEliminaActionPerformed

    private void jButtonReprodueixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReprodueixActionPerformed
        try {
            controlador.reprodueixFitxer(controlador.getFileAt(jTable.getSelectedRow()));
            super.dispose();
            if (album != null) {
                super.getOwner().dispose();
                super.getOwner().getOwner().dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonReprodueixActionPerformed

    private void jButtonAfegeixAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfegeixAlbumActionPerformed
        try {
            controlador.afegirFitxer(album, jTable.getSelectedRow());
            albumDefaultTableModel.addRow(Controlador.getValues(controlador.getFileAt(jTable.getSelectedRow())));
        } catch (Exception ex) { }
    }//GEN-LAST:event_jButtonAfegeixAlbumActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAfegeixAlbum;
    private javax.swing.JButton jButtonAfegeixBiblioteca;
    private javax.swing.JButton jButtonElimina;
    private javax.swing.JButton jButtonReprodueix;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JToolBar.Separator jSeparator;
    private javax.swing.JTable jTable;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
