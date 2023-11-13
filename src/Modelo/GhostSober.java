
package Modelo;

import java.util.Random;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.ControleDeJogo;
import Controler.Tela;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import auxiliar.Posicao;
import Controler.Tela;

public class GhostSober extends Ghost{
    
        Random random = new Random();
        private int walk = random.nextInt(4) + 1;
    
    public GhostSober (String sNomeImagePNG) {
        
        super(sNomeImagePNG);
        this.bMortal = true;
    }
    
    public void autoDesenho(){
        
        moverParaHero(hero1);
        
        walk = random.nextInt(4) + 1;

           //random walk
           switch(walk){
               case 1: moveUp();
               break;

               case 2: moveLeft();
               break;

               case 3: moveRight();
               break;

               case 4: moveDown();
               break;
           }


          super.autoDesenho();
        }
    }
    
