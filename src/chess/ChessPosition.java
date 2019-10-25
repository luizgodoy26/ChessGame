package chess;

import boardgame.Position;

public class ChessPosition {

    private int row;
    private int column;

    Position position= new Position(row, column);

    protected Position toPosition (){
        return position;
    }

    protected Position fromPosition(){
        return position;
    }
}
