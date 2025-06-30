package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Reprezentuje vybuchujucu odolnu lopticky v hre.
 * Pri zniceni vytvori niekolko mensich normalnych lopticiek.
 */
public class ExplodingToughBall extends ToughBall {
    private static final int EXPLOSION_FRAGMENTS = 4;
    
    /**
     * Vytvori novu vybuchujucu odolnu lopticky.
     *
     * @param x horizontalna pozicia lopticky
     * @param y vertikalna pozicia lopticky
     */
    public ExplodingToughBall(int x, int y) {
        super(x, y);
        this.color = new Color(0, 180, 0); // Brighter green to distinguish
        this.points = 40; // More points due to explosion hazard
    }
    
    /**
     * Spracuje zasah lopticky projektilom.
     * Pri zniceni vytvori EXPLOSION_FRAGMENTS novych normalnych lopticiek.
     *
     * @param gameManager spravca hernej logiky
     * @return pole novych lopticiek vzniknutych po vybuchnuti
     */
    @Override
    public Ball[] onHit(GameManager gameManager) {
        Ball[] result = super.onHit(gameManager);
        
        
        if (result == null) {
            
            Ball[] fragments = new Ball[EXPLOSION_FRAGMENTS];
            for (int i = 0; i < EXPLOSION_FRAGMENTS; i++) {
                
                double angle = 2 * Math.PI * i / EXPLOSION_FRAGMENTS;
                int offsetX = (int)(20 * Math.cos(angle));
                int offsetY = (int)(20 * Math.sin(angle));
                fragments[i] = new NormalBall(x + offsetX, y + offsetY);
            }
            return fragments;
        }
        
        return result;
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        
        g.setColor(Color.YELLOW);
        int centerX = x + size/2;
        int centerY = y + size/2;
        g.drawString("!", centerX - 2, centerY + 4);
    }
} 