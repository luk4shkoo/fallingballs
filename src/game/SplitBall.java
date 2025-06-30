package game;

import java.awt.Color;

/**
 * Reprezentuje lopticky, ktora sa pri zasahu rozdeli na mensie lopticky.
 * Po zasahu vytvori dve nove mensie lopticky pohybujuce sa do stran.
 */
public class SplitBall extends Ball {
    /**
     * Vytvori novu deliacu sa lopticky s vlastnou velkostou a rychlostou.
     *
     * @param x horizontalna pozicia lopticky
     * @param y vertikalna pozicia lopticky
     * @param size velkost lopticky
     * @param speed rychlost lopticky
     */
    public SplitBall(int x, int y, int size, int speed) {
        super(x, y, size, speed, new Color(148, 0, 211), 15); // Purple color
    }
    
    /**
     * Spracuje zasah lopticky projektilom.
     * Ak je lopticka dostatocne velka, rozdeli sa na dve mensie.
     *
     * @param gameManager spravca hernej logiky
     * @return pole novych lopticiek vzniknutych rozdelenim
     */
    @Override
    public Ball[] onHit(GameManager gameManager) {
        super.onHit(gameManager);
        
        // Only split if the ball is not too small
        if (size <= 15) return null;
        
        // Create two smaller split balls
        return new Ball[] {
            new SplitBall(x - 5, y, size - 5, speed + 1),
            new SplitBall(x + 5, y, size - 5, speed + 1)
        };
    }
    
    /**
     * Vytvori novu deliacu sa lopticky so standardnou velkostou.
     *
     * @param x horizontalna pozicia lopticky
     * @param y vertikalna pozicia lopticky
     */
    public SplitBall(int x, int y) {
        this(x, y, 25, 2);
    }
} 