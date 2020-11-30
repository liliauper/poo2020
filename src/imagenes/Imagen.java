
package imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Imagen extends javax.swing.JPanel{
    String ruta;
    
    public Imagen(int x, int y, String ruta){
        this.setSize(x,y);
        this.ruta = ruta;
    }
  
    public boolean exists(){
        return getClass().getResource(ruta) == null;
    }
    
    public void paint(Graphics g){
        Dimension height = getSize();
        ImageIcon img = new ImageIcon(getClass().getResource(ruta));

        g.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponents(g);
        
    }
    
}
