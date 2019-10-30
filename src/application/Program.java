package application;

import boardgame.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            // A classe ui irá exibir os dados na tela
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("SOURCE (cR): ");
                ChessPosition source = UI.readChessPosition(input);

            System.out.println();
            System.out.print("TARGET (cR): ");
                ChessPosition target = UI.readChessPosition(input);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }
}
