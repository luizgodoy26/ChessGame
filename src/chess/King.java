package chess;

import boardgame.Board;

public class King extends ChessPiece{

    public King(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString() {
        return "K";
    }


    @Override
    public boolean[][] possibleMoves() {
        // Cria uma matriz com as dimensões do tabuleiro
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
