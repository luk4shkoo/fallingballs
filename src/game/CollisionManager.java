package game;

import java.util.ArrayList;
import java.util.Iterator;

public class CollisionManager {
    public static boolean checkPaddleCollision(Ball ball, Paddle paddle) {
        return ball.getY() + ball.getSize() >= Main.WINDOW_HEIGHT - 50 && 
               ball.getY() <= Main.WINDOW_HEIGHT - 40 &&
               ball.getX() + ball.getSize() >= paddle.getX() && 
               ball.getX() <= paddle.getX() + paddle.getWidth();
    }
    
    public static void checkBulletBallCollisions(GameManager gameManager) {
        ArrayList<Ball> ballsToAdd = new ArrayList<>();
        ArrayList<Ball> ballsToRemove = new ArrayList<>();
        ArrayList<Bullet> bulletsToRemove = new ArrayList<>();
        
        // Check collisions
        for (Bullet bullet : gameManager.getBullets()) {
            for (Ball ball : gameManager.getBalls()) {
                if (checkBulletBallCollision(bullet, ball)) {
                    Ball[] newBalls = ball.onHit(gameManager);
                    if (newBalls == null) {
                        ballsToRemove.add(ball);
                    } else if (newBalls.length > 0) {
                        for (Ball newBall : newBalls) {
                            ballsToAdd.add(newBall);
                        }
                        ballsToRemove.add(ball);
                    }
                    bulletsToRemove.add(bullet);
                    break;
                }
            }
        }
        
        // Apply changes
        gameManager.getBalls().removeAll(ballsToRemove);
        gameManager.getBullets().removeAll(bulletsToRemove);
        gameManager.getBalls().addAll(ballsToAdd);
    }
    
    private static boolean checkBulletBallCollision(Bullet bullet, Ball ball) {
        return bullet.getX() >= ball.getX() && 
               bullet.getX() <= (ball.getX() + ball.getSize()) &&
               bullet.getY() >= ball.getY() && 
               bullet.getY() <= (ball.getY() + ball.getSize());
    }
} 