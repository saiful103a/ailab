package com.saiful103a.sust.tictactoe;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;

public class Randomize {
    private String[][] board = {
            {"-","-","-"},
            {"-","-","-"},
            {"-","-","-"}
    };

    private String[] players = {"X","O"};

    private int currentPlayer;

    private final ArrayList<Pair<Integer, Integer>> availableCords;

    public Randomize(){
        availableCords = new ArrayList<>();
        currentPlayer = (int)(Math.random()*players.length);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                availableCords.add(new Pair<>(i, j));
            }
        }
    }

    private void nextTurn(){
        int index = (int)(Math.random()*availableCords.size());
        Pair<Integer,Integer> spot = availableCords.get(index);
        availableCords.remove(index);
        availableCords.trimToSize();
        board[spot.fst][spot.snd] = players[currentPlayer];
        currentPlayer = (currentPlayer+1)%players.length;
    }

    private void draw(){
        while (!availableCords.isEmpty()){
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println();
            nextTurn();
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    System.out.print(board[i][j]);
                    System.out.print("   ");
                }
                System.out.println();
            }
            if(checkWinner()!=null){
                break;
            }
        }
    }

    private boolean equals3(String a, String b, String c){
        return !a.equals("-") && a.equals(b) && b.equals(c);
    }

    private String checkWinner() {
        String winner  = null;
        //horizontal
        for(int i=0; i<3;i++){
            if(equals3(board[i][0], board[i][1], board[i][2])){
                winner = board[i][0];
            }
        }
        //vertical
        for(int i=0; i<3;i++){
            if(equals3(board[0][i], board[1][i], board[2][i])){
                winner = board[0][i];
            }
        }
        //diagonal
        if(equals3(board[0][0], board[1][1], board[2][2])){
            winner = board[0][0];
        }
        if(equals3(board[2][0], board[1][1] ,board[0][2])){
            winner = board[2][0];
        }
        if(winner == null){
            if(availableCords.size()==0)
                System.out.println("TIE");
        }else{
            System.out.println("winner: "+winner);
        }

        return winner;
    }

    public static void main(String[] args) {
        Randomize randomize = new Randomize();
        randomize.draw();
    }
}
