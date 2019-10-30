package application;

import boardgame.ChessMatch;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                // A classe ui irá exibir os dados na tela
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("SOURCE (cR): ");
                    ChessPosition source = UI.readChessPosition(input);

                System.out.println();
                System.out.print("TARGET (cR): ");
                    ChessPosition target = UI.readChessPosition(input);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                input.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }
}
