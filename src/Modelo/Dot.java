/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author joao_
 */
public class Dot extends Personagem implements Serializable{

        public Dot(String sNomeImagePNG) {
            super(sNomeImagePNG);
            this.bMortal = true;
            this.bTransponivel = true;
        }

        
}
