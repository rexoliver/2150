package cpsc2150.connectX;
import java.util.*;

/**
 * @invariant MIN_SIZE <= board_width <= MAX_SIZE
 * @invariant MIN_SIZE <= board_height <= MAX_SIZE
 * @invariant MIN_SIZE < connect_what < MAX_SIZE_WIN
 *
 * Correspondence [number of rows] = board_height
 * Correspondence [number of columns] = board_width
 * Correspondence [in a row to win] = connect_what
 */
public class GameBoardMem extends AbsGameBoard {
    // private variables
    private int board_height;
    private int board_width;
    private int connect_what;
    private Map<Integer, List<Character>> board;

    /**
     * Constructor
     * @pre - none
     * @post [A new GameBoard is initialized] and [the board is
     * empty and filled with spaces]
     * @invariant board_height > 0 and board_width > 0
     */
    public GameBoardMem(int rows, int columns, int num_to_win){
        board_height = rows;
        board_width = columns;
        connect_what = num_to_win;

        // creates new board as hashmap
        board = new HashMap<>();
        // loops through each column, creating
        // a list for each column
        for(int i = 0; i < columns; i++)
        {
            List<Character> newVals = new ArrayList<Character>();
            board.put(i,newVals);
        }
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

    public void placeToken(char p, int c) {board.get(c).add(p);}

    public char whatsAtPos(int r, int c) {
        // if the list does not have an entry for
        // row r and column c, return ' '
        if(r > board.get(c).size()-1)
            return ' ';
        // otherwise return entry in list at r,c
        return board.get(c).get(r);
    }
}
