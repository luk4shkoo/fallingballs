package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Reprezentuje odolnu lopticky v hre.
 * Vyzaduje viac zasahov na znicenie a meni farbu po prvom zasahu.
 */
public class ToughBall extends Ball {
    private int hits;
    
    /**
     * Vytvori novu odolnu lopticky.
     *
     * @param x horizontalna pozicia lopticky
     * @param y vertikalna pozicia lopticky
     */
    public ToughBall(int x, int y) {
        super(x, y, 20, 2, Color.GREEN, 25);
        hits = 0;
    }
    
    /**
     * Spracuje zasah lopticky projektilom.
     * Pri prvom zasahu zmeni farbu na tmavsiu, pri druhom sa znici.
     *
     * @param gameManager spravca hernej logiky
     * @return pole novych lopticiek (prazdne pole ak sa lopticka neznici)
     */
    @Override
    public Ball[] onHit(GameManager gameManager) {
        hits++;
        if (hits >= 2) {
            return super.onHit(gameManager);
        }
        
        color = new Color(0, 100, 0);
        return new Ball[0]; // Return empty array to indicate ball should not be destroyed
    }
    
    /**
     * Vykresli lopticky s efektom poskodenia po prvom zasahu.
     *
     * @param g graficky kontext pre vykreslenie
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (hits > 0) {
            
            g.setColor(Color.WHITE);
            g.drawLine(x + size/4, y + size/4, x + 3*size/4, y + 3*size/4);
        }
    }
} 