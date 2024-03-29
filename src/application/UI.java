package application;

import boardgame.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.*;
import java.util.stream.Collectors;

public class UI {

    // Estas linhas de código darão cor às peças
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    // Limpa a tela do console
    // https://www.quora.com/How-do-I-clear-console-screen-CMD-screen-in-Java-Is-there-any-function-in-Java-like-clrscr-and-system-cls-in-C
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    // Le a posição inputada pelo usuário
    public static ChessPosition readChessPosition(Scanner input){
        try {
            String s = input.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));     // Irá recortar o input e passará receberá o valor de s à partir do caractere 1
            return new ChessPosition(column, row);
        }
        catch (RuntimeException e){
            throw new InputMismatchException("INVALID DATA INPUT (VALID FROM a1 UP TO h8");
        }

    }


    // Exibe todos os dados da partida
    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured){
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturedPieces(captured);          // Exibirá as peças capturadas
        System.out.println();
        System.out.printf("TURN [%d]\n", chessMatch.getTurn());

        // Testa se a partida está em check mate
        if (!chessMatch.getCheckMate()) {
            System.out.println("PLAYER [" + chessMatch.getCurrentPlayer() + "] TURN!");
            if (chessMatch.getCheck()){
                if (chessMatch.getCurrentPlayer() == Color.BLACK){
                    System.out.print(ANSI_YELLOW);
                    System.out.print(chessMatch.getCurrentPlayer() + " KING IS IN CHECK!");
                    System.out.print(ANSI_RESET);
                }
                else {
                    System.out.print(chessMatch.getCurrentPlayer() + " KING IS IN CHECK!");
                }
            }
        }
        else {
            System.out.println("CHECKMATE!");
            System.out.println(chessMatch.getCurrentPlayer() + " IS THE WINNER!");
        }
    }

    // Verifica se há alguma peça no local e exibe ela
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }


    // Pinta o fundo nos para possíveis movimentos
    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }


    // Verifica se há uma peça no espaço e exibe o '-' quando não há
    private static void printPiece(ChessPiece piece, boolean background) {
        if (background){
            System.out.print(ANSI_RED_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            // Verifica a cor da peça e exibe ela na cor correta
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }


    // Exibirá uma lista de peças capturadas
    private static void printCapturedPieces(List<ChessPiece> captured){
        List<ChessPiece> whiteCaptured = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> blackCaptured = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());

        System.out.println("***CAPTURED PIECES***");

        System.out.print("WHITE: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(whiteCaptured.toArray()));   // Este comando passa um arraylist para String
        System.out.print(ANSI_RESET);

        System.out.print("BLACK: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(blackCaptured.toArray()));   // Este comando passa um arraylist para String
        System.out.print(ANSI_RESET);
    }
}
