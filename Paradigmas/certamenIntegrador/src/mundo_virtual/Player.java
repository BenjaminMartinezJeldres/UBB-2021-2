package mundo_virtual;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author klemenzza
 */
public class Player extends JComponent implements Constantes{
    
    public int xMov;
    public int yMov;
    public MundoVirtual mv;
    
    public Player(int x,int y,MundoVirtual mv) {
        xMov=x;
        yMov=y;
        this.mv=mv;
    }
    
    public void moverArriba() { 
        if ( yMov > 0 ) {
          if (  mv.escenario.celdas[xMov][yMov-1].tipo!=PARED) {
            yMov-=1; 
          }
        }
    }
    
    public void moverAbajo() {  
        if ( yMov < NUMERO_CELDAS_LARGO-1 ) {
          if ( mv.escenario.celdas[xMov][yMov+1].tipo!=PARED) {
            yMov+=1; 
          }
        }
    
    }
    
    public void moverIzquierda() { 
        if ( xMov!=0) {
           if ( mv.escenario.celdas[xMov-1][yMov].tipo!=PARED) {
             xMov-=1;
           }
        }
    }
    
    public void moverDerecha() {
        if ( xMov < NUMERO_CELDAS_ANCHO-1  ) {
           if ( mv.escenario.celdas[xMov+1][yMov].tipo!=PARED)
             xMov+=1; 
        }
    }
    //algoritmo de pintado de una entidad
    @Override
    public void paintComponent(Graphics g) {  
        g.drawRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.green);//cambiamos color
        g.fillRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.BLACK);//volvemos a cambiar 
        g.setFont(FUENTE);
        g.drawString("J",(xMov*PIXELS+DESPLAZAMIENTO)+5,(yMov*PIXELS+DESPLAZAMIENTO)+28);
    }
}
