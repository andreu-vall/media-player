package model;

/**
 * Classe model per a fitxers reals reproduïbles reals, que guarda les propietats còdec i durada
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class FitxerReproduible extends FitxerMultimedia {
    
    private String codec;
    private float durada;
    
    /**
     * Crida al constructor de FitxerMultimedia {@link FitxerMultimedia#FitxerMultimedia} i es guarda el còdec i durada
     * 
     * @param path camí del fitxer
     * @param descripcio descripció del fitxer
     * @param codec còdec del fitxer
     * @param durada durada en segons del fitxer
     * @throws Exception si hi ha algun problema creant el fitxer o bé el fitxer no existeix en el disc
     */
    public FitxerReproduible(String path, String descripcio, String codec, float durada) throws Exception {
        super(path, descripcio);
        this.codec = codec;
        this.durada = durada;
    }

    /**
     * Retorna el còdec del fitxer
     * 
     * @return còdec del fitxer
     */
    public String getCodec() {
        return codec;
    }

    /**
     * Modifica el còdec del fitxer
     * 
     * @param codec nou còdec del fitxer
     */
    public void setCodec(String codec) {
        this.codec = codec;
    }

    /**
     * Retorna la durada (en segons) del fitxer
     * 
     * @return durada (en segons) del fitxer
     */
    public float getDurada() {
        return durada;
    }

    /**
     * Modifica la durada (en segons) del fitxer
     * 
     * @param durada durada (en segons) del fitxer
     */
    public void setDurada(float durada) {
        this.durada = durada;
    }
    
}
