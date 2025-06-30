package game;

import java.awt.*;

public class Paddle {
    private int x, width, height, speed;
    private boolean movingLeft, movingRight;
    
    public Paddle(int x, int width, int height) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.speed = 10;
        this.movingLeft = false;
        this.movingRight = false;
    }
    
    public void move() {
        if (movingLeft && x > 0) x -= speed;
        if (movingRight && x < Main.WINDOW_WIDTH - width) x += speed;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, Main.WINDOW_HEIGHT - 50, width, height);
    }
    
    public void setMovingLeft(boolean moving) { movingLeft = moving; }
    public void setMovingRight(boolean moving) { movingRight = moving; }
    public int getX() { return x; }
    public int getWidth() { return width; }
} 