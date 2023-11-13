package Controler;

import Modelo.GhostSober;
import Modelo.GhostDrunk;
import Modelo.Wall;
import Modelo.Personagem;
import Modelo.Dot;
import Modelo.Hero;
import Modelo.Ghost;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import auxiliar.Posicao;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;

public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hero;
    private ArrayList<Personagem> faseAtual;
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;

    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<Personagem>();

        /*Cria faseAtual adiciona personagens*/
        hero = Ghost.hero1;
        hero.setPosicao(20, 13);
        this.addPersonagem(hero);
        
       // Cria pontos * NÂO MEXER * 
for (int i = 0; i < Consts.RES; i++){
            for (int j = 0; j < Consts.RES; j++){
                
                Dot dot = new Dot ("Dot.png");
                dot.setPosicao(i,j);
                this.addPersonagem(dot);
               
            }
        }







        //Cria paredes * Depende do Level *
        
        //Paredes Horizontais
        
        
        
        for (int j = 2; j < 11; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(23, j);
            this.addPersonagem(brick);
               
        }

        for (int j = 14; j < 23; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(23, j);
            this.addPersonagem(brick);
               
        }

        for (int j = 10; j < 15; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(18, j);
            this.addPersonagem(brick);
               
        }
        
        for (int j = 9; j < 16; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(14, j);
            this.addPersonagem(brick);
               
        }
        
        for (int j = 1; j < 5; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(14, j);
            this.addPersonagem(brick);
               
        }
        
        for (int j = 20; j < 24; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(14, j);
            this.addPersonagem(brick);
               
        }
        
         for (int j = 3; j < 7; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(9, j);
            this.addPersonagem(brick);
               
        }   
         
         for (int j = 18; j < 22; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(9, j);
            this.addPersonagem(brick);
               
        }
         
        for (int j = 9; j < 16; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(6, j);
            this.addPersonagem(brick);
               
        }
        
        for (int j = 2; j < 5; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(5, j);
            this.addPersonagem(brick);
               
        }
        
        for (int j = 20; j < 23; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(5, j);
            this.addPersonagem(brick);
               
        }
        
        for (int j = 2; j < 5; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(1, j);
            this.addPersonagem(brick);
               
        }

         for (int j = 20; j < 23; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(1, j);
            this.addPersonagem(brick);
               
        }
         
         for (int j = 9; j < 10; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(11, j);
            this.addPersonagem(brick);
               
        }
         
         for (int j = 15; j < 16; j++){
                
            Wall brick = new Wall ("horizontalWall.png");
            brick.setPosicao(11, j);
            this.addPersonagem(brick);
               
        }
         
         
         
         
         
         //Paredes Verticais
         
        for (int i = 2; i < 5; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 1);
            this.addPersonagem(brick);
               
        } 
        for (int i = 5; i < 6; i++){
                
           Wall brick = new Wall ("curveWallRightUnder.png");
            brick.setPosicao(i, 1);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 1; i < 2; i++){
                
           Wall brick = new Wall ("curveWallRight.png");
            brick.setPosicao(i, 1);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 1; i < 2; i++){
                
           Wall brick = new Wall ("curveWallLeft.png");
            brick.setPosicao(i, 5);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 5; i < 6; i++){
                
           Wall brick = new Wall ("curveWallLeftUnder.png");
            brick.setPosicao(i, 5);
            this.addPersonagem(brick);
               
        }
        
       
        
        for (int i = 20; i < 23; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 1);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 11; i < 18; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 0);
            this.addPersonagem(brick);
               
        }
        
        
        for (int i = 7; i < 12; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 2);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 17; i < 22; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 4);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 2; i < 5; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 5);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 4; i < 6; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 8);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 12; i < 14; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 8);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 19; i < 21; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 9);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 7; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 12);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 19; i < 21; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 15);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 4; i < 6; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 16);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 12; i < 14; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 16);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 2; i < 5; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 19);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 17; i < 22; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 20);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 7; i < 12; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 22);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 2; i < 5; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 23);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 20; i < 23; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 23);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 11; i < 18; i++){
                
            Wall brick = new Wall ("verticalWall.png");
            brick.setPosicao(i, 24);
            this.addPersonagem(brick);
               
        }
        
        
        //Paredes curvas 
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallRight.png");
            brick.setPosicao(1, 19);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallRight.png");
            brick.setPosicao(11, 8);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallRight.png");
            brick.setPosicao(18, 9);
            this.addPersonagem(brick);
               
        }
        
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallLeft.png");
            brick.setPosicao(18, 15);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallLeft.png");
            brick.setPosicao(11, 16);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallLeft.png");
            brick.setPosicao(1, 23);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallLeftUnder.png");
            brick.setPosicao(6, 16);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallLeftUnder.png");
            brick.setPosicao(14, 16);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallLeftUnder.png");
            brick.setPosicao(5, 23);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallLeftUnder.png");
            brick.setPosicao(23, 23);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallRightUnder.png");
            brick.setPosicao(23, 1);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallRightUnder.png");
            brick.setPosicao(6, 8);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallRightUnder.png");
            brick.setPosicao(14, 8);
            this.addPersonagem(brick);
               
        }
        
        for (int i = 0; i < 1; i++){
                
           Wall brick = new Wall ("curveWallRightUnder.png");
            brick.setPosicao(5, 19);
            this.addPersonagem(brick);
               
        }
        
        
        
        
        
        
        
        
        
        
        
        
        GhostSober vermelho = new GhostSober ("FantasmaVermelho.png");
        vermelho.setPosicao(13, 12);
        this.addPersonagem(vermelho);
        
        GhostDrunk laranjo = new GhostDrunk ("FantasmaAzul.png");
        laranjo.setPosicao(13, 13);
        this.addPersonagem(laranjo);
        
        GhostSober roso = new GhostSober ("FantasmaRosa.png");
        roso.setPosicao(13, 14);
        this.addPersonagem(roso);
        
        GhostDrunk marrom = new GhostDrunk ("FantasmaLaranja.png");
        marrom.setPosicao(0, 20);
        this.addPersonagem(marrom);
        
        
        
        
        
        
        
    }

    public boolean ehPosicaoValida(Posicao p){
        return cj.ehPosicaoValida(this.faseAtual, p);
    }
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /*************Desenha cenário de fundo**************/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "blackBrick.png");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
//         // Desenha os pontos na tela
//        for (int i = 0; i < Consts.RES; i++) {
//            for (int j = 0; j < Consts.RES; j++) {
//                Dot dot = new Dot("dot.png");
//                dot.setPosicao(i, j);
//                this.addPersonagem(dot);               
//            }
//        }


        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            this.cj.processaTudo(faseAtual);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.faseAtual.clear();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.moveRight();
        }

        this.setTitle("-> Cell: " + (hero.getPosicao().getColuna()) + ", "
                + (hero.getPosicao().getLinha()));

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
