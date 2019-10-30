package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece [][] pieces;


    // Retorna a peça dada uma linha e uma coluna
    public Piece piece(int row, int column){
        if (!positionExists(row, column)){
            throw new BoardException("INVALID POSITION!");
        }
        return pieces[row][column];
    }


    // Retorna a peça pela sua position
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("INVALID POSITION!");
        }
        return pieces[position.getRow()][position.getColumn()];
    }


    // Posiciona as peças
    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("THERE'S A PIECE ON THIS POSITION ALREADY!");
        }
        // atribuirá a posição na matriz de peças(pieces) a peça que veio como argumento (piece)
        pieces[position.getRow()][position.getColumn()] = piece;
        // a peça deixa de ter a posição null atribuida na classe piece
        piece.position = position;
    }


    // Verifica a existência da posição pela linha e coluna
    public boolean positionExists(int row, int column){
        // a posição tem de estar entre 0 e o tamanho da coluna/linha
        return row >= 0 && row < rows &&
                column >= 0 && column < columns;
    }


    // Verifica a existência da posição pela posição
    public boolean positionExists(Position position){
        // irá chamar o método acima recebendo a posição como argumento
        return positionExists(position.getRow(), position.getColumn());
    }


    // Retorna se existe ou não uma peça na posição
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("INVALID POSITION!");
        }
        return piece(position) != null;
    }


    // A peça será removida tanto do Piece quanto da matriz do tabuleiro
    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("THIS POSITION DOES NOT EXIST");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;                                    // A peça nesta posição passará a ter valor nulo
        pieces[position.getRow()][position.getColumn()] = null; // A matriz nesta posição passará a ter valor nulo também
        return aux;
    }


    // Constructor
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("INVALID ROWS/COLUMNS QUANTITY!");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
