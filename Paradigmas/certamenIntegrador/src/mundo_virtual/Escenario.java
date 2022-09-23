package mundo_virtual;

import java.awt.Graphics;

/**
 *
 * @author klemenzza
 */
public class Escenario implements Constantes {
    
    public Celda[][] celdas;
    
    public Escenario() {
        
      celdas=new Celda[NUMERO_CELDAS_ANCHO][NUMERO_CELDAS_LARGO];
      //inicializar el array de celdas
      for(int i=0; i < NUMERO_CELDAS_ANCHO; i++) {
         for ( int j=0 ; j <  NUMERO_CELDAS_LARGO ; j++) {
             
            celdas[i][j]=new Celda(i*PIXELS+DESPLAZAMIENTO,
                                   j*PIXELS+DESPLAZAMIENTO,CAMINO);
            
         }
      }
    }
    
    public void paintEscenario(Graphics g) {
        
        for(int i=0; i < NUMERO_CELDAS_ANCHO ; i++) 
            for ( int j=0 ; j < NUMERO_CELDAS_LARGO; j++) 
              celdas[i][j].paintCelda(g);
        
    }
    
    public Celda darCelda(int xMov,int yMov) {
        Celda resultado=null;
        for(int i=0; i < NUMERO_CELDAS_ANCHO ; i++) 
            for ( int j=0 ; j < NUMERO_CELDAS_LARGO; j++) 
                if ( i==xMov && j==yMov) {
                    resultado=celdas[i][j];
                    break;
                }
        return resultado;
        
    }
}

    
    

