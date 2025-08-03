package org.example.tictactoe;

public class Board {
    int size;
    int numberOfEmptyCells;
    PieceType[][] board;
    Board(int size){
        this.size = size;
        board = new PieceType[size][size];
        numberOfEmptyCells = size*size;
    }

    boolean addPiece(int row,int col, PlayingPiece playingPiece){
        if(row<size && row>=0 && col<size && col>=0){
            if(board[row][col]!=null){
                System.out.println("Entered location is not empty, so try again!");
                return false;
            }
            board[row][col] = playingPiece.pieceType;
            numberOfEmptyCells--;
            return true;
        }
        else{
            System.out.println("Enter a valid location, so try again!");
            return false;
        }
    }

    void displayBoard(){
        for(int i=0;i<size;++i){
            for(int j=0;j<size;++j){
                if(board[i][j]!=null){
                    System.out.print(board[i][j].toString() + " ");
                }
                else{
                    System.out.print("-"+" ");
                }
            }
            System.out.println();
        }
    }

    boolean isWinnerAvailable(){
        PieceType type;
        boolean flag;
        //row check
        for(int i=0;i<size;++i){
            type = board[i][0];
            if(type == null){
                break;
            }
            flag = true;
            for(int j=1;j<size;++j){
                if (!type.equals(board[i][j])) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        //col check
        for(int i=0;i<size;++i){
            type = board[0][i];
            if(type == null){
                break;
            }
            flag = true;
            for(int j=1;j<size;++j){
                if (!type.equals(board[j][i])) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        //left diagonal check
        type = board[0][0];
        flag = true;
        if(type != null){
            for(int i=1;i<size;++i){
                if(!type.equals(board[i][i])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        //right diagonal check
        type = board[0][size-1];
        flag = true;
        if(type != null){
            for(int i=1;i<size;++i){
                if(!type.equals(board[i][size-1-i])){
                    flag = false;
                    break;
                }
            }
            return flag;
        }

        return false;
    }
}
