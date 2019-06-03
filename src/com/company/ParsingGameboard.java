package com.company;

public class ParsingGameboard {



    public static int[][] parseGameboardFromStringToInt(String gameboard){

        int[][] game = new int [10][10];
        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                game[i][j]=Character.getNumericValue(gameboard.charAt((i+1)*(j+1)));
            }
        }

        return game;
    }

    public static String parseGameboardFromIntToString(int[][] gameboard){
        String toSendGameboard="";
        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                toSendGameboard+=String.valueOf(gameboard[i][j]);
            }
        }
        return toSendGameboard;
    }
}
