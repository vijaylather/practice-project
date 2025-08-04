package org.example.design.snakeladder;


import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<Player> players = new LinkedList<>();
        players.add(new Player("Vijay"));
        players.add(new Player("Krutika"));
        Game snakeLadderGame = new Game(players, 5, 1);
        snakeLadderGame.start();
    }
}