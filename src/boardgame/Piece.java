package boardgame;

public class Piece  {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        // Este position deixa de ser null no método board, onde uma posição será atribuída à peça
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
}
