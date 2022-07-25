package com.saiful103a.sust.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Minimax {
    private String empty = "-";
    private String[][] board = {
            {empty,empty,empty},
            {empty,empty,empty},
            {empty,empty,empty}
    };

    private String ai = "X";
    private String  human = "O";
    private String tie = "tie";
    private Scanner scanner = null;
    private String currentPlayer;

    public Minimax(){
        scanner = new Scanner(System.in);
        currentPlayer = human;
    }

    private void bestMove(){
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                //is the spot available
                if(board[i][j].equals(empty)){
                    board[i][j] = ai;
                    int score = minimax(0, false);
                    board[i][j] = empty;
                    if(score>bestScore){
                        bestScore = score;
                        move = new int[]{i, j};
                    }
                }
            }
        }
        board[move[0]][move[1]] = ai;
        currentPlayer = human;
    }

    Map<String, Integer> resultMap = new HashMap<String, Integer>() {{
        put(ai, 10);
        put(human, -10);
        put(tie, 0);
    }};

    private int minimax(int depth, boolean isMax){
        String result = checkWinner();
        if(result!=null){
            return resultMap.get(result);
        }
        int bestScore = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(board[i][j].equals(empty)){
                    board[i][j] = isMax ? ai : human;
                    int score = minimax(depth+1, !isMax);
                    board[i][j] = empty;
                    bestScore = isMax ? Math.max(score, bestScore) : Math.min(score, bestScore);
                }
            }
        }
        return  bestScore;
    }

    private void draw(){
        if(currentPlayer.equals(human)){
            System.out.println("Your move 0,0 - 2,2 :");
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            if(board[p1][p2].equals(empty)){
                board[p1][p2] = human;
                currentPlayer = ai;
                bestMove();
            }else{
                System.out.println("Invalid move, try again.");
            }
        }
        System.out.println();
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(board[i][j]);
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    private boolean equals3(String a, String b, String c){
        return !a.equals(empty) && a.equals(b) && b.equals(c);
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
        int openSpots = 0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(board[i][j].equals(empty)){
                    openSpots++;
                }
            }
        }

        if(winner == null && openSpots == 0){
            return tie;
        }else{
            return winner;
        }
    }

    private void cleanup() {
        try {
            scanner.close();
        }catch (Exception e){}
    }

    public static void main(String[] args) {
        Minimax minimax = new Minimax();
        while (minimax.checkWinner()==null){
            minimax.draw();
        }
        minimax.cleanup();
    }


}
