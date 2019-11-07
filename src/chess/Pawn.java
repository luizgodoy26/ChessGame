package chess;

import boardgame.Board;
import boardgame.Position;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);


        // BRANCO
        if (getColor() == Color.WHITE){

            // ACIMA
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;  // Marca na matriz que a posição destino é valida
            }


            // 1 MOVIMENTO ACIMA
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && !getBoard().thereIsAPiece(p2) && getBoard().positionExists(p2)) { // Verifica se há existe alguma peça na primeira casa acima
                mat[p.getRow()][p.getColumn()] = true;
            }


            // SUPERIOR ESQUERDA
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            // SUPERIOR DIREITA
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

        }
        else {

            // ABAIXO
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;  // Marca na matriz que a posição destino é valida
            }


            // 1 MOVIMENTO ABAIXO
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && !getBoard().thereIsAPiece(p2) && getBoard().positionExists(p2)) { // Verifica se há existe alguma peça na primeira casa acima
                mat[p.getRow()][p.getColumn()] = true;
            }


            // INFERIOR ESQUERDA
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            // INFERIOR DIREITA
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
