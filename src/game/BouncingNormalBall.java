package game;

import java.awt.Color;

/**
 * Reprezentuje odrazajucu sa lopticky v hre.
 * Pri naraze na okraj obrazovky sa odrazi a zmeni smer pohybu.
 */
public class BouncingNormalBall extends NormalBall {
    private boolean movingDown = true;
    private int bounceCount = 0;
    private static final int MAX_BOUNCES = 3;
    
    /**
     * Vytvori novu odrazajucu sa lopticky.
     *
     * @param x horizontalna pozicia lopticky
     * @param y vertikalna pozicia lopticky
     */
    public BouncingNormalBall(int x, int y) {
        super(x, y);
        this.color = new Color(255, 100, 100); // Lighter red to distinguish
    }
    
    /**
     * Aktualizuje poziciu lopticky.
     * Pohybuje sa vertikalne nadol a horizontalne podla aktualneho smeru.
     * Pri naraze na okraj obrazovky zmeni smer horizontalneho pohybu.
     */
    @Override
    public void move() {
        if (movingDown) {
            y += speed;
            
            if (y + size >= Main.WINDOW_HEIGHT) {
                movingDown = false;
                bounceCount++;
            }
        } else {
            y -= speed;
            
            if (y <= 0) {
                movingDown = true;
            }
        }
    }
    
    @Override
    public Ball[] onHit(GameManager gameManager) {
      
        gameManager.addScore(points * 2);
        return null;
    }
    
    public boolean shouldRemove() {
        return bounceCount >= MAX_BOUNCES;
    }
} 