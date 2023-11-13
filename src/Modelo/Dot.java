
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author joao_
 * meu pau na tua mao
 */
public class Dot extends Personagem implements Serializable{

        public Dot(String sNomeImagePNG) {
            super(sNomeImagePNG);
            this.bMortal = true;
            this.bTransponivel = true;
        }

        
}
