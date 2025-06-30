package game;

import java.awt.*;

public class Bullet {
    private int x, y, speed;
    
    public Bullet(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    
    public void move() {
        y -= speed;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 5, 10);
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
} 