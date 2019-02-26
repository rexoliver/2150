package connectX;

public interface IGameBoard {

    /**
     *
     * @return
     */
    int getNumRows();

    /**
     *
     * @return
     */
    int getNumColumns();

    /**
     *
     * @return
     */
    int getNumToWin();

    boolean checkIfFree(int c);

    boolean checkForWin(int c);

    void placeToken(char p, int c);

    boolean checkHorizWin(int r, int c, char p);

    boolean checkVertWin(int r, int c, char p);

    boolean checkDiagWin(int r, int c, char p);

    char whatsAtPos(int r, int c);

    String toString();

    boolean checkTie();

}