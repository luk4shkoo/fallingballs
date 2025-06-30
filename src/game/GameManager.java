package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameManager {
    private GameState currentState;
    private Paddle paddle;
    private ArrayList<Ball> balls;
    private ArrayList<Bullet> bullets;
    private Random rand;
    private int score;
    
    public GameManager() {
        currentState = GameState.MENU;
        resetGame();
    }
    
    public void resetGame() {
        paddle = new Paddle(Main.WINDOW_WIDTH / 2 - 30, 60, 10);
        balls = new ArrayList<>();
        bullets = new ArrayList<>();
        rand = new Random();
        score = 0;
    }
    
    private Ball createRandomBall() {
        int x = rand.nextInt(Main.WINDOW_WIDTH - 20);
        int type = rand.nextInt(100);
        
        if (type < 40) {  // 40% chance
            return new NormalBall(x, 0);
        } else if (type < 60) {  // 20% chance
            return new FastBall(x, 0);
        } else if (type < 75) {  // 15% chance
            return new SplitBall(x, 0);
        } else if (type < 85) {  // 10% chance
            return new ToughBall(x, 0);
        } else if (type < 93) {  // 8% chance
            return new BouncingNormalBall(x, 0);
        } else {  // 7% chance
            return new ExplodingToughBall(x, 0);
        }
    }
    
    public void update() {
        if (currentState != GameState.PLAYING) return;
        
        
        if (rand.nextInt(20) == 0) {
            balls.add(createRandomBall());
        }
        
        
        for (Ball ball : balls) ball.move();
        for (Bullet bullet : bullets) bullet.move();
        paddle.move();
        
        
        updateGameObjects();
    }
    
    private void updateGameObjects() {
        
        bullets.removeIf(bullet -> bullet.getY() < 0);
        
        
        Iterator<Ball> ballIter = balls.iterator();
        while (ballIter.hasNext()) {
            Ball ball = ballIter.next();
            
            
            if (ball instanceof BouncingNormalBall) {
                if (((BouncingNormalBall) ball).shouldRemove()) {
                    ballIter.remove();
                    continue;
                }
            } else if (ball.getY() > Main.WINDOW_HEIGHT) {
                ballIter.remove();
                continue;
            }
            
            if (CollisionManager.checkPaddleCollision(ball, paddle)) {
                currentState = GameState.GAME_OVER;
                return;
            }
        }
        
        
        CollisionManager.checkBulletBallCollisions(this);
    }
    
    
    public GameState getCurrentState() { return currentState; }
    public void setCurrentState(GameState state) { currentState = state; }
    public Paddle getPaddle() { return paddle; }
    public ArrayList<Ball> getBalls() { return balls; }
    public ArrayList<Bullet> getBullets() { return bullets; }
    public int getScore() { return score; }
    public void addScore(int points) { score += points; }
    
    public void addBullet(int x, int y, int speed) {
        bullets.add(new Bullet(x, y, speed));
    }
    
    
    public void addBalls(Ball[] newBalls) {
        if (newBalls != null) {
            for (Ball ball : newBalls) {
                if (ball != null) {
                    balls.add(ball);
                }
            }
        }
    }
} 