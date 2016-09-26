package Game;

import javax.swing.*;

public class Maze {   
    //Quando classe Maze for chamada...
    public Maze(){
        //Cria novo JFrame e adiciona um título novo JFrame
        JFrame frame = new JFrame();
        frame.setTitle( "Super Mario Maze - Versão 0.8" );
        //Adiciona o panel Board ao JFrame.
        frame.add(new Board());
        /* Seta tamanhos. Janela deverá ficar no centro da tela.
        JFrame com novo JPanel visível. Caso usuário aperte "x" o JFrame se encerra. */
        frame.setSize(464, 485);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}