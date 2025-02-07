import javax.swing.*;
import java.awt.*;

public class Square {

    private String marker;
    private int row, col;
    private Image imageX, imageO;
    private boolean isWinningSquare;
    private static final int BOX_LENGTH = 100;
    private static final int FIRST_X = 100;
    private static final int FIRST_Y = 100;
    private TicTacToeViewer frontend;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    // construct the square constructor
    public Square(int row, int col, TicTacToeViewer frontend) {
        this.row = row;
        this.col = col;
        this.frontend = frontend;


        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
        // give the image pathway
        imageX = new ImageIcon("Resources/X.png").getImage();
        imageO = new ImageIcon("Resources/O.png").getImage();
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
        // if the square is a winning square make it green
        if (this.isWinningSquare){
            g.setColor(Color.GREEN);
            // fill it with the correct x y and dimensions
            g.fillRect(col * BOX_LENGTH + FIRST_X, row * BOX_LENGTH + FIRST_Y, BOX_LENGTH, BOX_LENGTH);
        }
        // if we get an x make an x same with the o
        if (marker.equals("X")) {
            g.drawImage(imageX,(col+1)*100, (row+1)*100, BOX_LENGTH, BOX_LENGTH, frontend);
        }
        else if (marker.equals("O")) {
        g.drawImage(imageO, (col+1)*100, (row+1)*100, BOX_LENGTH, BOX_LENGTH, frontend);
        }
    }
}