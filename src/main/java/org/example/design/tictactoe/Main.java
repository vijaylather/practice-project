package org.example.design.tictactoe;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<Player> players = new LinkedList<>();
        players.add(new Player("Vijay", new PlayingPieceX()));
        players.add(new Player("Krutika", new PlayingPieceO()));
        TicTacToeGame ticTacToeGame = new TicTacToeGame(players, 3);
        ticTacToeGame.start();
    }
}