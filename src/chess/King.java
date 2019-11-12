package chess;

import boardgame.Board;
import boardgame.ChessMatch;
import boardgame.Position;
import javafx.geometry.Pos;

public class King extends ChessPiece{

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }


    @Override
    public String toString() {
        return "K";
    }


    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);


        // ACIMA
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ABAIXO
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ESQUERDA
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // DIREITA
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // SUPERIOR DIREITA
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // SUPERIOR ESQUERDA
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // INFERIOR DIREITA
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // INFERIOR ESQUERDA
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }


        // #SpecialMove Castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()){

            // Castling pro lado do rei
            Position posK = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posK)){
                Position pMore1 = new Position(position.getRow(), position.getColumn() + 1);
                Position pMore2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(pMore1) == null && getBoard().piece(pMore2) == null){
                    mat[p.getRow()][p.getColumn() + 2] = true;
                }
            }

            // Castling pro lado do rainha
            Position posQ = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posQ)){
                Position pMore1 = new Position(position.getRow(), position.getColumn() - 1);
                Position pMore2 = new Position(position.getRow(), position.getColumn() - 2);
                Position pMore3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(pMore1) == null && getBoard().piece(pMore2) == null && getBoard().piece(pMore3) == null){
                    mat[p.getRow()][p.getColumn() - 2] = true;
                }
            }
        }


        return mat;
    }


    // Verifica se a peça está apta para Castling (Quando a quantidade de movimento da peça for equivalente à zero)
    private boolean testRookCastling (Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);  // Pega a peça na posição passada
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;   // Se é um Rook E se a cor é igual a do rei E se a qtd de movimentos é 0
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
}
