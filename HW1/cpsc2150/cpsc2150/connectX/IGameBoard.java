package cpsc2150.connectX;
 /**
  * IGameBoard represents a 2 Dimensional board of characters.
  * Indexing starts at 0
  * Initialization Ensures:
  *     IGameBoard contains only blank characters and is
  *     between MAX_SIZE x MAX_SIZE and MIN_SIZE x MIN_SIZE, inclusive.
  * Defines:    [number of rows]: Z
  *             [number of columns]: Z
  *             [in a row to win]: Z
  * Constraints: MIN_SIZE <= [number of rows] <= MAX_SIZE
  *              MIN_SIZE =< [number of columns] <= MAX_SIZE
  *              MIN_SIZE =< [in a row to win] <= MAX_SIZE_WIN
  */
public interface IGameBoard {

    int MAX_SIZE = 100;
    int MIN_SIZE = 3;
    int MAX_SIZE_WIN = 25;
    int MAX_PLAYERS = 10;
    int MIN_PLAYERS = 2;
    /**
     * @pre [number of rows] > 3 & [number of rows] <= MAX_SIZE
     * @post getNumRows() = [number of rows]
     * @return [number of rows]
     */
    int getNumRows();

    /**
     * @pre  [number of columns] >= MIN_SIZE and [number of columns]<=MAX_SIZE
     * @post getNumColumns() = [number of columns]
     * @return [number of columns]
     */
    int getNumColumns();

    /**
     * @pre [in a row to win] <= MAX_SIZE_WIN and [in a row to win] >= MIN_SIZE
     * @post getNumToWin = [in a row to win]
     * @return [in a row to win]
     */
    int getNumToWin();

    /**
     * @pre c > 0 and c < getNumColumns()
     * @post checkIfFree(c) == true iff board[5][c] == ' '
     * @param c column that we are checking if free
     * @return true iff board[5][c] == ' '
     */
    default boolean checkIfFree(int c){
        // Loop from bottom to top of board
        for(int i = 0; i < getNumRows(); i++)
            // check if current space on board is free
            if(whatsAtPos(i,c) == ' ')
                return true;
        return false;
    }

    /**
     * @pre c > -1 and c < getNumColumns()
     * @post checkForWin(c) = true true iff
     * [checkVertWin || checkHorizWin || checkDiagWin
     * are true for the first index in column that is not empty]
     * @param c column that we are checking for win
     * @return true iff [checkVertWin || checkHorizWin ||
     * checkDiagWin are true for the first index in column
     * that is not empty]
     */
    default boolean checkForWin(int c){
        // Loop from bottom to top of board
        for(int i = 0; i < getNumRows(); i++)
            // if current index of board is not empty
            if(whatsAtPos(i,c) != ' ')
                // check for a vertical, horizontal, and diagonal win
                if(checkVertWin(i,c,whatsAtPos(i,c)) ||
                        checkHorizWin(i,c,whatsAtPos(i,c)) ||
                        checkDiagWin(i,c,whatsAtPos(i,c)))
                    return true;
        return false;
    }
    /**
     * @pre checkIfFree(c) == true and c < getNumColumns() and
     * (p == 'O' || p == 'X')
     * @post [p will be the placed in the lowest free spot in column c]
     * @param p character to place in the board
     * @param c column to place p in
     */
    void placeToken(char p, int c);

    /**
     *
     * @pre c < getNumColumns() and c > -1 and r < getNumRows() and
     * (p == 'O' or p == 'X') r > -1
     * @post checkHorizWin(r,c,p) = true iff
     * [there are getNumToWin() of the same character horizontally
     * next to one another in the board]
     * @param r row of board
     * @param c column of board
     * @param p character to check if won
     * @return true iff
     * [there are getNumToWin() of the same character horizontally
     * next to one another in the board]
     */
    default boolean checkHorizWin(int r, int c, char p) {
        // furthest left we can go from whatsAtPos(r,c)
        int most_left = Math.max(0, c - (getNumToWin()-1));
        // furthest right we can go from whatsAtPos(r,c)
        int most_right = Math.min(getNumColumns()-1, c + (getNumToWin()-1));
        // represents whether or not the current diagonal passes
        boolean stand = true;

        // Loop to check all possible horizontals from whatsAtPos(r,c)
        for(int i = most_left; i + getNumToWin() - 1 <= most_right; i++)
        {
            // checks individual horizontal according to parameters above
            for(int j = 0; j < getNumToWin(); j++)
            {
                // if current spot is not our character, then this
                // horizontal is not valid
                if(whatsAtPos(r,i+j) != p)
                    stand = false;
            }
            // if stand is still true after checking a diagonal,
            // that diagonal is valid, so return true
            if(stand == true)
                return true;
            // reset stand to original value for next loop
            stand = true;
        }
        // if every possible horizontal going off whatsAtPos(r,c)
        // is invalid, return false
        return false;
    }

    /**
     * @pre c < getNumColumns() and c > -1 and r < getNumRows() and
     * (p == 'O' or p == 'X') r > -1
     * @post checkVertWin(r,c,p) = true iff
     * [there are getNumToWin() of the same character vertically
     * next to one another in the board]
     * @param r row of board
     * @param c column of board
     * @param p character to be checked
     * @return true iff
     * [there are getNumToWin() of the same character vertically
     * next to one another in the board]
     */
    default boolean checkVertWin(int r, int c, char p){
        // checks to see if the r is bigger than getNumToWin()
        // so that loop doesn't check an out of bounds index
        if(r - (getNumToWin() - 1) > -1) {
            // loop checking for getNumToWin() spaces below c
            for (int i = 0; i < getNumToWin(); i++)
                // if a value is not equal to p in our loop,
                // return false
                if(whatsAtPos(r - i,c) != p)
                    return false;
            // if loop has all same values as p, return true
            return true;
        }
        // return false if the r is not big enough to have a \
        // vertical win below it.
        else return false;
    }
    /**
     * @pre c < getNumColumns() and c > -1 and r < getNumRows() and
     * (p == 'O' or p == 'X') and r > -1
     * @post checkDiagWin(r,c,p) = true iff
     * [there are getNumToWin() of the same character diagonally
     * next to one another in the board]
     * @param r row of board
     * @param c column of board
     * @param p character to check
     * @return  true iff
     * [there are getNumToWin() of the same character diagonally
     * next to one another in the board]
     */
    default boolean checkDiagWin(int r, int c, char p){
        // furthest left we can go from whatsAtPos(r,c)
        int most_left = Math.max(0, c - (getNumToWin()-1));
        // furthest right we can go from whatsAtPos(r,c)
        int most_right = Math.min(getNumColumns()-1, c + (getNumToWin()-1));
        // furthest up we can go from whatsAtPos(r,c)
        int most_up = Math.min(getNumRows()-1, r + (getNumToWin()-1));
        // furthest down we can go from whatsAtPos(r,c)
        int most_down = Math.max(0, r - (getNumToWin()-1));
        // represents whether or not the current diagonal passes
        boolean stand = true;

        // used to increment how far the diagonal can check
        int b = most_down;
        // loop for checking all possible diagonals that go down from
        // whatsAtPos(r,c)
        for(int i = most_left; i + getNumToWin() - 1 <= most_right &&
                b + getNumToWin() - 1 <= most_up; i++)
        {
            // Loop for a single diagonal based on parameters decided
            // by above loop
            for(int j = 0; j < getNumToWin(); j++)
                // if current spot is not our character, then this
                // diagonal is not valid
                if(whatsAtPos(b+j,i+j) != p)
                    stand = false;
            // if stand is still true after checking a diagonal,
            // that diagonal is valid, so return true
            if(stand)
                return true;
            // reset stand to true
            stand = true;
            // adjust the diagonal we are checking
            b++;
        }
        // increments how far diagonal can check up
        b = most_up;
        // loop for checking all possible diagonals that go up from
        // whatsAtPos(r,c)
        for(int i = most_left; i + getNumToWin() - 1 <= most_right &&
                b - (getNumToWin() - 1) >= 0; i++)
        {
            // Loop for a single diagonal based on parameters decided
            // by above loop
            for(int j = 0; j < getNumToWin(); j++)
                // if current spot is not our character, then this
                // diagonal is not valid
                if(whatsAtPos(b-j,i+j) != p)
                    stand = false;
            // if stand is still true after checking a diagonal,
            // that diagonal is valid, so return true
            if(stand)
                return true;
            // reset stand to true
            stand = true;
            // adjust the diagonal we are checking
            b--;
        }
        // if every possible diagonal going off whatsAtPos(r,c)
        // is invalid, return false
        return false;
    }
    /**
     * @pre r > -1 and r < getNumRows() and c > -1 and c < getNumColumns()
     * @post whatsAtPos(r,c) = whatever token is at position r and c,
     * or “ ” if it is empty.]
     * @param r row of board
     * @param c column of board
     * @return [whatever token is at position r and c,
     * or “ ” if it is empty.]
     */
    char whatsAtPos(int r, int c);

    /**
     * @pre - none
     * @post - returns a formatted string representation of the board
     * @return [string representation of the board]
     */
    String toString();

    /**
     * @pre no previous play has resulted in a win
     * @post checkTie == true iff
     * [there are no available spaces left on the board]
     * @return true iff
     * [there are no available spaces left on the board]
     */
    default boolean checkTie(){
        // loop checking across all the top elements of the board
        for(int i = 0; i < getNumColumns(); i++)
            // if there is an empty space, return false
            if(whatsAtPos(getNumRows()-1,i) == ' ')
                return false;
        // if no empty spaces, return true
        return true;
    }

}