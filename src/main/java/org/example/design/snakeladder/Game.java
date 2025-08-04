package org.example.design.snakeladder;

import java.util.Deque;

public class Game {
    Deque<Player> players;
    Board board;
    Dice dice;
    int boardSize;

    Game(Deque<Player> players, int boardSize,int diceCount){
        this.players = players;
        this.boardSize = boardSize;
        this.board = new Board(boardSize);
        this.dice = new Dice(diceCount);
    }

    void start(){
        this.board.displayBoard();
        System.out.println("Game Starting!");
        while(!players.isEmpty()){
            for(Player player: players){
                System.out.println(player.name+": " + player.location);
            }
            Player currPlayer = players.pollFirst();
            int diceRolled = dice.rollDice();
            System.out.println(currPlayer.name+ " rolled: "+diceRolled);
            int newLocation = currPlayer.location + diceRolled;
            if(newLocation >= boardSize*boardSize){
                System.out.println(currPlayer.name+" won!");
                return;
            }
            boolean isJumpCell = board.getCell(newLocation).jump != null;

            if(isJumpCell){
                if(board.getCell(newLocation).jump.start > board.getCell(newLocation).jump.end){
                    System.out.println("Uff Snake bite!");
                }
                else{
                    System.out.println("Yeah Ladder!");
                }
                newLocation = board.getCell(newLocation).jump.end;
            }

            currPlayer.location = newLocation;
            players.addLast(currPlayer);
        }
    }
}
