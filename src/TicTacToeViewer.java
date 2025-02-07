import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;
    private static final int BOX_LENGTH = 100;
    private static final int FIRST_X = 100;
    private static final int FIRST_Y = 100;
    private static final int TEXT_X = 40;
    private static final int TEXT_Y = 73;
    private TicTacToe backend;

    // Make a viewer constructer with a reference to the backend
    public TicTacToeViewer(TicTacToe back) {
        this.backend = back;

        this.setTitle("TicTacToe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }


    public void paint(Graphics g) {
        // Clear the window
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Draw the grid
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 3; i++) {
            // Horizontal lines starting in front going to the end
            g.drawLine(FIRST_X, FIRST_Y + i * BOX_LENGTH, FIRST_X + 3 * BOX_LENGTH, FIRST_Y + i * BOX_LENGTH);
            // Vertical lines starting up top going down
            g.drawLine(FIRST_X + i * BOX_LENGTH, FIRST_Y, FIRST_X + i * BOX_LENGTH, FIRST_Y + 3 * BOX_LENGTH);
        }

        // Draw row and column numbers
        // Make the font Arial itilisized for pzaz
        g.setFont(new Font("Arial", Font.ITALIC, 30));
        for (int i = 0; i < 3; i++) {
            // Draw the ineger into a string centered in the middle of the box
            g.drawString(Integer.toString(i), TEXT_X, FIRST_Y + BOX_LENGTH * i + BOX_LENGTH / 2);
            g.drawString(Integer.toString(i), FIRST_X + BOX_LENGTH * i + BOX_LENGTH / 2, TEXT_Y);
        }

        // Draw the objects on the board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                backend.getBoard()[row][col].draw(g);
            }
        }
        // Winning message if we win the game
        if (backend.getGameOver()) {
            g.drawString(backend.getWinner() + " Congrats you're not a loser!", 30, 450);
        }
    }
}