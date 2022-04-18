package controlador;

import java.io.File;

import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import model.Audio;
import model.Dades;

import vista.ReproductorMultimedia;

/**
 * Classe que controla el funcionament de l'aplicació i fa de pont entre model i vista
 *
 * @author Andreu Vall i Ridouane Zaim
 */
public class Controlador {
    
    private ReproductorMultimedia reproductor;
    private Dades dades;
    
    private boolean reproduccioContinua;
    private List<File> llistaReproduccio;
    private int position;
    
    /**
     * Crea les dades i es guarda el reproductor
     * 
     * @param reproductor reproductor
     */
    public Controlador(ReproductorMultimedia reproductor) {
        dades = new Dades();
        this.reproductor = reproductor;
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#afegirVideo}
     */
    public void afegirVideo(String path, String descripcio, String codec, float durada, int alcada, int amplada, float fps) throws Exception {
        dades.afegirVideo(path, descripcio, codec, durada, alcada, amplada, fps);
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#afegirAudio}
     */
    public void afegirAudio(String path, String descripcio, String codec, float durada, File imatge, int kbps) throws Exception {
        dades.afegirAudio(path, descripcio, codec, durada, imatge, kbps);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getBiblioteca}
     */
    public List<File> getBiblioteca() {
        return dades.getBiblioteca();
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#esborrarFitxer}
     */
    public void esborrarFitxer(int id) throws Exception {
        dades.esborrarFitxer(id);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#afegirAlbum}
     */
    public void afegirAlbum(String titol) throws Exception {
        dades.afegirAlbum(titol);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getLlistatAlbums}
     */
    public List<String> getLlistatAlbums() {
        return dades.getLlistatAlbums();
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#esborrarAlbum}
     */
    public void esborrarAlbum(String titol) throws Exception {
        dades.esborrarAlbum(titol);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#existeixAlbum}
     */
    public boolean existeixAlbum(String titol) {
        return dades.existeixAlbum(titol);
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#afegirFitxer}
     */
    public void afegirFitxer(String titolAlbum, int id) throws Exception {
        dades.afegirFitxer(titolAlbum, id);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getAlbum}
     */
    public List<File> getAlbum(String titol) throws Exception {
        return dades.getAlbum(titol);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#esborrarFitxer}
     */
    public void esborrarFitxer(String titol, int id) throws Exception {
        dades.esborrarFitxer(titol, id);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#guardarDadesDisc}
     */
    public void guardarDadesDisc(String camiDesti) throws Exception {
        dades.guardarDadesDisc(camiDesti);
    }

    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#carregarDadesDisc} and {@link Dades#carregarDadesDisc}
     */
    public void carregarDadesDisc(String camiOrigen) throws Exception {
        dades = Dades.carregarDadesDisc(camiOrigen);
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#modificarReproduccioContinua}
     */
    public void modificarReproduccioContinua() {
        dades.modificarReproduccioContinua();
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#modificarReproduccioAleatoria}
     */
    public void modificarReproduccioAleatoria() {
        dades.modificarReproduccioAleatoria();
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getReproduccioContinua}
     */
    public boolean getReproduccioContinua() {
        return dades.getReproduccioContinua();
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getReproduccioAleatoria}
     */
    public boolean getReproduccioAleatoria() {
        return dades.getReproduccioAleatoria();
    }
    
    /**
     * Guarda les dades d'una carpeta de fitxers i ordena al reproductor de vista que comenci a reproduir
     * 
     * @param carpeta carpeta per reproduir
     * @throws Exception si la carpeta està buida
     */
    public void reproduirCarpeta(List<File> carpeta) throws Exception {
        if (carpeta.isEmpty())
            throw new Exception("La carpeta està buida");
        reproduccioContinua = dades.getReproduccioContinua();
        position = 0;
        if (dades.getReproduccioAleatoria())
            Collections.shuffle(carpeta);
        llistaReproduccio = carpeta;
        reprodueixFitxer();
    }
    
    /**
     * Reprodueix el fitxer a la posició actual
     */
    public void reprodueixFitxer() {
        reprodueixFitxer(llistaReproduccio.get(position));
    }
    
    /**
     * Ordena la reproducció d'un fitxer al reproductor
     * 
     * @param file fitxer per reproduir
     */
    public void reprodueixFitxer(File file) {
        if (file instanceof Audio)
            reproductor.playAudio(file.toString(), ((Audio)file).getImatge());
        else
            reproductor.playVideo(file.toString());
    }
    
    /**
     * Ordena la reproducció d'un url al reproductor
     * 
     * @param url string del fitxer o enllaç per reproduir
     */
    public void reprodueixFitxer(String url) {
        reproductor.playVideo(url);
    }
    
    /**
     * Comprova si hi ha alguna llista de reproducció vàlida
     * 
     * @return si hi ha alguna llista de reproducció vàlida
     */
    public boolean hasList() {
        return llistaReproduccio != null && !llistaReproduccio.isEmpty();
    }
    
    /**
     * Reseteja la posició de reproducció
     */
    public void reset() {
        position = 0;
    }
    
    /**
     * Avança la posició de reproducció
     */
    public void next() {
        if (llistaReproduccio != null && position < llistaReproduccio.size()) {
            position++;
            if (reproduccioContinua && position >= llistaReproduccio.size())
                position = 0;
        }
    }
    
    /**
     * Retrocedeix la posició de reproducció
     */
    public void previous() {
        if (llistaReproduccio != null && position >= 0) {
            position--;
            if (reproduccioContinua && position < 0)
                position = llistaReproduccio.size() - 1;
        }
    }
    
    /**
     * Commprova si hi ha un fitxer en la posició actual
     * 
     * @return si hi ha un fitxer en la posició actual
     */
    public boolean hasFile() {
        return llistaReproduccio != null && position >= 0 && position < llistaReproduccio.size();
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getFileAt(int)}
     */
    public File getFileAt(int index) throws Exception {
        return dades.getFileAt(index);
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getBibliotecaSize}
     */
    public int getBibliotecaSize() {
        return dades.getBibliotecaSize();
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getFileAt(int, String)}
     */
    public File getFileAt(int index, String album) throws Exception {
        return dades.getFileAt(index, album);
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getDefaultTableModel}
     */
    public static DefaultTableModel getDefaultTableModel(List<File> carpeta) {
        return Dades.getDefaultTableModel(carpeta);
    }
    
    /**
     * {@inheritDoc}
     * A convenience method, equivalent to {@link Dades#getValues}
     */
    public static Object[] getValues(File f) {
        return Dades.getValues(f);
    }

}
