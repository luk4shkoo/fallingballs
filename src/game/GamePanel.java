package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private GameManager gameManager;
    private Timer timer;
    
    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        setPreferredSize(new Dimension(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        
        gameManager = new GameManager();
        timer = new Timer(30, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        switch (gameManager.getCurrentState()) {
            case MENU:
                UIRenderer.drawMenu(g);
                break;
            case PLAYING:
                UIRenderer.drawGame(g, gameManager);
                break;
            case GAME_OVER:
                UIRenderer.drawGameOver(g, gameManager.getScore());
                break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        gameManager.update();
        repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (gameManager.getCurrentState()) {
            case MENU:
            case GAME_OVER:
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    gameManager.setCurrentState(GameState.PLAYING);
                    gameManager.resetGame();
                }
                break;
                
            case PLAYING:
                handlePlayingKeyPress(e);
                break;
        }
    }
    
    private void handlePlayingKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gameManager.getPaddle().setMovingLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                gameManager.getPaddle().setMovingRight(true);
                break;
            case KeyEvent.VK_SPACE:
                gameManager.addBullet(
                    gameManager.getPaddle().getX() + gameManager.getPaddle().getWidth()/2 - 2,
                    Main.WINDOW_HEIGHT - 60,
                    10
                );
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (gameManager.getCurrentState() == GameState.PLAYING) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                gameManager.getPaddle().setMovingLeft(false);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                gameManager.getPaddle().setMovingRight(false);
            }
        }
    }
    
    @Override 
    public void keyTyped(KeyEvent e) {}
}