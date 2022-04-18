package vista;

import com.sun.glass.events.KeyEvent;

import controlador.Constants;
import controlador.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.metal.MetalSliderUI;

import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;

/**
 * Classe que representa la finestra de reproducció principal
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class ReproductorMultimedia extends JFrame {
    
    private Controlador controlador;
    private EmbeddedMediaPlayerComponent embeddedMediaPlayerComponent;
    private JPanelBackgroundImage jPanelBackgroundImageAudio;
    private Timer timer;
    private Icon iconPlay, iconPause;
    private Action actionDisableFullScreen, actionPlayPause;
    private boolean jSliderProgrammaticChange, manualStop;

    /**
     * Inicia el Reproductor Multimèdia
     */
    public ReproductorMultimedia() {
        initComponents();
        initManualComponents();
        initManualControllers();
        controlador = new Controlador(this);
        super.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuOptions = new javax.swing.JPopupMenu();
        jMenuItemPlayPause = new javax.swing.JMenuItem();
        jCheckBoxMenuItemToggleFullScreen = new javax.swing.JCheckBoxMenuItem();
        jToolBarReproductor = new javax.swing.JToolBar();
        jButtonPlayPause = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jSeparatorBeforeCurrentTime = new javax.swing.JToolBar.Separator();
        jLabelCurrentTime = new javax.swing.JLabel();
        jSeparatorAfterCurrentTime = new javax.swing.JToolBar.Separator();
        jSlider = new JSlider() {
            @Override public void updateUI() {
                super.updateUI();
                setUI(new MetalSliderUI() {
                    @Override protected TrackListener createTrackListener(JSlider slider) {
                        return new TrackListener() {
                            @Override public boolean shouldScroll(int direction) {
                                return false;
                            }
                        };
                    }
                });
            }
        };
        jSeparatorBeforeTotalTime = new javax.swing.JToolBar.Separator();
        jLabelTotalTime = new javax.swing.JLabel();
        jSeparatorAfterTotalTime = new javax.swing.JToolBar.Separator();
        jPanelReproductor = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuBiblioteca = new javax.swing.JMenu();
        jMenuItemEditaBiblioteca = new javax.swing.JMenuItem();
        jMenuItemReprodueixBiblioteca = new javax.swing.JMenuItem();
        jMenuAlbums = new javax.swing.JMenu();
        jMenuItemEditaAlbums = new javax.swing.JMenuItem();
        jMenuTipusReproduccio = new javax.swing.JMenu();
        jCheckBoxMenuItemReproduccioContinua = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemReproduccioAleatoria = new javax.swing.JCheckBoxMenuItem();
        jMenuDades = new javax.swing.JMenu();
        jMenuItemGuardaDades = new javax.swing.JMenuItem();
        jMenuItemCarregaDades = new javax.swing.JMenuItem();

        jMenuItemPlayPause.setText("Play");
        jMenuItemPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPlayPauseActionPerformed(evt);
            }
        });
        jPopupMenuOptions.add(jMenuItemPlayPause);

        jCheckBoxMenuItemToggleFullScreen.setText("FullScreen");
        jCheckBoxMenuItemToggleFullScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemToggleFullScreenActionPerformed(evt);
            }
        });
        jPopupMenuOptions.add(jCheckBoxMenuItemToggleFullScreen);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reproductor Multimèdia");
        setIconImage(new javax.swing.ImageIcon("src/resources/icons/vlc.png").getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButtonPlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/play.png"))); // NOI18N
        jButtonPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayPauseActionPerformed(evt);
            }
        });
        jToolBarReproductor.add(jButtonPlayPause);

        jButtonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/stop.png"))); // NOI18N
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });
        jToolBarReproductor.add(jButtonStop);

        jButtonPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/previous.png"))); // NOI18N
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });
        jToolBarReproductor.add(jButtonPrevious);

        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/next.png"))); // NOI18N
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });
        jToolBarReproductor.add(jButtonNext);
        jToolBarReproductor.add(jSeparatorBeforeCurrentTime);

        jLabelCurrentTime.setText("--.--");
        jToolBarReproductor.add(jLabelCurrentTime);
        jToolBarReproductor.add(jSeparatorAfterCurrentTime);

        jSlider.setMaximum(1000);
        jSlider.setValue(0);
        jToolBarReproductor.add(jSlider);
        jToolBarReproductor.add(jSeparatorBeforeTotalTime);

        jLabelTotalTime.setText("--.--");
        jToolBarReproductor.add(jLabelTotalTime);
        jToolBarReproductor.add(jSeparatorAfterTotalTime);

        getContentPane().add(jToolBarReproductor, java.awt.BorderLayout.SOUTH);

        jPanelReproductor.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanelReproductor, java.awt.BorderLayout.CENTER);

        jMenuBiblioteca.setText("Biblioteca");

        jMenuItemEditaBiblioteca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEditaBiblioteca.setText("Edita la Biblioteca");
        jMenuItemEditaBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditaBibliotecaActionPerformed(evt);
            }
        });
        jMenuBiblioteca.add(jMenuItemEditaBiblioteca);

        jMenuItemReprodueixBiblioteca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemReprodueixBiblioteca.setText("Reprodueix la Biblioteca");
        jMenuItemReprodueixBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReprodueixBibliotecaActionPerformed(evt);
            }
        });
        jMenuBiblioteca.add(jMenuItemReprodueixBiblioteca);

        jMenuBar.add(jMenuBiblioteca);

        jMenuAlbums.setText("Àlbums");

        jMenuItemEditaAlbums.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEditaAlbums.setText("Edita els Àlbums");
        jMenuItemEditaAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditaAlbumsActionPerformed(evt);
            }
        });
        jMenuAlbums.add(jMenuItemEditaAlbums);

        jMenuBar.add(jMenuAlbums);

        jMenuTipusReproduccio.setText("Tipus de Reproducció");

        jCheckBoxMenuItemReproduccioContinua.setText("Reproducció Contínua");
        jCheckBoxMenuItemReproduccioContinua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemReproduccioContinuaActionPerformed(evt);
            }
        });
        jMenuTipusReproduccio.add(jCheckBoxMenuItemReproduccioContinua);

        jCheckBoxMenuItemReproduccioAleatoria.setText("Reproducció Aleatòria");
        jCheckBoxMenuItemReproduccioAleatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemReproduccioAleatoriaActionPerformed(evt);
            }
        });
        jMenuTipusReproduccio.add(jCheckBoxMenuItemReproduccioAleatoria);

        jMenuBar.add(jMenuTipusReproduccio);

        jMenuDades.setText("Dades");

        jMenuItemGuardaDades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGuardaDades.setText("Guarda les Dades");
        jMenuItemGuardaDades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardaDadesActionPerformed(evt);
            }
        });
        jMenuDades.add(jMenuItemGuardaDades);

        jMenuItemCarregaDades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCarregaDades.setText("Carrega les Dades");
        jMenuItemCarregaDades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarregaDadesActionPerformed(evt);
            }
        });
        jMenuDades.add(jMenuItemCarregaDades);

        jMenuBar.add(jMenuDades);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemEditaBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditaBibliotecaActionPerformed
        new Biblioteca(this, controlador, null, null).setVisible(true);
    }//GEN-LAST:event_jMenuItemEditaBibliotecaActionPerformed

    private void jMenuItemReprodueixBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReprodueixBibliotecaActionPerformed
        try {
            controlador.reproduirCarpeta(controlador.getBiblioteca());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jMenuItemReprodueixBibliotecaActionPerformed

    private void jMenuItemEditaAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditaAlbumsActionPerformed
        new Albums(this, controlador).setVisible(true);
    }//GEN-LAST:event_jMenuItemEditaAlbumsActionPerformed

    private void jCheckBoxMenuItemReproduccioContinuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemReproduccioContinuaActionPerformed
        controlador.modificarReproduccioContinua();
    }//GEN-LAST:event_jCheckBoxMenuItemReproduccioContinuaActionPerformed

    private void jCheckBoxMenuItemReproduccioAleatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemReproduccioAleatoriaActionPerformed
        controlador.modificarReproduccioAleatoria();
    }//GEN-LAST:event_jCheckBoxMenuItemReproduccioAleatoriaActionPerformed

    private void jMenuItemGuardaDadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardaDadesActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                controlador.guardarDadesDisc(chooser.getSelectedFile().toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemGuardaDadesActionPerformed

    private void jMenuItemCarregaDadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarregaDadesActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                controlador.carregarDadesDisc(chooser.getSelectedFile().toString());
                jCheckBoxMenuItemReproduccioContinua.setState(controlador.getReproduccioContinua());
                jCheckBoxMenuItemReproduccioAleatoria.setState(controlador.getReproduccioAleatoria());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemCarregaDadesActionPerformed

    private void jButtonPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayPauseActionPerformed
        togglePlayPause();
        System.out.println("1: " + embeddedMediaPlayerComponent.mediaPlayer().audio().channel());
    }//GEN-LAST:event_jButtonPlayPauseActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        if (embeddedMediaPlayerComponent.mediaPlayer().status().isPlayable()) {
            manualStop = true;
            embeddedMediaPlayerComponent.mediaPlayer().controls().stop();
        }
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        if (embeddedMediaPlayerComponent.mediaPlayer().status().isPlayable()) {
            manualStop = true;
            embeddedMediaPlayerComponent.mediaPlayer().controls().stop();
        } playPrevious();
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if (embeddedMediaPlayerComponent.mediaPlayer().status().isPlayable()) {
            manualStop = true;
            embeddedMediaPlayerComponent.mediaPlayer().controls().stop();
        } playNext();
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jMenuItemPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPlayPauseActionPerformed
        togglePlayPause();
    }//GEN-LAST:event_jMenuItemPlayPauseActionPerformed

    private void jCheckBoxMenuItemToggleFullScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemToggleFullScreenActionPerformed
        setFullScreen(jCheckBoxMenuItemToggleFullScreen.isSelected());
    }//GEN-LAST:event_jCheckBoxMenuItemToggleFullScreenActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        embeddedMediaPlayerComponent.release();
    }//GEN-LAST:event_formWindowClosing

    private void initManualComponents() {
        embeddedMediaPlayerComponent = new EmbeddedMediaPlayerComponent(null, null, new AdaptiveFullScreenStrategy(this), null, null);
        System.out.println("1: " + embeddedMediaPlayerComponent.mediaPlayer().audio().channel());
        embeddedMediaPlayerComponent.setPreferredSize(Constants.MIDA_REPRODUCTOR_DEFECTE);
        jPanelReproductor.add(embeddedMediaPlayerComponent, "cardReproductor");
        super.pack();
        
        jPanelBackgroundImageAudio = new JPanelBackgroundImage();
        jPanelBackgroundImageAudio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanelBackgroundImageAudio.requestFocus();
            }
        });
        jPanelReproductor.add(jPanelBackgroundImageAudio, "cardAudioImage");
        
        timer = new Timer(100, (ActionEvent) -> {
            updateTime();
        });
        
        iconPlay = new ImageIcon("src/resources/icons/play.png");
        iconPause = new ImageIcon("src/resources/icons/pause.png");
        
        jSliderProgrammaticChange = false;
        manualStop = false;
    }
    
    private void initManualControllers() {
        initActions();
        initReproductorControllers();
        initJSliderControllers();
    }
    
    private void initActions() {
        actionDisableFullScreen = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFullScreen(false);
            }
        };
        actionPlayPause = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePlayPause();
            }
        };
    }
    
    private void initReproductorControllers(){
        embeddedMediaPlayerComponent.mediaPlayer().events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void playing(MediaPlayer mediaPlayer) {
                jButtonPlayPause.setIcon(iconPause);
                jButtonPlayPause.setToolTipText("Press to Pause");
                jMenuItemPlayPause.setText("Pause");
                timer.start();
            }
            @Override
            public void mediaPlayerReady(MediaPlayer mediaPlayer) {
                jLabelTotalTime.setText(getFormattedTime(embeddedMediaPlayerComponent.mediaPlayer().status().length()));
            }
            @Override
            public void paused(MediaPlayer mediaPlayer) {
                jButtonPlayPause.setIcon(iconPlay);
                jMenuItemPlayPause.setText("Play");
                jButtonPlayPause.setToolTipText("Press to Play");
                timer.stop();
            }
            @Override
            public void stopped(MediaPlayer mediaPlayer) {
                if (manualStop) {
                    ((CardLayout)jPanelReproductor.getLayout()).show(jPanelReproductor, "cardReproductor");
                    jButtonPlayPause.setIcon(iconPlay);
                    jMenuItemPlayPause.setText("Play");
                    jButtonPlayPause.setToolTipText("Press to Play");
                    jLabelCurrentTime.setText("--.--");
                    jSlider.setValue(0);
                    jLabelTotalTime.setText("--.--");
                    timer.stop();
                    manualStop = false;
                }
            }
            @Override
            public void finished(MediaPlayer mediaPlayer) {
                jButtonPlayPause.setIcon(iconPlay);
                jMenuItemPlayPause.setText("Play");
                jButtonPlayPause.setToolTipText("Press to Play");
                jLabelCurrentTime.setText("--.--");
                jSlider.setValue(0);
                jLabelTotalTime.setText("--.--");
                ((CardLayout)jPanelReproductor.getLayout()).show(jPanelReproductor, "cardReproductor");
                timer.stop();
                mediaPlayer.submit(() -> {
                    playNext();
                });
            }
        });
        embeddedMediaPlayerComponent.videoSurfaceComponent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1  && e.getClickCount() == 2) {
                    setFullScreen(!embeddedMediaPlayerComponent.mediaPlayer().fullScreen().isFullScreen());
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    jPopupMenuOptions.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        embeddedMediaPlayerComponent.getInputMap().put(KeyStroke.getKeyStroke(' '), "playPause");
        embeddedMediaPlayerComponent.getActionMap().put("playPause", actionPlayPause);
        
        jPanelBackgroundImageAudio.getInputMap().put(KeyStroke.getKeyStroke(' '), "playPause");
        jPanelBackgroundImageAudio.getActionMap().put("playPause", actionPlayPause);
        
        embeddedMediaPlayerComponent.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "normal");
        embeddedMediaPlayerComponent.getActionMap().put("normal", actionDisableFullScreen);
    }
    
    private void initJSliderControllers() {
        jSlider.addChangeListener((ChangeEvent) -> {
            if (!jSliderProgrammaticChange && embeddedMediaPlayerComponent.mediaPlayer().status().isPlaying()) {
                embeddedMediaPlayerComponent.mediaPlayer().controls().setPosition(((float)jSlider.getValue() / jSlider.getMaximum()));
                jLabelCurrentTime.setText(getFormattedTime(embeddedMediaPlayerComponent.mediaPlayer().status().time()));
            } else
                jSliderProgrammaticChange = false;
        });
        jSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    jSlider.setValue(((BasicSliderUI)jSlider.getUI()).valueForXPosition(e.getX()));
                    jSlider.setValueIsAdjusting(false);
                }
            }
        });
    }
    
    private void setFullScreen(boolean enabled) {
        if (enabled != embeddedMediaPlayerComponent.mediaPlayer().fullScreen().isFullScreen()) {
            embeddedMediaPlayerComponent.mediaPlayer().fullScreen().set(enabled);
            jMenuBar.setVisible(!enabled);
            jToolBarReproductor.setVisible(!enabled);
            jCheckBoxMenuItemToggleFullScreen.setSelected(enabled);
        }
    }
    
    private void togglePlayPause() {
        if (embeddedMediaPlayerComponent.mediaPlayer().status().isPlayable()) {
            embeddedMediaPlayerComponent.mediaPlayer().controls().pause();
        } else if (controlador.hasFile()) {
            controlador.reprodueixFitxer();
        } else if (controlador.hasList()) {
            controlador.reset();
            controlador.reprodueixFitxer();
        } else {
            String url = JOptionPane.showInputDialog(ReproductorMultimedia.this, "Introdueix el camí o URL del fitxer que vulguis reproduir"
                    + " (pots mirar vídeos de YouTube si tens el vlc actualitzat)");
            if (url != null) {
                controlador.reprodueixFitxer(url);
            }
        }
    }
    
    private void playPrevious() {
        controlador.previous();
        if (controlador.hasFile())
            controlador.reprodueixFitxer();
    }
    
    private void playNext() {
        controlador.next();
        if (controlador.hasFile())
            controlador.reprodueixFitxer();
    }
    
    private void updateTime() {
        jSliderProgrammaticChange = true;
        jSlider.setValue(Math.round(embeddedMediaPlayerComponent.mediaPlayer().status().position() * jSlider.getMaximum()));
        jLabelCurrentTime.setText(getFormattedTime(embeddedMediaPlayerComponent.mediaPlayer().status().time()));
    }
    
    private static String getFormattedTime(long millis) {
        int seconds = Math.round(millis / 1000);
        return String.format("%02d.%02d", seconds / 60, seconds % 60);
    }
    
    /**
     * Ordena al reproductor que reprodueixi el vídeo
     * 
     * @param video vídeo per reproduir
     */
    public void playVideo(String video) {
        ((CardLayout)jPanelReproductor.getLayout()).show(jPanelReproductor, "cardReproductor");
        embeddedMediaPlayerComponent.mediaPlayer().media().play(video);
    }
    
    /**
     * Ordena al reproductor que reprodueixi l'àudio i posi la imatge de fons
     * 
     * @param audio àudio per reproduir
     * @param image imatge de l'àudio
     */
    public void playAudio(String audio, File image) {
        ((CardLayout)jPanelReproductor.getLayout()).show(jPanelReproductor, "cardAudioImage");
        try {
            jPanelBackgroundImageAudio.setImage(ImageIO.read(image));
            jPanelBackgroundImageAudio.revalidate();
        } catch (IOException ex) { }
        embeddedMediaPlayerComponent.mediaPlayer().media().play(audio);
    }
    
    /**
     * Obté el camí del vlc, inicia el reproductor i el fa visible
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (!new NativeDiscovery().discover())
            System.out.println("No s'ha trobat el camí del VLC");
        else
            new ReproductorMultimedia().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPlayPause;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemReproduccioAleatoria;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemReproduccioContinua;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemToggleFullScreen;
    private javax.swing.JLabel jLabelCurrentTime;
    private javax.swing.JLabel jLabelTotalTime;
    private javax.swing.JMenu jMenuAlbums;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuBiblioteca;
    private javax.swing.JMenu jMenuDades;
    private javax.swing.JMenuItem jMenuItemCarregaDades;
    private javax.swing.JMenuItem jMenuItemEditaAlbums;
    private javax.swing.JMenuItem jMenuItemEditaBiblioteca;
    private javax.swing.JMenuItem jMenuItemGuardaDades;
    private javax.swing.JMenuItem jMenuItemPlayPause;
    private javax.swing.JMenuItem jMenuItemReprodueixBiblioteca;
    private javax.swing.JMenu jMenuTipusReproduccio;
    private javax.swing.JPanel jPanelReproductor;
    private javax.swing.JPopupMenu jPopupMenuOptions;
    private javax.swing.JToolBar.Separator jSeparatorAfterCurrentTime;
    private javax.swing.JToolBar.Separator jSeparatorAfterTotalTime;
    private javax.swing.JToolBar.Separator jSeparatorBeforeCurrentTime;
    private javax.swing.JToolBar.Separator jSeparatorBeforeTotalTime;
    private javax.swing.JSlider jSlider;
    private javax.swing.JToolBar jToolBarReproductor;
    // End of variables declaration//GEN-END:variables
}
