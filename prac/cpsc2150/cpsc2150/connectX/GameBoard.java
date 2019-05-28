package cpsc2150.connectX;
/*
* Rex Oliver
* CPSC 2150 HW1
* GameBoard.java
 */

/**
 * @invariant MIN_SIZE <= board_width <= MAX_SIZE
 * @invariant MIN_SIZE <= board_height <= MAX_SIZE
 * @invariant MIN_SIZE < connect_what < MAX_SIZE_WIN
 *
 * Correspondence [number of rows] = board_height
 * Correspondence [number of columns] = board_width
 * Correspondence [in a row to win] = connect_what
 */
public class GameBoard implements IGameBoard {

    private char[][] board;
    private int board_height;
    private int board_width;
    private int connect_what;

    /**
     * Constructor
     * @pre - none
     * @post [A new GameBoard is initialized]
     * @invariant board_height > 0 and board_width > 0
     */
    public GameBoard(int r, int c, int to_win){
        // initialize the size of board
        board_height = r;
        board_width = c;
        connect_what = to_win;
        // initialize the board to the correct size
        board = new char[board_height][board_width];
        // loop through entire board
        for(int i = 0; i < board_height; i++)
            for(int j = 0; j < board_width; j++)
                // assign current board index to space
                board[i][j] = ' ';
    }

    public void placeToken(char p, int c){
        // loop from bottom to top of board
        for(int i = 0; i < board_height; i++) // changed from board_height-1
            // if current index of board is empty
            if(board[i][c] == ' ')
            {
                // put token in the index
                board[i][c] = p;
                return;
            }
    }

    public String toString(){
        // Prints top of board
        String s = "";
        for(int i = 0; i < board_width; i++)
        {
            if(i > 9)
                s += "|" + i;
            else s+= "| " + i;
        }
        s += "|\n";
        // Loops through array in reverse order
        for(int i = board_height-1; i > -1; i--) {
            // adds structure of board to string

            s += "|";
            // loops through board horizontally
            for(int j = 0; j < board_width; j++)
                // adds the value at index of board to string
                    s += " " + board[i][j] + "|";
            // adds newline to end of string
            s+= "\n";
        }
        return s;
    }

    public char whatsAtPos(int r, int c){
        return board[r][c];
    }

    public int getNumRows(){
        return board_height;
    }

    public int getNumColumns(){
        return board_width;
    }

    public int getNumToWin(){
        return connect_what;
    }
}
