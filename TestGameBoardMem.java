package cpsc2150.connectX;

import org.junit.Test;

import static org.junit.Assert.*;
/*
 * Rex Oliver
 * CPSC 2150-002 HW4
 * TestGameBoardMem.java
 */

public class TestGameBoardMem {
    private IGameBoard MakeGameBoard(){
        IGameBoard asTest = new GameBoardMem(5,5,3);
        return asTest;
    }

    // Factory method so code is portable across TestGameBoard and TestGameBoardMem
    // Method only used to test the constructor with diff sizes
    private IGameBoard MakeGameBoard_changed_size(int r, int c, int to_win) {
        IGameBoard asTest = new GameBoardMem(r,c,to_win);
        return asTest;
    }

    // Test String used to assert toString outputs
    private String TestString(char [][] arr, int r, int c){
        // Prints top of board
        String s = "";
        for(int i = 0; i < c; i++)
        {
            if(i > 9)
                s += "|" + i;
            else s+= "| " + i;
        }
        s += "|\n";
        // Loops through array in reverse order
        for(int i = r-1; i > -1; i--) {
            // adds structure of board to string

            s += "|";
            // loops through board horizontally
            for(int j = 0; j < c; j++)
                // adds the value at index of board to string
                s += " " + arr[i][j] + "|";
            // adds newline to end of string
            s+= "\n";
        }
        return s;
    }

    // future minimum constructor
    @Test
    public void Constructor_NORM(){
        IGameBoard gb = MakeGameBoard();
        char [][] test_arr = new char[5][5];
        for(int i =0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                test_arr[i][j] = ' ';
        assertEquals(gb.toString(), TestString(test_arr,5,5));
    }

    // Tests if constructor works on the minimum possible_value
    @Test
    public void Constructor_MIN(){
        IGameBoard gb = MakeGameBoard_changed_size(3,3,3);
        char [][] test_arr = new char[3][3];
        for(int i =0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                test_arr[i][j] = ' ';
        assertEquals(gb.toString(), TestString(test_arr,3,3));
    }

    // Tests if constructor works on the maximum possible value
    @Test
    public void Constructor_MAX(){
        IGameBoard gb = MakeGameBoard_changed_size(100,100,25);
        char [][] test_arr = new char[100][100];
        for(int i =0; i < 100; i++)
            for(int j = 0; j < 100; j++)
                test_arr[i][j] = ' ';
        assertEquals(gb.toString(), TestString(test_arr,100,100));
    }

    // Tests if checkIfFree works when the column is full
    @Test
    public void checkIfFree_column_full(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++)
            A.placeToken('X', 0);
        assertTrue(!A.checkIfFree(0));
    }

    // Tests if checkIfFree works when the column is empty
    @Test
    public void checkIfFree_column_empty(){
        IGameBoard A = MakeGameBoard();
        assertTrue(A.checkIfFree(0));
    }

    // Tests if checkIfFree works when the column is partially full
    @Test
    public void checkIfFree_column_partially_full(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 4; i++)
            A.placeToken('X', 0);
        assertTrue(A.checkIfFree(0));
    }

    // Tests checkHorizWin at beginning of a horizontal
    @Test
    public void checkHorizWin_row0_beginning(){
        IGameBoard A = MakeGameBoard();
        for (int i = 0; i < 3; i++)
            A.placeToken('X', i);
        assertTrue(A.checkHorizWin(0, 0, 'X'));
    }

    // Tests checkHorizWin at end of a horizontal
    @Test
    public void checkHorizWin_row0_end(){
        IGameBoard A = MakeGameBoard();
        for (int i = 2; i < 5; i++)
            A.placeToken('X', i);
        assertTrue(A.checkHorizWin(0, 4, 'X'));
    }

    // Tests checkHorizWin at middle of a horizontal
    @Test
    public void checkHorizWin_row0_middle(){
        IGameBoard A = MakeGameBoard();
        for (int i = 1; i < 4; i++)
            A.placeToken('X', i);
        assertTrue(A.checkHorizWin(0, 2, 'X'));
    }

    // Tests checkHorizWin on horizontal that doesnt exist from beginning of row
    @Test
    public void checkHorizWin_row0_false_beginning(){
        IGameBoard A = MakeGameBoard();
        for (int i = 0; i < 2; i++)
            A.placeToken('X', i);
        for (int i = 2; i < 4; i++)
            A.placeToken('O', i);
        assertTrue(!A.checkHorizWin(0, 0, 'X'));
    }

    // Tests checkHorizWin on horizontal that doesnt exist from end of row
    @Test
    public void checkHorizWin_row0_false_end(){
        IGameBoard A = MakeGameBoard();
        for (int i = 1; i < 3; i++)
            A.placeToken('X', i);
        for (int i = 3; i < 5; i++)
            A.placeToken('O', i);
        assertTrue(!A.checkHorizWin(0, 4, 'O'));
    }

    // Tests a checkVertWin for row 0 from the top, with none below
    @Test
    public void checkVertWin_top(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 3; i++)
            A.placeToken('X', 0);
        assertTrue(A.checkVertWin( 2, 0, 'X'));
    }


    // Tests a checkVertWin for row 0 from the top, with spots below
    @Test
    public void checkVertWin_top_spots_below(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 2; i++)
            A.placeToken('O', 0);
        for(int i = 2; i < 5; i++)
            A.placeToken('X', 0);
        assertTrue(A.checkVertWin( 4, 0, 'X'));

    }

    // Tests a checkVertWin for row 0 from empty spot above top spot,
    // with spots below
    @Test
    public void checkVertWin_false_empty_spots_below(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 2; i++)
            A.placeToken('O', 0);
        for(int i = 2; i < 4; i++)
            A.placeToken('X', 0);
        assertTrue(!A.checkVertWin( 4, 0, 'X'));

    }

    // Tests a checkVertWin for row 0 from top spot, with spots below
    @Test
    public void checkVertWin_false_top_spots_below(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 2; i++)
            A.placeToken('O', 0);
        for(int i = 2; i < 4; i++)
            A.placeToken('X', 0);
        assertTrue(!A.checkVertWin( 3, 0, 'X'));
    }

    // Tests a checkVertWin for row 0 from the top, with none below
    // Designed to make sure checkVertWin does not check non existing indices,
    // causing null ptr exception
    @Test
    public void checkVertWin_false_empty_board(){
        IGameBoard A = MakeGameBoard();
        assertTrue(!A.checkVertWin( 0, 0, 'X'));
    }

    // checks DiagWin on an empty board, makes sure
    // it fails and doesnt cause null ptr exception
    @Test
    public void checkDiagWin_false_empty_board(){
        IGameBoard A = MakeGameBoard();
        assertTrue(!A.checkDiagWin( 0, 0, 'X'));
    }

    // Tests diagonal bottom left to top right
    @Test
    public void checkDiagWin_left_bottom_right_top(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 3; i++)
            A.placeToken('X', i);
        for(int i = 1; i < 3; i++)
            A.placeToken('X', i);
        A.placeToken('X', 2);
        assertTrue(A.checkDiagWin(2,2,'X'));
    }

    // Tests diagonal bottom right to top left
    @Test
    public void checkDiagWin_left_top_right_bottom(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 3; i++)
            A.placeToken('X', i);
        for(int i = 0; i < 2; i++)
            A.placeToken('X', i);
        A.placeToken('X', 0);
        assertTrue(A.checkDiagWin(0,0,'X'));
    }

    // Tests diagonal bottom left to top right with spots filled under it
    @Test
    public void checkDiagWin_left_bottom_right_top_spots_under(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++){
            A.placeToken('O', i);
            A.placeToken('O', i);
        }
        for(int i = 2; i < 5; i++)
            A.placeToken('X', i);
        for(int i = 3; i < 5; i++)
            A.placeToken('X', i);
        A.placeToken('X', 4);
        assertTrue(A.checkDiagWin(4,4,'X'));
    }

    // Tests diagonal bottom right to top left with spots filled under it
    @Test
    public void checkDiagWin_left_top_right_bottom_spots_under(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++){
            A.placeToken('O', i);
            A.placeToken('O', i);
        }
        for(int i = 0; i < 3; i++)
            A.placeToken('X', i);
        for(int i = 0; i < 2; i++)
            A.placeToken('X', i);
        A.placeToken('X', 0);
        assertTrue(A.checkDiagWin(2,0,'X'));
    }

    // makes sure the left bottom right top test does not work
    // when the top
    @Test
    public void checkDiagWin_false_left_bottom_right_top_insufficient_chars(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 2; i++)
            A.placeToken('X', i);
        A.placeToken('X', 1);
        assertTrue(!A.checkDiagWin(0, 0, 'X'));
    }

    // makes sure the left top right bottom test does not work
    // when the top
    @Test
    public void checkDiagWin_false_left_top_right_bottom_insufficient_chars(){
        IGameBoard A = MakeGameBoard();
        for(int i = 1; i < 3; i++)
            A.placeToken('X', i);
        A.placeToken('X', 1);
        assertTrue(!A.checkDiagWin(1, 1, 'X'));
    }

    // makes sure checkDiagWin is false when board is full yet there is no diagonals
    @Test
    public void checkDiagWin_false_full_alternating_board()
    {
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++) {
                if (i%2 == 1)
                    A.placeToken('X', j);
                else
                    A.placeToken('O', j);
            }
        assertTrue(!A.checkDiagWin(2, 2, 'O'));
    }

    // does checkTie for a board that is completely full
    @Test
    public void checkTie_full_board(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                A.placeToken('X', j);
        assertTrue(A.checkTie());
    }

    // does checkTie for a board that is empty
    @Test
    public void checkTie_empty_board(){
        IGameBoard A = MakeGameBoard();
        assertTrue(!A.checkTie());
    }

    // does checkTie for a board that has some columns full
    @Test
    public void checkTie_some_columns_full(){
        IGameBoard A = MakeGameBoard();
        for(int j = 0; j < 3; j++)
            for(int i = 0; i < 5; i++)
                A.placeToken('X', j);
        assertTrue(!A.checkTie());
    }

    @Test
    public void checkTie_full_alternating_board()
    {
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++) {
                if (i%2 == 1)
                    A.placeToken('X', j);
                else
                    A.placeToken('O', j);
            }
        assertTrue(A.checkTie());
    }

    // tests WhatsAtPos on an empty board for an empty space
    @Test
    public void WhatsAtPos_empty_space_empty_board(){
        IGameBoard A = MakeGameBoard();
        assertEquals(' ', A.whatsAtPos(0, 0));
    }

    // tests WhatsAtPos on board with one row full on an empty space
    @Test
    public void WhatsAtPos_empty_space_part_full_board(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++)
            A.placeToken('X', i);
        assertEquals(' ', A.whatsAtPos(1, 0));
    }

    // tests WhatsAtPos on board with all spaces full except
    // the one we are checking
    @Test
    public void WhatsAtPos_empty_space_almost_full_board(){
        IGameBoard A = MakeGameBoard();
        for(int j = 0; j < 4; j++)
            for(int i = 0; i < 5; i++)
                A.placeToken('X', i);
        for(int i = 0; i < 4; i++)
            A.placeToken('X', i);
        assertEquals(' ', A.whatsAtPos(4, 4));
    }

    // Tests WhatsAtPos on the only spot on a board that has a character
    @Test
    public void WhatsAtPos_only_spot_on_board(){
        IGameBoard A = MakeGameBoard();
        A.placeToken('X', 3);
        assertEquals('X', A.whatsAtPos(0, 3));
    }

    // Tests WhatsAtPos on a character within a row of another alt character
    @Test
    public void WhatsAtPos_diff_char_than_rest_of_row(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++) {
            if(i == 3)
                A.placeToken('X', i);
            else
                A.placeToken('O', i);
        }
        assertEquals('X', A.whatsAtPos(0, 3));
    }

    // Tests WhatsAtPos on a character within a board of another alt character
    @Test
    public void WhatsAtPos_diff_char_than_rest_of_board(){
        IGameBoard A = MakeGameBoard();
        for(int j = 0; j < 5; j++) {
            for(int i = 0; i < 5; i++) {
                if (i == 3 && j == 3)
                    A.placeToken('X', i);
                else
                    A.placeToken('O', i);
            }
        }
        assertEquals('X', A.whatsAtPos(3, 3));
    }

    // Tests WhatsAtPos on a character where there are characters above and
    // below it
    @Test
    public void WhatsAtPos_spots_taken_above_and_below(){
        IGameBoard A = MakeGameBoard();
        A.placeToken('O', 0);
        A.placeToken('X', 0);
        A.placeToken('O', 0);
        assertEquals('X', A.whatsAtPos(1, 0));
    }

    // Tests PlaceToken on empty board
    @Test
    public void placeToken_empty_board(){
        IGameBoard A = MakeGameBoard();
        A.placeToken('X', 0);
        assertEquals('X', A.whatsAtPos(0, 0));
    }

    // Tests PlaceToken on part filled column
    @Test
    public void placeToken_column_part_full(){
        IGameBoard A = MakeGameBoard();
        A.placeToken('O', 0);
        A.placeToken('X', 0);
        assertEquals('X', A.whatsAtPos(1, 0));
    }

    // Tests PlaceToken to fill column
    @Test
    public void placeToken_to_fill_column(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 4; i++)
            A.placeToken('O', 0);
        A.placeToken('X', 0);
        assertEquals('X', A.whatsAtPos(4, 0));
    }

    // Tests PlaceToken to fill row
    @Test
    public void placeToken_to_fill_row(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 4; i++)
            A.placeToken('O', i);
        A.placeToken('X', 4);
        assertEquals('X', A.whatsAtPos(0, 4));
    }

    // Tests placeToken to fill board
    @Test
    public void placeToken_to_fill_board(){
        IGameBoard A = MakeGameBoard();
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 4 && j == 4)
                    A.placeToken('X', 4);
                else
                    A.placeToken('O', j);
            }
        }
        assertEquals('X', A.whatsAtPos(4, 4));
    }
}
