package boardgame;

import chess.*;

import java.util.ArrayList;
import java.util.List;


// esta classe será classe onde todas as regras do jogo serão criadas
public class ChessMatch {


    private Board board;
    private int turn;
    private Color currentPlayer;

    private List<ChessPiece> piecesOnBoard = new ArrayList<>();
    private List<ChessPiece> capturedPieces = new ArrayList<>();

    // Cria o tabuleiro / Inicia o jogo com as peças brancas / Define turno / Posiciona as peças
    public ChessMatch(){
        board = new Board(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }


    // Passa para o próximo turno / Muda para o próximo jogador
    public void nextTurn(){
        turn++;
        if(currentPlayer == Color.WHITE){
            currentPlayer = Color.BLACK;
        }
        else {
            currentPlayer = Color.WHITE;
        }
    }


    // Movimenta as peças no tabuleiro
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);             // Valida a origem da peça
        validateTargetPosition(source, target);     // Valida o destino da peça
        Piece capturedPiece = makeMove(source, target);
        nextTurn();                                 // Passa para o próximo turno
        return (ChessPiece)(capturedPiece);
    }


    // Valida os movimentos
    public Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);                // Retira a peça da posição atual
        Piece capturedPice = board.removePiece(target);     // Captura a peça da posição alvo

        // Se houver captura de uma peça
        if (capturedPice != null){
            piecesOnBoard.remove(capturedPice);             // Retira a peça da lista de paças no tabuleiro
            capturedPieces.add((ChessPiece) capturedPice);  // Adiciona à lista de peças capturadas
        }

        board.placePiece(p, target);                        // Move a peça para a posição destino
        return capturedPice;
    }


    // Valida a existência de uma peça antes de ser realizado o movimento da mesma
    public void validateSourcePosition(Position position){
        if (!board.thereIsAPiece(position)){
            throw new ChessException("THERE IS NO PIECE IN THIS PLACE!");
        }
        // Verifica se a peça que será movida pertence ao responsável pelo turno
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("THIS PIECE BELONGS TO THE OTHER PLAYER!");
        }
        // Verifica se não há algum movimento possível
        if (!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("THERE IS NO POSSIBLE MOVE FOR THIS PIECE");
        }
    }


    // Valida a posição de destino
    public void validateTargetPosition(Position source, Position target){
        // Valida se é possível mover a peça de source para target
        if (!board.piece(source).possibleMove(target)){
            throw new ChessException("INVALID MOVEMENT!");
        }
    }


    // Pinta os possíveis movimentos
    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
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
        piecesOnBoard.add(piece);
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


    public int getTurn() {
        return turn;
    }


    public Color getCurrentPlayer() {
        return currentPlayer;
    }
}
