/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 *
 * @author serii
 */
public class Game extends JFrame{
    private static Game game_game;
    private static long last_frame_time;
    private static Image aiWu;
    private static Image squre;
    private static Image end;
    private static float drop_left = 500;
    private static float drop_top = -700;
    private static float drop_v = 150;
    private static int score = 0;
            
    

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        squre = ImageIO.read(Game.class.getResourceAsStream("squre.png"));
        aiWu = ImageIO.read(Game.class.getResourceAsStream("aiWu.jpg"));
        end = ImageIO.read(Game.class.getResourceAsStream("end.jpg"));  

        game_game = new Game ();
        game_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_game.setLocation(0, 10);
        game_game.setSize(1920, 900);
        game_game.setResizable(false);
        last_frame_time = System.nanoTime();
        GameField game_field = new GameField();
        game_game.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float drop_right = drop_left + end.getWidth(null);
                float drop_bottom = drop_top + end.getHeight(null);
                boolean is_drop = x >= drop_left && x <= drop_right && y >= drop_top && y <= drop_bottom;
                
                if (is_drop) {
                    drop_top = -100;        
                    drop_top = (int)(Math.random() * (game_field.getWidth() - end.getWidth(null)));
                    drop_v = drop_v + 10;
                    score++;
                    game_game.setTitle("Score: " + score);
                }
            }
        });
        game_game.add(game_field);
        game_game.setVisible(true);
    }
    
    private static void onRepaint(Graphics g) {
        long current_time = System.nanoTime();
        float delt_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;
        drop_top = drop_top + drop_v * delt_time;
        g.drawImage(aiWu, 0, 0, null);    
        g.drawImage(squre, (int) drop_left, (int) drop_top, null);
        if(drop_top > game_game.getHeight())g.drawImage(end, 0, 50, null);
    }
    
    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }     

}
