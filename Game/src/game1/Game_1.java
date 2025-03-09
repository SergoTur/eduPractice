/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package game1;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author serii
 */
public class Game_1 extends JFrame {

    /**
     * @param args the command line arguments
     */
    private static Game_1 game_game;
    
    public static void main(String[] args) {
        game_game = new Game_1();
        game_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_game.setLocation(200, 50);
        game_game.setSize(900, 600);
        game_game.setResizable(false);
        GameField game_field = new GameField();
        game_game.add(game_field);
        game_game.setVisible(true);
    }
    
    public static void onRepaint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(50, 50, 400, 200);
    }

    
    public static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
        }
    }
    
}
