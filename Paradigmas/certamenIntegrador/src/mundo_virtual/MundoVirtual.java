package mundo_virtual;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MundoVirtual extends Canvas implements Constantes{
    
    //para pintar el lienzo
    public Escenario escenario;
    //public Entidad_Anchura entidad;
    //public Entidad_Profundidad entidad_prof;
    //public Entidad_Estrella entidad_estrella;
    public Adversario adv1,adv2,adv3; //, adv2, adv3;
    public Player player;
    public Policia policia1,policia2,policia3;
    //Doble buffer
    public Graphics gBuffer;
    public Image imag;
    
    public MundoVirtual(){
        
        escenario=new Escenario();
        //entidad=new Entidad_Anchura(0,1,this);
        //entidad_prof=new Entidad_Profundidad(0,0,this);
        //entidad_estrella=new Entidad_Estrella(0,1,this);
        adv1=new Adversario(8,8,this);
        adv2=new Adversario(9,8,this);
        adv3=new Adversario(10,8,this);
        player=new Player(9,18,this);
        policia1=new Policia(4,3,this);
        policia2=new Policia(9,3,this);
        policia3=new Policia(14,3,this);
        //ent2=new Entidad(0,0);
        //se indican donde estarán los obstaculos
        crearLaberinto();
        
        
        //color de fondo
        this.setBackground(Color.orange);
        this.setFocusable(true); //queremos que escuches en este elemento
        
        addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent evt) {
              identificar_Tecla_Pulsada(evt);
              repaint();
           }
        });
    
    }
    
    private void crearLaberinto() {
        
        for (int i = 0; i < NUMERO_CELDAS_ANCHO; i++) {
            for (int j = 0; j < NUMERO_CELDAS_LARGO; j++) {
                if (i == 0 || j == 0) {
                    escenario.celdas[i][j].tipo=PARED;
                }
                if (i == NUMERO_CELDAS_ANCHO - 1 || j == NUMERO_CELDAS_LARGO - 1) {
                    escenario.celdas[i][j].tipo=PARED;
                }
            }
        }

        escenario.celdas[9][1].tipo=PARED;
        escenario.celdas[2][2].tipo=PARED;
        escenario.celdas[3][2].tipo=PARED;
        escenario.celdas[5][2].tipo=PARED;
        escenario.celdas[6][2].tipo=PARED;
        escenario.celdas[7][2].tipo=PARED;
        escenario.celdas[9][2].tipo=PARED;
        escenario.celdas[11][2].tipo=PARED;
        escenario.celdas[12][2].tipo=PARED;
        escenario.celdas[13][2].tipo=PARED;
        escenario.celdas[15][2].tipo=PARED;
        escenario.celdas[16][2].tipo=PARED;
        escenario.celdas[2][4].tipo=PARED;
        escenario.celdas[3][4].tipo=PARED;
        escenario.celdas[5][4].tipo=PARED;
        escenario.celdas[7][4].tipo=PARED;
        escenario.celdas[8][4].tipo=PARED;
        escenario.celdas[9][4].tipo=PARED;
        escenario.celdas[10][4].tipo=PARED;
        escenario.celdas[11][4].tipo=PARED;
        escenario.celdas[13][4].tipo=PARED;
        escenario.celdas[15][4].tipo=PARED;
        escenario.celdas[16][4].tipo=PARED;
        escenario.celdas[5][5].tipo=PARED;
        escenario.celdas[9][5].tipo=PARED;
        escenario.celdas[13][5].tipo=PARED;
        escenario.celdas[0][6].tipo=PARED;
        escenario.celdas[1][6].tipo=PARED;
        escenario.celdas[2][6].tipo=PARED;
        escenario.celdas[3][6].tipo=PARED;
        escenario.celdas[5][6].tipo=PARED;
        escenario.celdas[6][6].tipo=PARED;
        escenario.celdas[7][6].tipo=PARED;
        escenario.celdas[9][6].tipo=PARED;
        escenario.celdas[11][6].tipo=PARED;
        escenario.celdas[12][6].tipo=PARED;
        escenario.celdas[13][6].tipo=PARED;
        escenario.celdas[15][6].tipo=PARED;
        escenario.celdas[16][6].tipo=PARED;
        escenario.celdas[17][6].tipo=PARED;
        escenario.celdas[0][7].tipo=PARED;
        escenario.celdas[1][7].tipo=PARED;
        escenario.celdas[2][7].tipo=PARED;
        escenario.celdas[3][7].tipo=PARED;
        escenario.celdas[5][7].tipo=PARED;
        escenario.celdas[13][7].tipo=PARED;
        escenario.celdas[15][7].tipo=PARED;
        escenario.celdas[16][7].tipo=PARED;
        escenario.celdas[17][7].tipo=PARED;
        escenario.celdas[7][8].tipo=PARED;
        escenario.celdas[11][8].tipo=PARED;
        escenario.celdas[5][9].tipo=PARED;
        escenario.celdas[7][9].tipo=PARED;
        escenario.celdas[8][9].tipo=PARED;
        escenario.celdas[9][9].tipo=PARED;
        escenario.celdas[10][9].tipo=PARED;
        escenario.celdas[11][9].tipo=PARED;
        escenario.celdas[13][9].tipo=PARED;
        escenario.celdas[0][10].tipo=PARED;
        escenario.celdas[1][10].tipo=PARED;
        escenario.celdas[2][10].tipo=PARED;
        escenario.celdas[3][10].tipo=PARED;
        escenario.celdas[5][10].tipo=PARED;
        escenario.celdas[13][10].tipo=PARED;
        escenario.celdas[15][10].tipo=PARED;
        escenario.celdas[16][10].tipo=PARED;
        escenario.celdas[17][10].tipo=PARED;
        escenario.celdas[0][11].tipo=PARED;
        escenario.celdas[1][11].tipo=PARED;
        escenario.celdas[2][11].tipo=PARED;
        escenario.celdas[3][11].tipo=PARED;
        escenario.celdas[5][11].tipo=PARED;
        escenario.celdas[6][11].tipo=PARED;
        escenario.celdas[7][11].tipo=PARED;
        escenario.celdas[9][11].tipo=PARED;
        escenario.celdas[11][11].tipo=PARED;
        escenario.celdas[12][11].tipo=PARED;
        escenario.celdas[13][11].tipo=PARED;
        escenario.celdas[15][11].tipo=PARED;
        escenario.celdas[16][11].tipo=PARED;
        escenario.celdas[17][11].tipo=PARED;
        escenario.celdas[9][12].tipo=PARED;
        escenario.celdas[2][13].tipo=PARED;
        escenario.celdas[3][13].tipo=PARED;
        escenario.celdas[5][13].tipo=PARED;
        escenario.celdas[6][13].tipo=PARED;
        escenario.celdas[7][13].tipo=PARED;
        escenario.celdas[9][13].tipo=PARED;
        escenario.celdas[11][13].tipo=PARED;
        escenario.celdas[12][13].tipo=PARED;
        escenario.celdas[13][13].tipo=PARED;
        escenario.celdas[15][13].tipo=PARED;
        escenario.celdas[16][13].tipo=PARED;
        escenario.celdas[3][14].tipo=PARED;
        escenario.celdas[15][14].tipo=PARED;
        escenario.celdas[1][15].tipo=PARED;
        escenario.celdas[3][15].tipo=PARED;
        escenario.celdas[5][15].tipo=PARED;
        escenario.celdas[7][15].tipo=PARED;
        escenario.celdas[8][15].tipo=PARED;
        escenario.celdas[9][15].tipo=PARED;
        escenario.celdas[10][15].tipo=PARED;
        escenario.celdas[11][15].tipo=PARED;
        escenario.celdas[13][15].tipo=PARED;
        escenario.celdas[15][15].tipo=PARED;
        escenario.celdas[17][15].tipo=PARED;
        escenario.celdas[5][16].tipo=PARED;
        escenario.celdas[9][16].tipo=PARED;
        escenario.celdas[13][16].tipo=PARED;
        escenario.celdas[2][17].tipo=PARED;
        escenario.celdas[3][17].tipo=PARED;
        escenario.celdas[4][17].tipo=PARED;
        escenario.celdas[5][17].tipo=PARED;
        escenario.celdas[6][17].tipo=PARED;
        escenario.celdas[7][17].tipo=PARED;
        escenario.celdas[9][17].tipo=PARED;
        escenario.celdas[11][17].tipo=PARED;
        escenario.celdas[12][17].tipo=PARED;
        escenario.celdas[13][17].tipo=PARED;
        escenario.celdas[14][17].tipo=PARED;
        escenario.celdas[15][17].tipo=PARED;
        escenario.celdas[16][17].tipo=PARED;
        
    }
    
    public void identificar_Tecla_Pulsada( KeyEvent evento ) {
 
       switch( evento.getKeyCode() ) {

          case KeyEvent.VK_UP:
             System.out.println("Mover arriba");
             player.moverArriba();
          break;

          case KeyEvent.VK_DOWN:
             System.out.println("Mover abajo");
             player.moverAbajo();
          break;

          case KeyEvent.VK_LEFT:
             System.out.println("Mover izquierda");
             player.moverIzquierda();
          break;

          case KeyEvent.VK_RIGHT:
             System.out.println("Mover derecha");
             player.moverDerecha();
          break;

       }
    }
    
    @Override
    public void update(Graphics g) {
      
       if(gBuffer==null){
          imag=createImage(this.getWidth(),this.getHeight());
          gBuffer=imag.getGraphics();
       }
       gBuffer.setColor(getBackground());
       gBuffer.fillRect(0,0,this.getWidth(),this.getHeight());
       adv1.paintCelda(gBuffer);
       adv2.paintCelda(gBuffer);
       adv3.paintCelda(gBuffer);
       policia1.paintCelda(gBuffer);
       policia2.paintCelda(gBuffer);
       policia3.paintCelda(gBuffer);
       //entidad_estrella.paintCelda(gBuffer);
       player.paintComponent(gBuffer);
       //entidad_prof.paintCelda(gBuffer);
       //entidad_estrella.paintCelda(gBuffer);
       
       //adv1.paintCelda(gBuffer);
       //adv2.paintCelda(gBuffer);
       //adv3.paintCelda(gBuffer);
       escenario.paintEscenario(gBuffer);  
       //transfiere la imagen al contexto gráfico del applet
       g.drawImage(imag, 0, 0, null);  
      
    }
    
    @Override
    public void paint(Graphics g) {
       adv1.paintCelda(g);
       adv2.paintCelda(g);
       adv3.paintCelda(g);
       policia1.paintCelda(g);
       policia2.paintCelda(g);
       policia3.paintCelda(g);
       //entidad_estrella.paintCelda(g);
       player.paintComponent(g);
       //entidad_prof.paintCelda(g);
       //entidad_estrella.paintCelda(g);
       
       //adv2.paintCelda(g);
       //adv3.paintCelda(g);
       escenario.paintEscenario(g);
    }
      
}
