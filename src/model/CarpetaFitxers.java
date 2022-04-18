package model;

import java.io.File;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe que representa una carpeta de fitxers
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class CarpetaFitxers implements Serializable {
    
    private static final int DEFAULT_MAX_SIZE = 100;
    
    private ArrayList<File> carpetaFitxers;
    private final int MAX_SIZE;
    
    /**
     * Constructor per defecte, inicia la mida màxima de la carpeta a 100
     */
    public CarpetaFitxers() {
        this.MAX_SIZE = DEFAULT_MAX_SIZE;
        carpetaFitxers = new ArrayList<>(MAX_SIZE);
        }
    
    /**
     * Constructor amb paràetres, inicia la mida de la carpeta a la mida passada per paràmetres
     * 
     * @param max_size mida màxima de la carpeta
     */
    public CarpetaFitxers(int max_size) {
        this.MAX_SIZE = max_size;
        carpetaFitxers = new ArrayList<>(Math.min(DEFAULT_MAX_SIZE, MAX_SIZE));
    }
    
    /**
     * Retorna la mida de la carpeta
     * 
     * @return mida de la carpeta
     */
    public int getSize() {
        return carpetaFitxers.size();
    }
    
    /**
     * Afegeix el fitxer a la carpeta si no està plena
     * 
     * @param fitxer fitxer per afegir
     * @throws Exception si la carpeta ja està plena
     */
    public void	addFitxer(File fitxer) throws Exception {
        if (this.isFull())
            throw new Exception("La carpeta està plena!");
        carpetaFitxers.add(fitxer);
    }
    
    /**
     * Elimina el fitxer de la carpeta si hi pertany (elimina la primera ocurrència només)
     *
     * @param fitxer fitxer per eliminar
     * @throws Exception si no hi ha cap fitxer a la carpeta o si no es troba el fitxer
     */
    public void	removeFitxer(File fitxer) throws Exception {
        if (this.isEmpty())
            throw new Exception("No hi ha cap fitxer emmagatzemat a la carpeta...");
        if (!carpetaFitxers.remove(fitxer))
            throw new Exception("No s'ha trobat el fixer");
    }
    
    /**
     * Elimina totes les ocurrències del fitxer de la carpeta si n'hi ha
     *
     * @param fitxer fitxer per eliminar
     * @throws Exception si no hi ha cap fitxer a la carpeta o si no es troba cap ocurrència del fitxer
     */
    public void	removeAllFitxer(File fitxer) throws Exception {
        if (this.isEmpty())
            throw new Exception("No hi ha cap fitxer emmagatzemat a la carpeta...");
        if (!carpetaFitxers.removeAll(Arrays.asList(fitxer)));
            throw new Exception("No s'ha trobat el fixer");
    }
    
    /**
     * Retorna el fitxer en una posició de la carpeta si hi és
     *
     * @param position posició del fitxer
     * @return fitxer en la posició indicada
     * @throws Exception si la posició no es vàlida
     */
    public File	getAt(int position) throws Exception {
        if (position < 0 || position >= this.getSize())
            throw new Exception("Introdueix una posició vàlida!");
        return carpetaFitxers.get(position);
    }
    
    /**
     * Elimina tots els elements de la carpeta
     */
    public void clear() {
        carpetaFitxers.clear();
    }
    
    /**
     * Comprova si la carpeta està plena
     *
     * @return si la carpeta està plena
     */
    public boolean isFull() {
        return this.getSize() == MAX_SIZE;
    }
    
    /**
     * Comrpova si la carpeta està buida
     * 
     * @return si la carpeta està buida
     */
    public boolean isEmpty() {
        return this.getSize() == 0;
    }
    
    /**
     * Retorna la llista de fitxers de la carpeta
     * 
     * @return la llista de fitxers de la carpeta
     */
    public List<File> getCarpetaFitxers() {
        return carpetaFitxers;
    }
    
    /**
     * Comprova si el fitxer està contingut en la carpeta
     * 
     * @param file fitxer per cercar
     * @return si el fitxer està contingut en la carpeta
     */
    protected boolean contains(File file) {
        return carpetaFitxers.contains(file);
    }
    
}
