package org.example.design.snakeladder;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int size;
    Cell[][] board;
    Set<Integer> uniqueLocation = new HashSet<>();

    Board(int size){
        this.size = size;
        this.board = new Cell[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0; j<size;j++) {
                Cell cellObj = new Cell();
                board[i][j] = cellObj;
            }
        }

        initializeGame();
    }

    private void initializeGame(){
        int n = size/2;
        //addSnakes
        while(n>0){
            int start = ThreadLocalRandom.current().nextInt(1,size*size);
            int end = ThreadLocalRandom.current().nextInt(1,size*size);
            if(start>end && !uniqueLocation.contains(start) && !uniqueLocation.contains(end)){
                uniqueLocation.add(start);
                uniqueLocation.add(end);
                System.out.println("Snake start: "+start+ " end: "+end);
                Jump snakeObj = new Jump(start,end);
                Cell cell = getCell(start);
                cell.jump = snakeObj;
                n--;
            }
        }
        n = size/2;
        //addLadders
        while(n>0){
            int start = ThreadLocalRandom.current().nextInt(1,size*size);
            int end = ThreadLocalRandom.current().nextInt(1,size*size);
            if(start<end && !uniqueLocation.contains(start) && !uniqueLocation.contains(end)){
                uniqueLocation.add(start);
                uniqueLocation.add(end);
                System.out.println("Ladder start: "+start+ " end: "+end);
                Jump ladderObj = new Jump(start,end);
                Cell cell = getCell(start);
                cell.jump = ladderObj;
                n--;
            }
        }
    }

    Cell getCell(int start){
        int row = (start-1)/size;
        int col = start - 1 - (row * size);
        if(row%2==1){
            col = size - 1 - col;
        }
        return this.board[row][col];
    }

    void displayBoard(){
        for(int i=size-1;i>=0;--i){
            if(i%2==0){
                for(int j=0;j<size;++j){
                    System.out.print(size*i+j+1 + "  ");
                }
            }
            else{
                for(int j=size-1;j>=0;--j){
                    System.out.print(size*i+j+1 + "  ");
                }
            }
            System.out.println();
        }
    }


}
