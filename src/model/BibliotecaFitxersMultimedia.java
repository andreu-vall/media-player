package model;

import java.io.File;

/**
 * Classe que representa una carpeta de fitxers de mida il·limitada
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers {
    
    /**
     * Crida el constructor amb paràmetres de CarpetaFitxers {@link CarpetaFitxers#CarpetaFitxers(int)}
     * amb la mida màxima possible (representa com si fos mida il·limitada)
     */
    public BibliotecaFitxersMultimedia(){
        super(Integer.MAX_VALUE);
    }
    
    @Override
    public void addFitxer(File fitxer) throws Exception {
        if (super.contains(fitxer))
            throw new Exception("Aquest fitxer ja pertany a la carpeta!");
        super.addFitxer(fitxer);
    }
    
    @Override
    public boolean isFull() {
        return false;
    }
    
}
