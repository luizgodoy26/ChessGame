package boardgame;

public class Piece  {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        // ESTE POSITION DEIXA DE SER NULL NO MÉTODO BOARD, ONDE UMA POSIÇÃO SERÁ ATRIBUÍDA À PEÇA
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
}
