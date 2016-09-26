package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    //Variável de relógio, mapa e jogador das classes usadas.
    private Timer timer;
    private Mapa mapa;
    private Jogador jog;
    //Variável que adiciona número de jogadas
    private int jogadas = 0;
    private Image imgif;
    
    
    
    public  Board(){ 
        //Novo Mapa() e Jogador()
        mapa = new Mapa();
        jog = new Jogador();
        //Uso das teclas 
        addKeyListener(new Al());
        //Focus ao Board
        setFocusable(true);//?
        
        //Relógio de 25ms em 25ms para checagem de ações
        timer = new Timer(25, this);
        timer.start();
        
        
    }
    
        //Checa de 25ms em 25ms
    public void actionPerformed(ActionEvent e) {
        //Checa se jogador chegou ao final da fase
        if ( mapa.getMapa( jog.getTileX(), jog.getTileY() ).equals("c") ){ //c?
            JOptionPane.showMessageDialog(null, "texto da caixa","titulo da caixa",
            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\Walter Santos\\Documents\\NetBeansProjects\\MazeRunner-master\\MazeRunner\\src\\Game\\jogador.png"));
            
            
        }
        
        
        
        //Muda os icones de lugares caso haja movimento 
        repaint();
    }
    
    public void paint(Graphics g){
        super.paint(g);
        //"Pinta" os blocos com paredes, caminho e o final da fase.
        for ( int y = 0; y < 14; y++ ){
            for ( int x = 0; x < 14; x++ ){
                if ( mapa.getMapa(x, y).equals( "g" ) ){
                    g.drawImage( mapa.getCaminho(), x * 32, y * 32, null );
                }
                
                if ( mapa.getMapa(x, y).equals( "w" ) ){
                    g.drawImage( mapa.getParede(), x * 32, y * 32, null );
                }
                
                if ( mapa.getMapa(x, y).equals( "c" ) ){
                    g.drawImage( mapa.getChegada(), x * 32, y * 32, null );
                }
            }
        } 
        //"Pinta" o jogador na posição (1,1)*32
        g.drawImage(jog.getJogador(), jog.getTileX() * 32, jog.getTileY() * 32, null);
    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Classe para movimento do jogador
    public class Al extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int teclaChave = e.getKeyCode();
            
            //Caso usuário aperte W, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_W ){
                if (!mapa.getMapa( jog.getTileX(), jog.getTileY() - 1).equals("w") ){
                jog.move(0, -1);
                jogadas++;
                }
            }
            //Caso usuário aperte S, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_S ){
                if (!mapa.getMapa( jog.getTileX(), jog.getTileY() + 1).equals("w") ){
                jog.move(0, 1);
                jogadas++;
                }
            }
            //Caso usuário aperte D, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_D ){
                if (!mapa.getMapa( jog.getTileX() + 1, jog.getTileY() ).equals("w") ){
                jog.move(1, 0);
                jogadas++;
                }
            }
            //Caso usuário aperte A, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_A ){
                if (!mapa.getMapa( jog.getTileX() - 1, jog.getTileY() ).equals("w") ){
                jog.move(-1, 0);
                jogadas++;
                }
            }
        }       
    }
}
