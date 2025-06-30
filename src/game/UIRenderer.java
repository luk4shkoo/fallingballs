package game;

import java.awt.*;

public class UIRenderer {
    private static void centerString(Graphics g, String str, int y) {
        FontMetrics metrics = g.getFontMetrics();
        int x = (Main.WINDOW_WIDTH - metrics.stringWidth(str)) / 2;
        g.drawString(str, x, y);
    }
    
    public static void drawMenu(Graphics g) {
        g.setColor(Color.WHITE);
        
        g.setFont(new Font("Arial", Font.BOLD, 36));
        centerString(g, "FALLING BALLS", Main.WINDOW_HEIGHT / 3);
        
       
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        centerString(g, "Press ENTER to Start", Main.WINDOW_HEIGHT / 2);
    }
    
    public static void drawGame(Graphics g, GameManager gameManager) {
        gameManager.getPaddle().draw(g);
        for (Ball ball : gameManager.getBalls()) ball.draw(g);
        for (Bullet bullet : gameManager.getBullets()) bullet.draw(g);
        
       
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + gameManager.getScore(), 10, 25);
    }
    
    public static void drawGameOver(Graphics g, int score) {
        g.setColor(Color.WHITE);
       
        g.setFont(new Font("Arial", Font.BOLD, 36));
        centerString(g, "GAME OVER", Main.WINDOW_HEIGHT / 3);
        
        
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        centerString(g, "Score: " + score, Main.WINDOW_HEIGHT / 2);
        
        
        centerString(g, "Press ENTER to Play Again", Main.WINDOW_HEIGHT / 2 + 50);
    }
} 