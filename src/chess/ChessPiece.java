package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;



    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
        this.moveCount = moveCount;
    }


    protected boolean isThreOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }


    public void increaseMoveCount(){
        moveCount++;
    }


    public void decreaseMoveCount(){
        moveCount--;
    }


    public int getMoveCount() {
        return moveCount;
    }


    public Color getColor() {
        return color;
    }


    // Passa o valor de Position para ChessPosition, para que a aplicação tenha acesso
    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
}
