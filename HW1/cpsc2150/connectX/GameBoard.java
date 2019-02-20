package connectX;
/*
* Rex Oliver
* CPSC 2150 HW1
* GameBoard.java
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

    /**
     * @pre c > 0 and c < board_width
     * @post checkIfFree(c) == true iff board[5][c] == ' '
     * @param c column that we are checking if free
     * @return true iff board[5][c] == ' '
     */
    public boolean checkIfFree(int c){
        // Loop from bottom to top of board
        for(int i = 0; i < board_height; i++)
            // check if current space on board is free
            if(board[i][c] == ' ')
                return true;
        return false;
    }

    /**
     * @pre c > -1 and c < board_width
     * @post checkForWin(c) = true true iff
     * [checkVertWin || checkHorizWin || checkDiagWin
     * are true for the first index in column that is not empty]
     * @param c column that we are checking for win
     * @return true iff [checkVertWin || checkHorizWin ||
     * checkDiagWin are true for the first index in column
     * that is not empty]
     */
    public boolean checkForWin(int c) {
        // Loop from bottom to top of board
        for(int i = 0; i < board_height; i++)
            // if current index of board is not empty
            if(board[i][c] != ' ')
                // check for a vertical, horizontal, and diagonal win
                if(checkVertWin(i,c,board[i][c]) ||
                        checkHorizWin(i,c,board[i][c]) ||
                        checkDiagWin(i,c,board[i][c]))
                    return true;
        return false;
    }

    /**
     * @pre checkIfFree(c) == true and c < board_width and
     * (p == 'O' || p == 'X')
     * @post [p will be the placed in the lowest free spot in column c]
     * @param p character to place in the board
     * @param c column to place p in
     */
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

    /**
     *
     * @pre c < board_width and c > -1 and r < board_height and
     * (p == 'O' or p == 'X') r > -1
     * @post checkHorizWin(r,c,p) = true iff
     * [there are four of the same character horizontally
     * next to one another in the board]
     * @param r row of board
     * @param c column of board
     * @param p character to check if won
     * @return true iff
     * [there are four of the same character horizontally
     * next to one another in the board]
     */
    public boolean checkHorizWin(int r, int c, char p){
        int most_left = Math.max(0, c - (connect_what-1));
        int most_right = Math.min(board_width-1, c + (connect_what-1));
        boolean stand = true;
        for(int i = most_left; i + connect_what - 1 <= most_right; i++)
        {
            for(int j = 0; j < connect_what; j++)
            {
                if(board[r][i+j] != p)
                    stand = false;
            }
            if(stand == true) return true;
            stand = true;
        }
        return false;
    }

    /**
     * @pre c < board_width and c > -1 and r < board_height and
     * (p == 'O' or p == 'X') r > -1
     * @post checkHorizWin(r,c,p) = true iff
     * [there are four of the same character horizontally
     * next to one another in the board]
     * @param r row of board
     * @param c column of board
     * @param p character to be checked
     * @return true iff
     * [there are four of the same character horizontally
     * next to one another in the board]
     */
    public boolean checkVertWin(int r, int c, char p){
        if(r - connect_what > -1) {
            for (int i = 0; i < connect_what; i++)
                if(board[r - i][c] != p)
                    return false;
            return true;
        }
        else return false;
    }

    /**
     * @pre c < board_width and c > -1 and r < board_height and
     * (p == 'O' or p == 'X') and r > -1
     * @post checkDiagWin(r,c,p) = true iff
     * [there are four of the same character diagonally
     * next to one another in the board]
     * @param r row of board
     * @param c column of board
     * @param p character to check
     * @return  true iff
     * [there are four of the same character diagonally
     * next to one another in the board]
     */
    public boolean checkDiagWin(int r, int c, char p){
        int most_left = Math.max(0, c - (connect_what-1));
        int most_right = Math.min(board_width-1, c + (connect_what-1));
        int most_up = Math.min(board_height-1, r + (connect_what-1));
        int most_down = Math.max(0, r - (connect_what-1));
        boolean stand = true;

        int b = most_down;
        for(int i = most_left; i + connect_what - 1 <= most_right &&
                b + connect_what - 1 <= most_up; i++)
        {
            for(int j = 0; j < connect_what; j++)
                if(board[b+j][i+j] != p)
                    stand = false;
            if(stand)
                return true;
            stand = true;
            b++;
        }
        b = most_up;
        for(int i = most_left; i + connect_what - 1 <= most_right &&
                b - (connect_what - 1) >= 0; i++)
        {
            for(int j = 0; j < connect_what; j++)
                if(board[b-j][i+j] != p)
                    stand = false;
            if(stand)
                return true;
            stand = true;
            b--;
        }
        return false;
    }

    /**
     * @pre r > -1 and r < board_height and c > -1 and c < board_width
     * @post none
     * @param r row of board
     * @param c column of board
     * @return contents of board[i][c]
     */
    public char whatsAtPos(int r, int c){
        return board[r][c];
    }

    /**
     * @pre - none
     * @post - none
     * @return [string representation of the board]
     */
    public String toString(){
        // Prints top of board
        String s = "";
        for(int i = 0; i < board_width; i++)
            s += "|" + i;
        s += "|\n";
        // Loops through array in reverse order
        for(int i = board_height-1; i > -1; i--) {
            // adds structure of board to string
            s += "|";
            // loops through board horizontally
            for(int j = 0; j < board_width; j++)
                // adds the value at index of board to string
                s += board[i][j] + "|";
            // adds newline to end of string
            s+= "\n";
        }
        return s;
    }

    /**
     * @pre no previous play has resulted in a win
     * @post checkTie == true iff
     * [there are no available spaces left on the board]
     * @return true iff
     * [there are no available spaces left on the board]
     */
    public boolean checkTie(){
        for(int i = 0; i < board_width; i++)
            if(board[board_height-1][i] == ' ')
                return false;
        return true;
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
