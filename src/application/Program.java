package application;

import boardgame.ChessMatch;

public class Program {

    public static void main(String [] args) {

        ChessMatch chessMatch = new ChessMatch();

        // A classe ui irá exibir os dados na tela
        UI.printBoard(chessMatch.getPieces());

    }
}
