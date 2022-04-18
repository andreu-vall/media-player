package model;

import java.util.Objects;

/**
 * Classe per guardar àlbums de fitxers
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class AlbumFitxersMultimedia extends CarpetaFitxers {
    
    private static final int ALBUM_DEFAULT_MAX_SIZE = 10;
    
    private String titol;
    
    /**
     * Constructor per defecte, crida el constructor de CarpetaFitxers {@link CarpetaFitxers#CarpetaFitxers} amb 10
     * 
     * @param titol títol de l'àlbum
     */
    public AlbumFitxersMultimedia(String titol) {
        super(ALBUM_DEFAULT_MAX_SIZE);
        this.titol = titol;
    }
    
    /**
     * Constructor amb el paràmetre mida, crida el constructor de CarpetaFitxers {@link CarpetaFitxers#CarpetaFitxers(int)} amb la mida
     * 
     * @param titol títol de l'àlbum
     * @param size  mida de l'àlbum
     */
    public AlbumFitxersMultimedia(String titol, int size) {
        super(size);
        this.titol = titol;
    }
    
    /**
     * Obtenir títol àlbum
     * 
     * @return títol de l'àlbum
     */
    public String getTitol() {
        return this.titol;
    }
    
    @Override
    public boolean equals(Object album) {
        if (album instanceof AlbumFitxersMultimedia)
            return this.getTitol().equals(((AlbumFitxersMultimedia)album).getTitol());
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.titol);
        return hash;
    }
    
}
