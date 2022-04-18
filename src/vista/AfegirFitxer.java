package vista;

import controlador.Constants;
import controlador.Controlador;

import java.awt.CardLayout;
import java.awt.Window;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que representa la finestra d'obrir un fitxer amb les característiques desitjades
 * 
 * @author Andreu Vall i Rioduane Zaim
 */
public class AfegirFitxer extends javax.swing.JDialog {
    
    private Controlador controlador;
    private DefaultTableModel defaultTableModel;

    /**
     * Crea la finestra
     * 
     * @param parent finestra pare
     * @param controlador controlador
     * @param defaultTableModel taula d'un àlbum per afegir-hi nous fitxers
     */
    public AfegirFitxer(Window parent, Controlador controlador, DefaultTableModel defaultTableModel) {
        super(parent);
        this.controlador = controlador;
        this.defaultTableModel = defaultTableModel;
        initComponents();
        super.setLocationRelativeTo(parent);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupType = new javax.swing.ButtonGroup();
        jPanelType = new javax.swing.JPanel();
        jRadioButtonVideo = new javax.swing.JRadioButton();
        jRadioButtonAudio = new javax.swing.JRadioButton();
        jPanelForm = new javax.swing.JPanel();
        jPanelVideo = new javax.swing.JPanel();
        jLabelCamiVideo = new javax.swing.JLabel();
        jFormattedTextFieldCamiVideo = new javax.swing.JFormattedTextField();
        jButtonNavegaVideo = new javax.swing.JButton();
        jLabelDescripcioVideo = new javax.swing.JLabel();
        jScrollPaneDescripcioVideo = new javax.swing.JScrollPane();
        jTextAreaDescripcioVideo = new javax.swing.JTextArea();
        jLabelCodecVideo = new javax.swing.JLabel();
        jFormattedTextFieldCodecVideo = new javax.swing.JFormattedTextField();
        jLabelDuradaVideo = new javax.swing.JLabel();
        jFormattedTextFieldDuradaVideo = new javax.swing.JFormattedTextField();
        jLabelUnitatDuradaVideo = new javax.swing.JLabel();
        jLabelAmpladaVideo = new javax.swing.JLabel();
        jFormattedTextFieldAmpladaVideo = new javax.swing.JFormattedTextField();
        jLabelUnitatAmpladaVideo = new javax.swing.JLabel();
        jLabelAlturaVideo = new javax.swing.JLabel();
        jFormattedTextFieldAlturaVideo = new javax.swing.JFormattedTextField();
        jLabelUnitatAlturaVideo = new javax.swing.JLabel();
        jLabelFps = new javax.swing.JLabel();
        jFormattedTextFieldFps = new javax.swing.JFormattedTextField();
        jButtonAfegirVideo = new javax.swing.JButton();
        jPanelAudio = new javax.swing.JPanel();
        jLabelCamiAudio = new javax.swing.JLabel();
        jFormattedTextFieldCamiAudio = new javax.swing.JFormattedTextField();
        jButtonNavegaAudio = new javax.swing.JButton();
        jLabelCamiImatge = new javax.swing.JLabel();
        jFormattedTextFieldCamiImatge = new javax.swing.JFormattedTextField();
        jButtonNavegaImatge = new javax.swing.JButton();
        jLabelDescripcioAudio = new javax.swing.JLabel();
        jScrollPaneDescripcioAudio = new javax.swing.JScrollPane();
        jTextAreaDescripcioAudio = new javax.swing.JTextArea();
        jLabelCodecAudio = new javax.swing.JLabel();
        jFormattedTextFieldCodecAudio = new javax.swing.JFormattedTextField();
        jLabelDuradaAudio = new javax.swing.JLabel();
        jFormattedTextFieldDuradaAudio = new javax.swing.JFormattedTextField();
        jLabelUnitatDuradaAudio = new javax.swing.JLabel();
        jLabelKbps = new javax.swing.JLabel();
        jFormattedTextFieldKbps = new javax.swing.JFormattedTextField();
        jButtonAfegirAudio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Afegir Fitxer");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(600, 380));

        buttonGroupType.add(jRadioButtonVideo);
        jRadioButtonVideo.setSelected(true);
        jRadioButtonVideo.setText("Vídeo");
        jRadioButtonVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVideoActionPerformed(evt);
            }
        });
        jPanelType.add(jRadioButtonVideo);

        buttonGroupType.add(jRadioButtonAudio);
        jRadioButtonAudio.setText("Àudio");
        jRadioButtonAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAudioActionPerformed(evt);
            }
        });
        jPanelType.add(jRadioButtonAudio);

        getContentPane().add(jPanelType, java.awt.BorderLayout.PAGE_START);

        jPanelForm.setLayout(new java.awt.CardLayout());

        jPanelVideo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 4));
        java.awt.GridBagLayout jPanelVideoLayout = new java.awt.GridBagLayout();
        jPanelVideoLayout.columnWidths = new int[] {0, 4, 0, 4, 0, 4, 0};
        jPanelVideoLayout.rowHeights = new int[] {0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0};
        jPanelVideo.setLayout(jPanelVideoLayout);

        jLabelCamiVideo.setText("Camí vídeo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelCamiVideo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        jPanelVideo.add(jFormattedTextFieldCamiVideo, gridBagConstraints);

        jButtonNavegaVideo.setText("Navega");
        jButtonNavegaVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNavegaVideoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanelVideo.add(jButtonNavegaVideo, gridBagConstraints);

        jLabelDescripcioVideo.setText("Descripció:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelDescripcioVideo, gridBagConstraints);

        jScrollPaneDescripcioVideo.setMinimumSize(new java.awt.Dimension(166, 96));

        jTextAreaDescripcioVideo.setColumns(20);
        jTextAreaDescripcioVideo.setRows(5);
        jTextAreaDescripcioVideo.setText("Descripció");
        jTextAreaDescripcioVideo.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPaneDescripcioVideo.setViewportView(jTextAreaDescripcioVideo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelVideo.add(jScrollPaneDescripcioVideo, gridBagConstraints);

        jLabelCodecVideo.setText("Còdec:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelCodecVideo, gridBagConstraints);

        jFormattedTextFieldCodecVideo.setText("H.264");
        jFormattedTextFieldCodecVideo.setMinimumSize(new java.awt.Dimension(50, 20));
        jFormattedTextFieldCodecVideo.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelVideo.add(jFormattedTextFieldCodecVideo, gridBagConstraints);

        jLabelDuradaVideo.setText("Durada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelDuradaVideo, gridBagConstraints);

        jFormattedTextFieldDuradaVideo.setText("60");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelVideo.add(jFormattedTextFieldDuradaVideo, gridBagConstraints);

        jLabelUnitatDuradaVideo.setText("segons");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelUnitatDuradaVideo, gridBagConstraints);

        jLabelAmpladaVideo.setText("Amplada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelAmpladaVideo, gridBagConstraints);

        jFormattedTextFieldAmpladaVideo.setText("1280");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelVideo.add(jFormattedTextFieldAmpladaVideo, gridBagConstraints);

        jLabelUnitatAmpladaVideo.setText("píxels");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelUnitatAmpladaVideo, gridBagConstraints);

        jLabelAlturaVideo.setText("Altura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelAlturaVideo, gridBagConstraints);

        jFormattedTextFieldAlturaVideo.setText("720");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelVideo.add(jFormattedTextFieldAlturaVideo, gridBagConstraints);

        jLabelUnitatAlturaVideo.setText("píxels");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelUnitatAlturaVideo, gridBagConstraints);

        jLabelFps.setText("Fps:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelVideo.add(jLabelFps, gridBagConstraints);

        jFormattedTextFieldFps.setText("24");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelVideo.add(jFormattedTextFieldFps, gridBagConstraints);

        jButtonAfegirVideo.setText("Afegir");
        jButtonAfegirVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfegirVideoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        jPanelVideo.add(jButtonAfegirVideo, gridBagConstraints);

        jPanelForm.add(jPanelVideo, "cardVideo");

        jPanelAudio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 4));
        java.awt.GridBagLayout jPanelAudioLayout = new java.awt.GridBagLayout();
        jPanelAudioLayout.columnWidths = new int[] {0, 4, 0, 4, 0, 4, 0};
        jPanelAudioLayout.rowHeights = new int[] {0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0};
        jPanelAudio.setLayout(jPanelAudioLayout);

        jLabelCamiAudio.setText("Camí àudio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelAudio.add(jLabelCamiAudio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        jPanelAudio.add(jFormattedTextFieldCamiAudio, gridBagConstraints);

        jButtonNavegaAudio.setText("Navega");
        jButtonNavegaAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNavegaAudioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanelAudio.add(jButtonNavegaAudio, gridBagConstraints);

        jLabelCamiImatge.setText("Camí imatge:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelAudio.add(jLabelCamiImatge, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelAudio.add(jFormattedTextFieldCamiImatge, gridBagConstraints);

        jButtonNavegaImatge.setText("Navega");
        jButtonNavegaImatge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNavegaImatgeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        jPanelAudio.add(jButtonNavegaImatge, gridBagConstraints);

        jLabelDescripcioAudio.setText("Descripció:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelAudio.add(jLabelDescripcioAudio, gridBagConstraints);

        jScrollPaneDescripcioAudio.setMinimumSize(new java.awt.Dimension(166, 96));

        jTextAreaDescripcioAudio.setColumns(20);
        jTextAreaDescripcioAudio.setRows(5);
        jTextAreaDescripcioAudio.setText("Descripció");
        jTextAreaDescripcioAudio.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPaneDescripcioAudio.setViewportView(jTextAreaDescripcioAudio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelAudio.add(jScrollPaneDescripcioAudio, gridBagConstraints);

        jLabelCodecAudio.setText("Còdec:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelAudio.add(jLabelCodecAudio, gridBagConstraints);

        jFormattedTextFieldCodecAudio.setText("AAC");
        jFormattedTextFieldCodecAudio.setMinimumSize(new java.awt.Dimension(50, 20));
        jFormattedTextFieldCodecAudio.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelAudio.add(jFormattedTextFieldCodecAudio, gridBagConstraints);

        jLabelDuradaAudio.setText("Durada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelAudio.add(jLabelDuradaAudio, gridBagConstraints);

        jFormattedTextFieldDuradaAudio.setText("60");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelAudio.add(jFormattedTextFieldDuradaAudio, gridBagConstraints);

        jLabelUnitatDuradaAudio.setText("segons");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelAudio.add(jLabelUnitatDuradaAudio, gridBagConstraints);

        jLabelKbps.setText("Kbps:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelAudio.add(jLabelKbps, gridBagConstraints);

        jFormattedTextFieldKbps.setText("320");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanelAudio.add(jFormattedTextFieldKbps, gridBagConstraints);

        jButtonAfegirAudio.setText("Afegir");
        jButtonAfegirAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfegirAudioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        jPanelAudio.add(jButtonAfegirAudio, gridBagConstraints);

        jPanelForm.add(jPanelAudio, "cardAudio");

        getContentPane().add(jPanelForm, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVideoActionPerformed
        ((CardLayout)jPanelForm.getLayout()).show(jPanelForm, "cardVideo");
    }//GEN-LAST:event_jRadioButtonVideoActionPerformed

    private void jRadioButtonAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAudioActionPerformed
        ((CardLayout)jPanelForm.getLayout()).show(jPanelForm, "cardAudio");
    }//GEN-LAST:event_jRadioButtonAudioActionPerformed

    private void jButtonNavegaVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNavegaVideoActionPerformed
        navega(Constants.CARPETA_VIDEOS, "video", "Video Filter", jFormattedTextFieldCamiVideo);
    }//GEN-LAST:event_jButtonNavegaVideoActionPerformed

    private void jButtonAfegirVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfegirVideoActionPerformed
        try {
            controlador.afegirVideo(jFormattedTextFieldCamiVideo.getText(), jTextAreaDescripcioVideo.getText(),
                jFormattedTextFieldCodecVideo.getText(), Float.parseFloat(jFormattedTextFieldDuradaVideo.getText()),
                Integer.parseInt(jFormattedTextFieldAmpladaVideo.getText()), Integer.parseInt(jFormattedTextFieldAlturaVideo.getText()),
                Float.parseFloat(jFormattedTextFieldFps.getText()));
            defaultTableModel.addRow(Controlador.getValues(controlador.getFileAt(controlador.getBibliotecaSize() - 1)));
            super.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonAfegirVideoActionPerformed

    private void jButtonNavegaAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNavegaAudioActionPerformed
        navega(Constants.CARPETA_AUDIOS, "aduio", "Audio Filter", jFormattedTextFieldCamiAudio);
    }//GEN-LAST:event_jButtonNavegaAudioActionPerformed

    private void jButtonNavegaImatgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNavegaImatgeActionPerformed
        navega(Constants.CARPETA_IMATGES, "image", "Image Filter", jFormattedTextFieldCamiImatge);
    }//GEN-LAST:event_jButtonNavegaImatgeActionPerformed

    private void jButtonAfegirAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfegirAudioActionPerformed
        try {
            controlador.afegirAudio(jFormattedTextFieldCamiAudio.getText(), jTextAreaDescripcioAudio.getText(),
                jFormattedTextFieldCodecAudio.getText(), Float.parseFloat(jFormattedTextFieldDuradaAudio.getText()),
                new File(jFormattedTextFieldCamiImatge.getText()), Integer.parseInt(jFormattedTextFieldKbps.getText()));
            defaultTableModel.addRow(Controlador.getValues(controlador.getFileAt(controlador.getBibliotecaSize() - 1)));
            super.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonAfegirAudioActionPerformed

    private void navega(String carpetaDefecte, String type, String nomFiltre, JFormattedTextField camp) {
        JFileChooser chooser = new JFileChooser(carpetaDefecte);
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory())
                    return true;
                try {
                    String type = Files.probeContentType(f.toPath());
                    return type != null && type.startsWith(type);
                } catch (IOException ex) {
                    return false;
                }
            }
            @Override
            public String getDescription() {
                return nomFiltre;
            }
        });
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            camp.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupType;
    private javax.swing.JButton jButtonAfegirAudio;
    private javax.swing.JButton jButtonAfegirVideo;
    private javax.swing.JButton jButtonNavegaAudio;
    private javax.swing.JButton jButtonNavegaImatge;
    private javax.swing.JButton jButtonNavegaVideo;
    private javax.swing.JFormattedTextField jFormattedTextFieldAlturaVideo;
    private javax.swing.JFormattedTextField jFormattedTextFieldAmpladaVideo;
    private javax.swing.JFormattedTextField jFormattedTextFieldCamiAudio;
    private javax.swing.JFormattedTextField jFormattedTextFieldCamiImatge;
    private javax.swing.JFormattedTextField jFormattedTextFieldCamiVideo;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodecAudio;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodecVideo;
    private javax.swing.JFormattedTextField jFormattedTextFieldDuradaAudio;
    private javax.swing.JFormattedTextField jFormattedTextFieldDuradaVideo;
    private javax.swing.JFormattedTextField jFormattedTextFieldFps;
    private javax.swing.JFormattedTextField jFormattedTextFieldKbps;
    private javax.swing.JLabel jLabelAlturaVideo;
    private javax.swing.JLabel jLabelAmpladaVideo;
    private javax.swing.JLabel jLabelCamiAudio;
    private javax.swing.JLabel jLabelCamiImatge;
    private javax.swing.JLabel jLabelCamiVideo;
    private javax.swing.JLabel jLabelCodecAudio;
    private javax.swing.JLabel jLabelCodecVideo;
    private javax.swing.JLabel jLabelDescripcioAudio;
    private javax.swing.JLabel jLabelDescripcioVideo;
    private javax.swing.JLabel jLabelDuradaAudio;
    private javax.swing.JLabel jLabelDuradaVideo;
    private javax.swing.JLabel jLabelFps;
    private javax.swing.JLabel jLabelKbps;
    private javax.swing.JLabel jLabelUnitatAlturaVideo;
    private javax.swing.JLabel jLabelUnitatAmpladaVideo;
    private javax.swing.JLabel jLabelUnitatDuradaAudio;
    private javax.swing.JLabel jLabelUnitatDuradaVideo;
    private javax.swing.JPanel jPanelAudio;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelType;
    private javax.swing.JPanel jPanelVideo;
    private javax.swing.JRadioButton jRadioButtonAudio;
    private javax.swing.JRadioButton jRadioButtonVideo;
    private javax.swing.JScrollPane jScrollPaneDescripcioAudio;
    private javax.swing.JScrollPane jScrollPaneDescripcioVideo;
    private javax.swing.JTextArea jTextAreaDescripcioAudio;
    private javax.swing.JTextArea jTextAreaDescripcioVideo;
    // End of variables declaration//GEN-END:variables
}
