package boardgame;

public abstract class Piece  {

    protected Position position;
    private Board board;


    // Cria a peça
    public Piece(Board board) {
        this.board = board;
        // Este position deixa de ser null no método board, onde uma posição será atribuída à peça
        position = null;
    }

    protected Board getBoard() {
        return board;
    }


    // Matriz dos movimentos possíveis
    public abstract boolean[][] possibleMoves();


    // Veriica posssíveis movimentos
    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    // Verifica se existe algum movimento possível
    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++){
                // Se existir um movimento possível nesta localidade retornará true
                if(mat[i][j]){
                    return true;
                }

            }
        }
        // Se não existir retornará false
        return false;
    }

}
