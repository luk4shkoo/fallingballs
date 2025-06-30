package game;

import java.awt.*;

public abstract class Ball {
    protected int x, y, size, speed;
    protected Color color;
    protected int points;
    
    public Ball(int x, int y, int size, int speed, Color color, int points) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.color = color;
        this.points = points;
    }
    
    public void move() {
        y += speed;
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
    
    
    public Ball[] onHit(GameManager gameManager) {
        gameManager.addScore(points);
        return null; 
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }
    public int getPoints() { return points; }
} 