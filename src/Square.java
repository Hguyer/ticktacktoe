import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private TicTacToeViewer frontend;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer frontend) {
        this.row = row;
        this.col = col;
        this.frontend = frontend;


        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
        imageX = new ImageIcon("Resources/fish1.png").getImage();
        imageO = new ImageIcon("Resources/fish2.png").getImage();
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        if (marker.toLowerCase().equals("x")) {
            g.drawImage(imageX, (row+1)100, (col+1)100, 100, 100, frontend);
        }
        else if (marker.toLowerCase().equals("o")) {
            g.drawImage(imageO, (row+1)100, (col+1)100, 100, 100, frontend);
        }
    }
}
