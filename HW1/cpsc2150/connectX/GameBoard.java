package connectX;
/*
* Rex Oliver
* CPSC 2150 HW1
* GameBoard.java
 */
public class GameBoard {

    private char[][] board;
    private int board_height;
    private int board_width;

    /**
     * Constructor
     * @pre - none
     * @post [A new GameBoard is initialized]
     * @invariant board_height > 0 and board_width > 0
     */
    public GameBoard(){
        // initialize the size of board
        board_height = 6;
        board_width = 7;
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
        // Each of these statements follows the same as the first does

        // checks if the row and collumn are inside the box so
        // that it does not do an integer overflow checking
        // the space in the next step
        // if all conditions are false, return false.
        if(c + 3 < board_width)
            // asks if the 4 things next to one another
            // vertically are equal to
            // the correct character, if yes, returns true,
            // if not, tries the next case
            if(board[r][c]==p && board[r][c+1]==p &&
                    board[r][c+2] == p && board[r][c+3] == p)
                return true;
        if(c + 2 < board_width && c - 1 > -1)
            if(board[r][c-1]==p && board[r][c]==p &&
                    board[r][c+1]==p && board[r][c+2]==p)
                return true;
        if(c + 1 < board_width && c - 2 > -1)
            if(board[r][c-2]==p && board[r][c-1]==p &&
                    board[r][c]==p && board[r][c+1]==p)
                return true;
        if(c - 3 > -1)
            if(board[r][c-2]==p && board[r][c-1]==p &&
                    board[r][c]==p && board[r][c-3]==p)
                return true;
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
        // Each of these statements follows the same as the first does

        // checks if the row and collumn are inside the box so
        // that it does not do an integer overflow checking
        // the space in the next step
        // if all conditions are false, return false.
        if(r + 3 < board_height)
            // asks if the 4 things next to one another
            // vertically are equal to
            // the correct character, if yes, returns true,
            // if not, tries the next case
            if(board[r][c]==p && board[r+1][c]==p &&
                    board[r+2][c] == p && board[r+3][c] == p )
                return true;
        if(r + 2 < board_height && r - 1 > -1)
            if(board[r][c]==p && board[r+1][c]==p &&
                    board[r+2][c] == p && board[r-1][c] == p )
                return true;
        if(r + 1 < board_height && r - 2 > -1)
            if(board[r][c]==p && board[r+1][c]==p &&
                    board[r-2][c] == p && board[r-1][c] == p )
                return true;
        if(r - 3 > -1)
            if(board[r][c]==p && board[r-3][c]==p &&
                    board[r-2][c] == p && board[r-1][c] == p )
                return true;
        return false;
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
        // Each of these statements follows the same as the first does

        // checks if the row and collumn are inside the box so
        // that it does not do an integer overflow checking
        // the space in the next step
        // if all conditions are false, return false.
        if (c + 3 < board_width && r + 3 < board_height)
            // asks if the 4 things next to one another
            // diagonally are equal to
            // the correct character, if yes, returns true,
            // if not, tries the next case
            if (board[r][c] == p && board[r + 1][c + 1] == p &&
                    board[r + 2][c + 2] == p && board[r + 3][c + 3] == p)
                return true;
        if (c + 2 < board_width && c - 1 > -1 && r + 2 < board_height
                && r - 1 > -1)
            if (board[r - 1][c - 1] == p && board[r][c] == p &&
                    board[r + 1][c + 1] == p && board[r + 2][c + 2] == p)
                return true;
        if (c + 1 < board_width && c - 2 > -1 && r + 1 < board_height
                && r - 2 > -1)
            if (board[r][c] == p && board[r + 1][c + 1] == p &&
                    board[r - 2][c - 2] == p && board[r - 1][c - 1] == p)
                return true;
        if (c - 3 > -1 && r - 3 > -1)
            if (board[r][c] == p && board[r - 3][c - 3] == p &&
                    board[r - 2][c - 2] == p && board[r - 1][c - 1] == p)
                return true;

        if (c + 3 < board_width && r > 2 )
            if(board[r][c] == p && board[r-1][c+1] == p &&
                    board[r-2][c +2] == p && board[r-3][c+3]==p)
                return true;
        if(c + 2 < board_width && c > 0 && r > 1 && r < 5)
            if(board[r][c] == p && board[r-1][c+1] == p &&
                    board[r-2][c+2]==p && board[r+1][c-1]==p)
                return true;
        if(c + 1 < board_width && c > 1 && r >0 && r < 4)
            if(board[r][c]==p && board[r-1][c+1] == p &&
                    board[r+1][c-1]==p && board[r+2][c-2]==p)
                return true;
        if(c > 2 && r < 3)
            if(board[r][c]==p && board[r+1][c-1] == p &&
                    board[r+2][c-2]==p && board[r+3][c-3] == p)
                return true;
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
        String s = "|0|1|2|3|4|5|6|\n";
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
}
