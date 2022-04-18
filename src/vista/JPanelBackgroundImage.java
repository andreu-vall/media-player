package vista;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Classe que representa un panell on es pinta una imatge escalada de fons
 * 
 * @author Andreu Vall i Ridouane Zaim
 */
public class JPanelBackgroundImage extends JPanel {
    
    private Image image;
    private int imageWidth, imageHeight;
    private double imageRatio;
    private int width, height, x, y;
    
    /**
     * Constructor per defecte, sense paràmetres perquè si no el Choose Bean del GUI de Netbeans no el deixa afegir
     */
    public JPanelBackgroundImage() {
        image = null;
        imageWidth = 0;
        imageHeight = 0;
        imageRatio = 1;
        x = 0;
        y = 0;
    }
    
    /**
     * Posar la imatge de fons
     * 
     * @param image imatge de fons
     */
    public void setImage(Image image) {
        this.image = image;
        imageWidth = image.getWidth(this);
        imageHeight = image.getHeight(this);
        imageRatio = (double) imageWidth/ imageHeight;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            updateSize();
            g.drawImage(image, x, y, width, height, this);
        }
    }
    
    private void updateSize() {
        double jPanelRatio = (double)getWidth() / getHeight();
        if (jPanelRatio >= imageRatio) {
            width = (int)(getHeight()*imageRatio);
            height = getHeight();
            x = (getWidth() - width) / 2;
            y = 0;
        } else {
            width = getWidth();
            height = (int)(getWidth()/imageRatio);
            x = 0;
            y = (getHeight() - height) / 2;
        }
    }
    
}
