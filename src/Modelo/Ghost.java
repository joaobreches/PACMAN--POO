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

public class Ghost extends Personagem implements Serializable{
    
    public static Hero hero1 = new Hero ("pacman.png");
    
    Random random = new Random();
    private int walk = random.nextInt(4) + 1;
    
    
    public Ghost(String sNomeImagePNG) {
        
        super(sNomeImagePNG);
        this.bMortal = true;
    }
    
    public Posicao getCima() {
        return new Posicao(getPosicaoLinha() - 1, getPosicaoColuna());
    }
    
    public Posicao getBaixo() {
        return new Posicao(getPosicaoLinha() + 1, getPosicaoColuna());
    }
    
    public Posicao getEsquerda() {
        return new Posicao(getPosicaoLinha(), getPosicaoColuna() - 1);
    }
    
    public Posicao getDireita() {
        return new Posicao(getPosicaoLinha(), getPosicaoColuna() + 1);
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    
    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }

    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public boolean moveUp() {
        if(super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        if(super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        if(super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft())
            return validaPosicao();
        return false;
    }    
    
    
        public double calcularDistancia(Posicao posicao1, Posicao posicao2){
      
        double distancia_linha = posicao1.getLinha() - posicao2.getLinha();
        double distancia_coluna = posicao1.getColuna() - posicao2.getColuna();
        double distanciaAux =Math.pow(distancia_coluna,2) + Math.pow(distancia_linha,2);
        double distancia = Math.sqrt(distanciaAux);  
        
        return distancia;
    }
    
    
        public void moverParaHero (Hero hero1){
            
            
        double menorDistancia = 1000000000;
        
        double distanciaCima = calcularDistancia(getCima(), hero1.pPosicao);
        double distanciaBaixo = calcularDistancia(getBaixo(), hero1.pPosicao);
        double distanciaEsquerda = calcularDistancia(getEsquerda(), hero1.pPosicao);
        double distanciaDireita = calcularDistancia(getDireita(), hero1.pPosicao);
         
        if (distanciaCima < menorDistancia && Desenho.acessoATelaDoJogo().ehPosicaoValida(getCima())){
            menorDistancia = distanciaCima;
        }
        
        if (distanciaBaixo < menorDistancia && Desenho.acessoATelaDoJogo().ehPosicaoValida(getBaixo())){
            menorDistancia = distanciaBaixo;
        }
        
        if (distanciaEsquerda < menorDistancia && Desenho.acessoATelaDoJogo().ehPosicaoValida(getEsquerda())){
            menorDistancia = distanciaEsquerda;
        }
        
        if (distanciaDireita < menorDistancia && Desenho.acessoATelaDoJogo().ehPosicaoValida(getDireita())){
            menorDistancia = distanciaDireita;
        }
        
        if (menorDistancia == distanciaCima)
            moveUp();
        
        if (menorDistancia == distanciaBaixo)
            moveDown();
        
        if (menorDistancia == distanciaEsquerda)
            moveLeft();
        
        if (menorDistancia == distanciaDireita)
            moveRight();
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
