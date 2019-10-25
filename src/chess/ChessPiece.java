package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color, int moveCount) {
        super(board);
        this.color = color;
        this.moveCount = moveCount;
    }

    protected boolean isThreOpponentPiece(Position position){
        return false;
    }

    protected void increaseMoveCount(){}

    protected void decreaseMoveCount(){}

    public Color getColor() {
        return color;
    }
}
