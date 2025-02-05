import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;
    private static final int SIDE_LENGTH = 100;
    private static final int FIRST_X = 100;
    private static final int FIRST_Y = 100;
    private static final int TEXT_X = 40;
    private static final int TEXT_Y = 73;
    private TicTacToe back;

    public TicTacToeViewer(TicTacToe back) {
        this.back = back;

        this.setTitle("TicTacToe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(FIRST_X, FIRST_Y, SIDE_LENGTH, SIDE_LENGTH);
        for (int i = 0; i < 3; i++) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString(Integer.toString(i), TEXT_X + (i+1)SIDE_LENGTH, TEXT_Y);
            g.drawString(Integer.toString(i), TEXT_X, TEXT_Y + (i+1)SIDE_LENGTH);
            g.setColor(Color.BLACK);
            g.drawLine(FIRST_X + (i+1)SIDE_LENGTH, FIRST_Y, FIRST_X + (i+1)SIDE_LENGTH, FIRST_Y + SIDE_LENGTH);
            g.drawLine(FIRST_X, FIRST_Y + (i+1)SIDE_LENGTH, FIRST_X + SIDE_LENGTH, FIRST_Y + (i+1)SIDE_LENGTH);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                back.getBoard()[i][j].draw(g);
            }
        }
    }
}
