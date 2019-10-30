package chess;

import boardgame.Board;
import boardgame.Position;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }


    @Override
    public String toString() {
        return "R";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        /* O método baixo vai percorrer a matriz criada acima em cada um dos sentidos
         * Sempre que não houver nenhuma peça no local, ele irá tratar este espaço como um movimento possível
         * Bem como quando houver uma peça de outra cor
         */

        // Verifica posições possíveis acima
        p.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Verifica posições possíveis à ESQUERDA
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Verifica posições possíveis à DIREITA
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Verifica posições possíveis ABAIXO
        p.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThreOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
