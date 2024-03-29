package application;

import boardgame.ChessMatch;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();


        while (!chessMatch.getCheckMate()) {
            try {
                // A classe ui irá exibir os dados na tela
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("SOURCE (cR): ");
                    ChessPosition source = UI.readChessPosition(input);

                // Verifica os movimentos possíveis para colorir o fundo
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("TARGET (cR): ");
                    ChessPosition target = UI.readChessPosition(input);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                // Se houver uma peça no local de destino (!= null) entende-se que uma peça foi capturada
                if (capturedPiece != null){
                    captured.add(capturedPiece);
                }
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

        UI.clearScreen();

        UI.printMatch(chessMatch, captured);
    }
}
