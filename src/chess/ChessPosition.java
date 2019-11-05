package chess;

import boardgame.Position;

public class ChessPosition {

    private int row;
    private char column;

    Position position= new Position(column, row);

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("INVALID POSITION");
        }
        this.row = row;
        this.column = column;
    }


    // Calcula a posição da peça
    public Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
