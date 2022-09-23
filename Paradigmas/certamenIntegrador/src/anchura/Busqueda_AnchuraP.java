/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anchura;

import java.util.ArrayList;
import java.util.Collections;
import static mundo_virtual.Constantes.ADVERSARIO;
import static mundo_virtual.Constantes.NUMERO_CELDAS_ANCHO;
import static mundo_virtual.Constantes.NUMERO_CELDAS_LARGO;
import static mundo_virtual.Constantes.PARED;
import mundo_virtual.Policia;

/**
 *
 * @author klemenzza
 */
public class Busqueda_AnchuraP {
    
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> registroEstados;
    public ArrayList<String> pasos;
    public Estado inicial;
    public Estado meta;
    public Estado actual;
    public boolean exito;
    //
    public Policia ent;
    
    public Busqueda_AnchuraP(Policia ent,int x_o,int y_o,int x_f, int y_f ) {
        this.ent=ent;
        colaEstados=new ArrayList<>();
        registroEstados=new ArrayList<>();
        pasos=new ArrayList<>();
        inicial=new Estado(x_o,y_o,"inicial",null);
        meta=new Estado(x_f,y_f,"",null);
        System.out.println(" ESTADO INICIAL = "+inicial.toString());
        System.out.println(" ESTADO FINAL = "+meta.toString());
        exito=false;
        
    }
    
    public void busqueda () {
        
        if ( inicial.equals(meta)) {
            System.out.println(" inicial es meta");
            exito=true;
            
        }else {
            
            colaEstados.add(inicial);
            registroEstados.add(inicial);
            
            int n_iteraciones=0;
            while ( !colaEstados.isEmpty() && !exito) {
                
                
                actual=colaEstados.get(0);
                System.out.println(" ITERACION ["+n_iteraciones+"] = "+actual.toString());
                //ent.mv.escenario.celdas[actual.x][actual.y].tipo=EXPLORADO;
                
                
                //System.out.println(colaEstados.toString());
                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                   
                }*/
                colaEstados.remove(0);
                procesarSucesores(actual);
                ++n_iteraciones;
                
            }
            
            System.out.println(" Iteraciones anchura = "+n_iteraciones);
           
            
            
        }
        
        
    }
    
    public void procesarSucesores(Estado actual) {
        
        if ( actual.equals(meta)) {
            
            meta=actual;
            reconstruirSolucion();
            exito=true;
            
        }else {
            
            abajo(actual);
            arriba(actual);
            derecha(actual);
            izquierda(actual);
            
        }
        
    }
    
    public void arriba(Estado e) {
        
        if ( e.y > 0 ) {
            
           if ( ent.mv.escenario.celdas[e.x][e.y-1].tipo!=PARED && 
                ent.mv.escenario.celdas[e.x][e.y-1].tipo!=ADVERSARIO) {
            
              Estado arriba=new Estado(e.x,e.y-1,"arriba",e);
            
              if ( !registroEstados.contains(arriba)) {
                colaEstados.add(arriba);
                registroEstados.add(arriba);
              }
            
            
           }
            
        }
       
    }
    public void abajo(Estado e) {
        if ( e.y < NUMERO_CELDAS_LARGO-1 ) {
            
           if ( ent.mv.escenario.celdas[e.x][e.y+1].tipo!=PARED && 
                ent.mv.escenario.celdas[e.x][e.y+1].tipo!=ADVERSARIO) {
            
            Estado abajo=new Estado(e.x,e.y+1,"abajo",e);
        
            if ( !registroEstados.contains(abajo)) {
                colaEstados.add(abajo);
                registroEstados.add(abajo);
            }
            
           }
            
        }
        
    }
    
    public void izquierda(Estado e) {
        if ( e.x > 0) {
            
          if ( ent.mv.escenario.celdas[e.x-1][e.y].tipo!=PARED && 
               ent.mv.escenario.celdas[e.x-1][e.y].tipo!=ADVERSARIO) {
            
             Estado izquierda=new Estado(e.x-1,e.y,"izquierda",e);
        
             if ( !registroEstados.contains(izquierda)) {
                colaEstados.add(izquierda);
                registroEstados.add(izquierda);
             }
          }
          
        }
    }
    
    public void derecha(Estado e) {
        
        if ( e.x < NUMERO_CELDAS_ANCHO-1  ) {
             
          if ( ent.mv.escenario.celdas[e.x+1][e.y].tipo!=PARED && 
               ent.mv.escenario.celdas[e.x+1][e.y].tipo!=ADVERSARIO) {
          
           Estado derecha=new Estado(e.x+1,e.y,"derecha",e);
        
           if ( !registroEstados.contains(derecha)) {
               colaEstados.add(derecha);
                registroEstados.add(derecha);
           }
        
         
          }
          
        }
    }
    
    
    
    
    public void reconstruirSolucion() {
        
        ArrayList<Estado> solucion=new ArrayList<>();
        
        Estado aux=meta;
        while( aux != null) {
            solucion.add(aux);
            aux=aux.pred;
            
        }
        
        Collections.reverse(solucion);
        
        for(int i=0; i < solucion.size(); i++)
            pasos.add(solucion.get(i).mov);
           
        
    }
    
}