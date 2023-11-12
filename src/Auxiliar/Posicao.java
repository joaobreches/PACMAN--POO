package auxiliar;

import java.io.Serializable;
import java.lang.Math;

public class Posicao  implements Serializable{
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;
    
//    private Posicao PosicaoAnterior = new Posicao(linhaAnterior, colunaAnterior);
//    
//    private Posicao Cima = new Posicao (linha - 1, coluna);
//    private Posicao Baixo = new Posicao (linha + 1, coluna);
//    private Posicao Esquerda = new Posicao (linha, coluna - 1);
//    private Posicao Direita = new Posicao (linha, coluna + 1);
    
  
    
    
    public Posicao(int linha, int coluna){
        this.setPosicao(linha,coluna);
    }
    
       

    public boolean setPosicao(int linha, int coluna){       
        if(linha < 0 || linha >= Auxiliar.Consts.RES)
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if(coluna < 0 || coluna >= Auxiliar.Consts.RES)
            return false;
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        
        return true;
    }
    
    public int getLinha(){
        return linha;
    }
   
    public boolean volta(){
        return this.setPosicao(linhaAnterior,colunaAnterior);
    }

    public int getColuna(){
        return coluna;
    }

    public boolean igual(Posicao posicao){
        return (linha == posicao.getLinha() && coluna == posicao.getColuna());
    }

    public boolean copia(Posicao posicao){
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
    
    
    public boolean moveUp(){
        return this.setPosicao(this.getLinha()-1, this.getColuna());
    }
    public boolean moveDown(){
        return this.setPosicao(this.getLinha()+1, this.getColuna());
    }
    public boolean moveRight(){
        return this.setPosicao(this.getLinha(), this.getColuna()+1);
    }
    public boolean moveLeft(){
        return this.setPosicao(this.getLinha(), this.getColuna()-1);        
    }
}

   
