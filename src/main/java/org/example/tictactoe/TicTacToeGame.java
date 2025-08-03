package org.example.tictactoe;

import java.util.Deque;
import java.util.Scanner;

public class TicTacToeGame {
    private final Board board;
    private final Deque<Player> players;
    private final Scanner inputScanner = new Scanner(System.in);

    TicTacToeGame(Deque<Player> players, int size){
        this.board = new Board(size);
        this.players = players;
    }

    void start(){
        while(true){
            board.displayBoard();
            Player currPlayer = players.pollFirst();
            if(currPlayer == null){
                System.out.print("Not a valid player, something went wrong!");
                return;
            }
            System.out.println("please enter your turn "+currPlayer.name+ " ");
            int row = inputScanner.nextInt();
            int col = inputScanner.nextInt();
            if(!board.addPiece(row, col, currPlayer.playingPiece)){
                players.addFirst(currPlayer);
                continue;
            }
            if(board.isWinnerAvailable()){
                System.out.println("Congrats! winner is: "+currPlayer.name);
                board.displayBoard();
                return;
            }
            if(board.numberOfEmptyCells==0){
                System.out.print("Game is a tie");
                board.displayBoard();
                return;
            }
            players.addLast(currPlayer);
        }
    }
}
