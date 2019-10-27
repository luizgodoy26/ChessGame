package boardgame;

import chess.*;


// esta classe será classe onde todas as regras do jogo serão criadas
public class ChessMatch {

    private Board board;

    // cria um tabuleiro com 8 colunas e 8 linhas e posiciona as peças
    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }


    // inicia a partida posicionando as peças no tabuleiro
    private void initialSetup(){
        // WITE BOARD
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,7));
        board.placePiece(new King(board, Color.WHITE), new Position(0,4));

        // BLACK BOARD
        board.placePiece(new Rook(board, Color.WHITE), new Position(7,0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7,7));
        board.placePiece(new King(board, Color.WHITE), new Position(7,4));
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
