package model;

/**
 * Classe que representa un fitxer de vídeo real amb les dades amplada, alçada i fps
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class Video extends FitxerReproduible {
    
    private int amplada, alcada;
    private float fps;
    
    /**
     * Crida el contructor de FitxerReproduible {@link FitxerReproduible} i es guarda l'amplada, l'alçada i els fps
     * 
     * @param path camí del vídeo
     * @param descripcio descripció del vídeo
     * @param codec còdec del vídeo
     * @param durada durada del vídeo
     * @param amplada amplada del vídeo
     * @param alcada alçada del vídeo
     * @param fps fps del vídeo
     * @throws Exception si hi ha algun problema creant el vídeo o bé el vídeo no existeix en el disc
     */
    public Video(String path, String descripcio, String codec, float durada, int amplada, int alcada, float fps) throws Exception {
        super(path, descripcio, codec, durada);
        this.amplada = amplada;
        this.alcada = alcada;
        this.fps = fps;
    }

    /**
     * Retorna l'amplada del vídeo
     * 
     * @return amplada del vídeo
     */
    public int getAmplada() {
        return amplada;
    }

    /**
     * Modifica l'amplada del vídeo
     * 
     * @param amplada amplada del vídeo
     */
    public void setAmplada(int amplada) {
        this.amplada = amplada;
    }

    /**
     * Retorna l'alçada del vídeo
     * 
     * @return alçada del vídeo
     */
    public int getAlcada() {
        return alcada;
    }

    /**
     * Modifica l'alçada del vídeo
     * 
     * @param alcada alçada del vídeo
     */
    public void setAlcada(int alcada) {
        this.alcada = alcada;
    }

    /**
     * Retorna els fps del vídeo
     * 
     * @return fps del vídeo
     */
    public float getFps() {
        return fps;
    }

    /**
     * Modifica els fps del vídeo
     * 
     * @param fps fps del vídeo
     */
    public void setFps(float fps) {
        this.fps = fps;
    }
    
}
