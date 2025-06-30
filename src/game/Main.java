package game;

import javax.swing.JFrame;

/**
 * Hlavna trieda aplikacie, ktora spusta hru.
 * Vytvara hlavne okno a inicializuje herny panel.
 */
public class Main {
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 500;
    
    /**
     * Hlavna metoda aplikacie.
     * Vytvara a zobrazuje hlavne okno hry.
     *
     * @param args argumenty prikazoveho riadku (nepouzivaju sa)
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Falling Balls Game");
        frame.setResizable(false);  
        GamePanel game = new GamePanel();
        frame.add(game);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
} 