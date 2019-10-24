package application;

import boardgame.Board;
import boardgame.Position;

public class Program {

    public static void main(String [] args){

        Board board = new Board(8, 8);

        for (int i =0; i < board.getRows(); i++){
            for (int j =0; j < board.getColumns(); j++){
                System.out.print("X");
            }
            System.out.println(" ");
        }
    }
}
