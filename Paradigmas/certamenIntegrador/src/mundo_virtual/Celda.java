package mundo_virtual;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author klemenzza
 */
public class Celda implements Constantes {
    
    public int xPixel;
    public int yPixel;
    public char tipo;
   
    //constructor
    public Celda(int x,int y,char t) {
        this.xPixel=x;
        this.yPixel=y; 
        this.tipo=t;
    }
    
    public void paintCelda(Graphics g) { 
        switch(tipo) {
            case CAMINO:
                g.drawRect(xPixel,yPixel,PIXELS,PIXELS);
            break;
            case PARED:
                g.fillRect(xPixel,yPixel,PIXELS,PIXELS);
            break;
            case EXPLORADO:
                g.setColor(COLOR_EXPLORADO);
                g.fillRect(xPixel,yPixel,PIXELS,PIXELS);
                g.setColor(Color.black);
                g.drawRect(xPixel,yPixel,PIXELS,PIXELS);
            break;
            
            case PLAYER:
                g.setColor(Color.red);
                g.fillRect(xPixel,yPixel,PIXELS,PIXELS);
                g.setColor(Color.black);
                g.drawRect(xPixel,yPixel,PIXELS,PIXELS);
            break;
            
            case POLICIA:
                g.setColor(Color.blue);
                g.fillRect(xPixel,yPixel,PIXELS,PIXELS);
                g.setColor(Color.black);
                g.drawRect(xPixel,yPixel,PIXELS,PIXELS);
            break;
            
            case DESTINO:
                g.setColor(Color.pink);
                g.fillRect(xPixel,yPixel,PIXELS,PIXELS);
                g.setColor(Color.black);
                g.drawRect(xPixel,yPixel,PIXELS,PIXELS);
            break;
        }
    }
}
