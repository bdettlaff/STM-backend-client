package com.company;

public class Game {

    public static int[][] createEmptyGameboard(){
        int[][] game = new int [10][10];
        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                game[i][j]=0;
            }
        }
        return game;
    }
}
