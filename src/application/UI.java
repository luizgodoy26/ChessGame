package application;

import chess.ChessPiece;

public class UI {

    // verifica se há alguma peça no local e exibe ela
    public static void printBoard(ChessPiece[][] pieces){
        for (int i  = 0; i < pieces.length; i++){
            System.out.print((pieces.length - i) + " ");
            for (int j  = 0; j < pieces.length; j++){
                printPiece(pieces[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("  a b c d e f g h");
    }

    // verifica se há uma peça no espaço e exibe o '-' quando não há
    private static void printPiece(ChessPiece piece){
        if (piece == null){
            System.out.print("-");
        }
        else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }
}
