package model;

import java.io.File;

import java.util.Objects;

/**
 * Classe extensió de File que representa un fitxer real amb una descripció
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class FitxerMultimedia extends File {
    
    private String descripcio;
    
    /**
     * Construeix el FitxerMultimedia amb el path del File {@link File} i es guarda la descripció
     * 
     * @param path camí del fitxer
     * @param descripcio descripció del fitxer
     * @throws Exception si hi ha algun problema creant el fitxer o bé el fitxer no existeix en el disc
     */
    public FitxerMultimedia(String path, String descripcio) throws Exception {
        super(path);
        if (!super.isFile())
            throw new Exception("El fitxer no existeix");
        this.descripcio = descripcio;
    }
    
    @Override
    public boolean equals(Object fitxer) {
        return super.equals(fitxer) && fitxer instanceof FitxerMultimedia && getDescripcio().equals(((FitxerMultimedia)fitxer).getDescripcio());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.descripcio) + Objects.hashCode(super.getAbsolutePath());
        return hash;
    }
    
    /**
     * Obtenir la descripció del fitxer. Aquesta, juntament amb el camí del fitxer, l'identifica
     * (dos FitxerMultimedia són iguals si i només si tenen el mateix path i descripció)
     * 
     * @return descripció del fitxer
     */
    public String getDescripcio() {
        return descripcio;
    }
    
}
