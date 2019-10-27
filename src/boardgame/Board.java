package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece [][] pieces;


    // retorna a peça dada uma linha e uma coluna
    public Piece piece(int rows, int columns){
        return pieces[rows][columns];
    }


    // retorna a peça pela sua position
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }


    // posiciona as peças
    public void placePiece(Piece piece, Position position){
        // atribuirá a posição na matriz de peças(pieces) a peça que veio como argumento (piece)
        pieces[position.getRow()][position.getColumn()] = piece;
        // a peça deixa de ter a posição null atribuida na classe piece
        piece.position = position;
    }

    // constructor
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
