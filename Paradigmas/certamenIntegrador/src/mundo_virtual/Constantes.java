package mundo_virtual;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public interface Constantes {
    //tamaño de la celda
    public final int PIXELS=32;
    //el ancho de la celda
    public final int NUMERO_CELDAS_ANCHO=19;
    //largo de la celda
    public final int NUMERO_CELDAS_LARGO=20;
    //desplazamiento
    public final int ANCHO_BORDE_VENTANA=30;
    public final int LARGO_BORDE_VENTANA=50;
    public final int DESPLAZAMIENTO=10;
    
    public final int ANCHURA_ESCENARIO=(PIXELS*NUMERO_CELDAS_ANCHO)+
            ANCHO_BORDE_VENTANA;
    public final int LARGO_ESCENARIO=(PIXELS*NUMERO_CELDAS_LARGO)+
            LARGO_BORDE_VENTANA;
    
    //para la interaccion
    public final char PARED='O';
    public final char CAMINO='C';
    public final char DESTINO='D';
    public final char ADVERSARIO='A';
    public final char PLAYER='J';
    public final char POLICIA='P';
    
    public final char EXPLORADO='E';
    public final Color COLOR_EXPLORADO=new Color(246,51,255,0x53);
    
    default void lanzar_mensaje(String mensaje) {
          JOptionPane.showMessageDialog(null,
            mensaje,
            "Mundo Virtual",
             JOptionPane.PLAIN_MESSAGE);
    }

    public final Font FUENTE=new Font("Times New Roman",Font.BOLD,18);

}

