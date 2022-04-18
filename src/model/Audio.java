package model;

import java.io.File;

/**
 * Classe que representa un fitxer d'Àudio real amb una Thumbnail i els kbps
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class Audio extends FitxerReproduible {
    
    private File imatge;
    private int kbps;
    
    /**
     * Crida el contructor de FitxerReproduible {@link FitxerReproduible#FitxerReproduible} i es guarda la Thumbnail i els kbps
     * 
     * @param path camí de l'àudio
     * @param descripcio descripció de l'àudio
     * @param codec còdec de l'àudio
     * @param durada durada de l'àudio
     * @param imatge Thumbnail de l'àudio
     * @param kbps kbps de l'àudio
     * @throws Exception si hi ha algun problema creant l'àudio o bé l'àudio no existeix en el disc
     */
    public Audio(String path, String descripcio, String codec, float durada, File imatge, int kbps) throws Exception {
        super(path, descripcio, codec, durada);
        this.imatge = imatge;
        this.kbps = kbps;
    }

    /**
     * Retorna la Thumbnail de l'àudio
     * 
     * @return Thumbnail de l'àudio
     */
    public File getImatge() {
        return imatge;
    }

    /**
     * Modifica la Thumbnail de l'àudio
     * 
     * @param imatge Thumbnail de l'àudio
     */
    public void setImatge(File imatge) {
        this.imatge = imatge;
    }

    /**
     * Retorna els kbps de l'àudio
     * 
     * @return kbps de l'àudio
     */
    public int getKbps() {
        return kbps;
    }

    /**
     * Modifica els kbps de l'àudio
     * 
     * @param kbps kbps de l'àudio
     */
    public void setKbps(int kbps) {
        this.kbps = kbps;
    }
    
}
