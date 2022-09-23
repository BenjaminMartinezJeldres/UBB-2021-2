package mundo_virtual;

import anchura.Busqueda_Anchura;
import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;

public class Adversario extends TimerTask implements Constantes{

    public int xMov,yMov;
    public MundoVirtual mv;
    public Busqueda_Anchura ia;
    public int proximo_mov;

    public Adversario(int x,int y,MundoVirtual mv) {
        xMov=x;
        yMov=y;
        this.mv=mv;
        proximo_mov=1;
        ia=new Busqueda_Anchura(this,x,y,mv.player.xMov,mv.player.yMov);
    }

    public void inteligencia() {
        ia.busqueda();
        System.out.println(ia.pasos);

    }
    
    public void moverArriba() { 
        if ( yMov > 0 ) {
          if (  mv.escenario.celdas[xMov][yMov-1].tipo!=PARED ) {
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
        g.setColor(Color.red);//cambiamos color
        g.fillRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.BLACK);//volvemos a cambiar
        g.setFont(FUENTE);
        g.drawString("A",(xMov*PIXELS+DESPLAZAMIENTO)+5,(yMov*PIXELS+DESPLAZAMIENTO)+28);
        
    }

    @Override
    public void run() {
        String mov;
        if (xMov!=mv.player.xMov && yMov!=mv.player.yMov){
            ia=new Busqueda_Anchura(this,xMov,yMov,
                               mv.player.xMov,
                               mv.player.yMov);
            ia.busqueda();
            mov=ia.pasos.get(proximo_mov);
                actualizarEntidad();
                realizar_Movimiento(mov);
                actualizarEntidad();
        }else{
            lanzar_mensaje(" Adversario atrapó entidad ");
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
    
}
