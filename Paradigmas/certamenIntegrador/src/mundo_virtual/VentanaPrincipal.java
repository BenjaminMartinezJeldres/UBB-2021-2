package mundo_virtual;

import java.util.Timer;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements Constantes{
    
    //nuestra clase se compone de un lienzo de dibujo (herada de canvas)
    public MundoVirtual mundo_virtual;
    public Timer lanzador_Tareas;
    
    //constructor
    public VentanaPrincipal() {
        mundo_virtual=new MundoVirtual();
        this.getContentPane().add(mundo_virtual);
        //el tamaño de la venta es la del escenario y el incremento de los bordes
        this.setSize(ANCHURA_ESCENARIO,LARGO_ESCENARIO); 
        
        /*mundo_virtual.adv1.inteligencia();
        mundo_virtual.adv2.inteligencia();
        mundo_virtual.adv3.inteligencia();*/
        //mundo_virtual.entidad_estrella.inteligencia();
        //mundo_virtual.entidad_prof.inteligencia();
        //mundo_virtual.entidad_estrella.inteligencia();
        lanzador_Tareas=new Timer();
        /*lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.adv1,0,1000);
        lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.adv2,0,1000);
        lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.adv3,0,1000);*/
        /*lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.entidad_prof,0,1000);
         lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.entidad_estrella,0,1000);
        lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.adv1,0,100);
        lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.adv2,0,100);
        lanzador_Tareas.
                scheduleAtFixedRate(mundo_virtual.adv3,0,100);*/
         
    }

    public void setVisible(boolean b) {
    }
}