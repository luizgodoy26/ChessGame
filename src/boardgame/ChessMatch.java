package boardgame;

import chess.*;


// esta classe será classe onde todas as regras do jogo serão criadas
public class ChessMatch {

    private Board board;

    // Cria um tabuleiro com 8 colunas e 8 linhas e posiciona as peças
    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }


    // Inicia a partida posicionando as peças no tabuleiro
    private void initialSetup(){
        // WHITE BOARD
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));

        // BLACK BOARD
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
    }

    // Converte as posições do tipo Board(Matriz) para o Tipo Chess (Onde é possível referenciar a posição através das letras)
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }


    /* para que o console não tenha acesso à peça do tipo piece
     * cria-se uma nova matriz do tipo chesspiece, recebendo os valores de piece
     * desta forma, o tabuleiro */
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        // COM ESTE FOR, CADA PEÇA NA LINHA i E COLUNA j VAI RECEBER A SUA RESPECTIVA piece
        for (int i  = 0; i<board.getRows();i++){
            for (int j  = 0; j<board.getColumns();j++){
                // REALIZADO O DOWNCASTING DE piece PARA ChessPiece
                mat [i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
}
