package model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.table.DefaultTableModel;

/**
 * Classe on guardem les dades
 *
 * @author Andreu Vall i Zaim Ridouane 
 */
public class Dades implements Serializable {
    
    private BibliotecaFitxersMultimedia biblioteca;
    private Map<String, AlbumFitxersMultimedia> albums;
    private boolean reproduccioContinua, reproducciAleatoria;
    
    private static final String[] PROPIETATS = new String[] {"Nom", "Camí", "Descripció", "Tipus",
        "Còdec", "Durada", "Amplada", "Alçada", "Fps", "Camí imatge", "Kbps"};
    
    /**
     * Constructor, crea la biblioteca i el HashMap d'àlbums
     */
    public Dades() {
        biblioteca = new BibliotecaFitxersMultimedia();
        albums = new HashMap<>();
        reproduccioContinua = false;
        reproducciAleatoria = false;
    }
    
    /**
     * Crea un vídeo i l'afegeix a la biblioteca
     * 
     * @param path camí vídeo
     * @param descripcio descripció vídeo
     * @param codec còdec vídeo
     * @param durada durada vídeo
     * @param alcada alçada vídeo
     * @param amplada amplada vídeo
     * @param fps fps vídeo
     * @throws Exception si no s'afegeix correctament
     */
    public void afegirVideo(String path, String descripcio, String codec, float durada, int alcada, int amplada, float fps) throws Exception {
        biblioteca.addFitxer(new Video(path, descripcio, codec, durada, alcada, amplada, fps));
    }
    
    /**
     * Afegir un àudio i l'afegeix a la biblioteca
     * 
     * @param path camí àudio
     * @param descripcio descripció àudio
     * @param codec còdec àudio
     * @param durada durada àudio
     * @param imatge Thumbnail
     * @param kbps kbps àudio
     * @throws Exception si no s'afegeix correctament
     */
    public void afegirAudio(String path, String descripcio, String codec, float durada, File imatge, int kbps) throws Exception {
        biblioteca.addFitxer(new Audio(path, descripcio, codec, durada, imatge, kbps));
    }

    /**
     * Retorna la llista de fitxers de la biblioteca
     * 
     * @return llista de fitxers de la biblioteca
     */
    public List<File> getBiblioteca() {
        return biblioteca.getCarpetaFitxers();
    }

    
    /**
     * Esborra un fitxer a una posició determinada de la biblioteca
     * 
     * @param id posició a biblioteca
     * @throws Exception si no s'esborra correctament
     */
    public void esborrarFitxer(int id) throws Exception {
        File file = biblioteca.getAt(id);
        if (biblioteca.contains(file)) {
            albums.values().forEach((album) -> {
                try {
                    album.removeAllFitxer(file);
                } catch (Exception ex) { }
            });
        }
        biblioteca.removeFitxer(file);
    }
    
    /**
     * Ageix un nou àlbum
     * 
     * @param titol títol àlbum
     * @throws Exception si l'àlbum ja existeix
     */
    public void afegirAlbum(String titol) throws Exception {
        if (albums.containsKey(titol))
            throw new Exception("Aquest àlbum ja existeix");
        albums.put(titol, new AlbumFitxersMultimedia(titol));
    }
    
    /**
     * Retorna el llistat d'àlbums
     *
     * @return llista dels títols de tots els àlbums
     */
    public List<String> getLlistatAlbums() {
        return new ArrayList<>(albums.keySet());
    }
    
    /**
     * Esborra un àlbum
     *
     * @param titol títol de l'àlbum
     * @throws Exception si no es troba l'àlbum
     */
    public void esborrarAlbum(String titol) throws Exception {
        if (!albums.remove(titol, new AlbumFitxersMultimedia(titol)))
            throw new Exception("Àlbum no trobat");
    }
    
    /**
     * Comprova si existeix l'àlbum
     *
     * @param titol títiol de l'àlbum
     * @return si existeix l'àlbum
     */
    public boolean existeixAlbum(String titol) {
        return albums.containsKey(titol);
    }
    
    /**
     * Afegeix un fitxer a un àlbum
     * 
     * @param titolAlbum títol de l'àlbum
     * @param id posició del fitxer a la biblioteca
     * @throws Exception si no s'afegeix correctament
     */
    public void afegirFitxer(String titolAlbum, int id) throws Exception {
        if (!existeixAlbum(titolAlbum))
            throw new Exception("Aquest àlbum no existeix");
        albums.get(titolAlbum).addFitxer(biblioteca.getAt(id));
    }
    
    /**
     * Retorna els fitxers d'un àlbum
     *
     * @param titol títol àlbum
     * @return llista fitxers àlbum
     * @throws Exception si l'àlbum no existeix
     */
    public List<File> getAlbum(String titol) throws Exception {
        if (!existeixAlbum(titol))
            throw new Exception("Aquest àlbum no existeix");
        return albums.get(titol).getCarpetaFitxers();
    }
    
    /**
     * Esborra un fitxer de la biblioteca a una posició determinada
     *
     * @param titol títol del fitxer
     * @param id poscició del fitxer a la biblioteca
     * @throws Exception si l'àlbum no existeix
     */
    public void esborrarFitxer(String titol, int id) throws Exception {
        if (!existeixAlbum(titol))
            throw new Exception("Aquest àlbum no existeix");
        albums.get(titol).removeFitxer(biblioteca.getAt(id));
    }

    /**
     * Emmagatzema dades en un fitxer (serialitzar)
     * 
     * @param camiDesti camí on guradar
     * @throws Exception si no es guarda correctament
     */
    public void guardarDadesDisc(String camiDesti) throws Exception {
        try (FileOutputStream fout = new FileOutputStream(camiDesti);
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this);
        } catch (IOException ex) {
            throw new Exception(ex.toString());
        }
    }

    /**
     * Recupera dades des d'un fitxer (deserialitzar)
     * 
     * @param camiOrigen camí des d'on obrir
     * @return objecte Dades que conté les dades de l'aplicació
     * @throws Exception si no es carrega correctament
     */
    public static Dades carregarDadesDisc(String camiOrigen) throws Exception {
        try (FileInputStream fin = new FileInputStream(camiOrigen);
                ObjectInputStream ois = new ObjectInputStream(fin)) {
            return (Dades)ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        }
    }
    
    /**
     * Modifica la reproducció contínua
     */
    public void modificarReproduccioContinua() {
        reproduccioContinua = !reproduccioContinua;
    }
    
    /**
     * Modifica la reproducció aleatròria
     */
    public void modificarReproduccioAleatoria() {
        reproducciAleatoria = !reproducciAleatoria;
    }
    
    /**
     * Comprova si la reproducció és contínua
     * 
     * @return si la reproducció és contínua
     */
    public boolean getReproduccioContinua() {
        return reproduccioContinua;
    }
    
    /**
     * Comprova si la reproducció és aleatòria
     * 
     * @return si la reproducció és aleatòria
     */
    public boolean getReproduccioAleatoria() {
        return reproducciAleatoria;
    }
    
    /**
     * Obtenir un fitxer a una posició determinada de la bibilioteca
     * 
     * @param index posició del fitxer
     * @return fitxer a la posició indicada
     * @throws Exception si la posició no és vàlida
     */
    public File getFileAt(int index) throws Exception {
        return biblioteca.getAt(index);
    }
    
    /**
     * Retorna la mida de la biblioteca
     * 
     * @return mida de la biblioteca
     */
    public int getBibliotecaSize() {
        return biblioteca.getSize();
    }
    
    /**
     * Obtenir un fitxer a una posició determinada d'un àlbum determinat
     * 
     * @param index posició del fitxer
     * @param album àlbum on buscar
     * @return el fitxer a la posició indicada
     * @throws Exception si l'àlbum no existeix o la posició no és vàlida
     */
    public File getFileAt(int index, String album) throws Exception {
        if (!existeixAlbum(album))
            throw new Exception("Aquest àlbum no existeix");
        return albums.get(album).getAt(index);
    }
    
    /**
     * Crea unaDefaultTableModel a partir d'una llista de fitxers
     * 
     * @param carpeta llista de fitxers
     * @return el DefaultTableModel
     */
    public static DefaultTableModel getDefaultTableModel(List<File> carpeta) {
        Object[][] valors = new Object[carpeta.size()][PROPIETATS.length];
        for (int i = 0; i < carpeta.size(); i++)
            valors[i] = getValues(carpeta.get(i));
        return new DefaultTableModel(valors, PROPIETATS) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
    }
    
    /**
     * Crea un Object[] a partir d'un fitxer
     * 
     * @param f fitxer
     * @return l'Object[] amb les propietats del fitxer
     */
    public static Object[] getValues(File f) {
        Object[] values = new Object[PROPIETATS.length];
        values[0] = f.getName();
        values[1] = f.getAbsolutePath();
        if (f instanceof FitxerReproduible) {
            values[2] = ((FitxerReproduible) f).getDescripcio();
            values[4] = ((FitxerReproduible) f).getCodec();
            values[5] = ((FitxerReproduible) f).getDurada();
            if (f instanceof Video) {
                values[3] = "Vídeo";
                values[6] = ((Video) f).getAmplada();
                values[7] = ((Video) f).getAlcada();
                values[8] = ((Video) f).getFps();
            }
            if (f instanceof Audio) {
                values[3] = "Àudio";
                values[9] = ((Audio) f).getImatge();
                values[10] = ((Audio) f).getKbps();
            }
        }
        return values;
    }
    
}
