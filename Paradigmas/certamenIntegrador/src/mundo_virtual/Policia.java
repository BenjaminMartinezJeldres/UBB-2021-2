package mundo_virtual;

import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import anchura.Busqueda_AnchuraP;

public class Policia extends TimerTask implements Constantes{
    
    public int xMov,yMov;
    public MundoVirtual mv;
    public Busqueda_AnchuraP ia;
    public int proximo_mov;
    
    public Policia(int x,int y,MundoVirtual mv) {
        xMov=x;
        yMov=y;
        this.mv=mv;
        proximo_mov=1;
        ia=new Busqueda_AnchuraP(this,x,y,
                               NUMERO_CELDAS_ANCHO-1,
                               NUMERO_CELDAS_LARGO-1);
    }
    
    public void inteligencia() {
     
        ia.busqueda();
        System.out.println(ia.pasos);
  
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
    
    public void paintCelda(Graphics g) {  
        
        g.drawRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.blue);//cambiamos color
        g.fillRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.BLACK);//volvemos a cambiar 
        g.setFont(FUENTE);
        g.drawString("P",
                (xMov*PIXELS+DESPLAZAMIENTO)+5,
                (yMov*PIXELS+DESPLAZAMIENTO)+28);
        
    }

    
    @Override
    public void run() {
        
        String mov="";
        if ( proximo_mov < ia.pasos.size() && !comeAdversario()) {
           mov=ia.pasos.get(proximo_mov);
           System.out.println(mov);
           actualizarEntidad();
           realizar_Movimiento(mov);
           actualizarEntidad();
           proximo_mov++;
        }else {
           System.out.println(" [ Entidad : "
                   + "LLegaste al final ");
           this.cancel();
        }
        
    }
    
    public boolean comeAdversario() {
        return xMov==mv.adv1.xMov && yMov==mv.adv1.yMov;
    }
    
    private void realizar_Movimiento(String mov) {
        
        switch(mov) {
           case "arriba": moverArriba(); break;
           case "abajo": moverAbajo(); break;
           case "izquierda": moverIzquierda(); break;
           case "derecha": moverDerecha();break;
        }
        
    }
    
    private void actualizarEntidad() {
        mv.repaint(xMov*PIXELS+DESPLAZAMIENTO,
                   yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS); 
    }
    
    public boolean fin() {
        return proximo_mov > ia.pasos.size();
    }
    
    
}
