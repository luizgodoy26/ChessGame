package application;

import boardgame.ChessMatch;

public class Program {

    public static void main(String [] args) {

        ChessMatch chessMatch = new ChessMatch();

        // a classe ui irá exibir os dados na tela
        UI.printBoard(chessMatch.getPieces());

    }
}
