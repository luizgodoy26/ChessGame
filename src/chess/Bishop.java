package chess;

import boardgame.Board;
import boardgame.Position;

public class Bishop extends ChessPiece{

    public Bishop(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        /* O método baixo vai percorrer a matriz criada acima em cada um dos sentidos
         * Sempre que não houver nenhuma peça no local, ele irá tratar este espaço como um movimento possível
         * Bem como quando houver uma peça de outra cor
         */

        // ACIMA ESQUERDA
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ACIMA DIREITA
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ABAIXO ESQUERDA
        p.setValues(position.getRow() + 1, position.getColumn()- 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ABAIXO DIREITA
        p.setValues(position.getRow()+ 1, position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }


        return mat;
    }
}
