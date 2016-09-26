package Game;

import java.awt.Image;
import javax.swing.*;

public class Jogador {
    
    //Variáveis para localização do jogador e armazenamento do ícone do jogador.
    private int tileX, tileY;
    private Image imgJogador;
    
    public Jogador(){
        //Recebe o ícone do jogador
        ImageIcon img = new ImageIcon("icons\\jogador.png");
        imgJogador = img.getImage();
        
            //Inicia o jogador na posição (1,1)
        tileX = 1;
        tileY = 1;
    }
    
    //Função para movimento do jogador, adiciona o X e Y ao local do jogador
    public void move(int tileX, int tileY ){
        this.tileX += tileX;
        this.tileY += tileY;
    }
    
    public void Reset(){
        tileX = 1;
        tileY = 1;
    }
    
    //Gets 
    public Image getJogador(){
        return imgJogador;
    }
    
    public int getTileX(){
        return tileX;
    }
    public int getTileY(){
        return tileY;
    }
    
}
