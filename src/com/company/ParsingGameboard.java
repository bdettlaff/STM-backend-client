package com.company;

public class ParsingGameboard {
    public static String[][] parseGameboardFromStringToStringTab(String receivedGameboard){

        String[][] gameboard = new String [10][10];
        int k=0;
        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                gameboard[i][j]=String.valueOf(receivedGameboard.charAt((k)));
                k++;

            }
        }

        return gameboard;
    }

    public static String parseGameboardFromStringTabToString(String[][] gameboard){
        String toSendGameboard="";
        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                toSendGameboard+=String.valueOf(gameboard[i][j]);
            }
        }
        return toSendGameboard;
    }
    public static String[][] createEmptyGameboard(){
        String[][] game = new String [10][10];
        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                game[i][j]="O";
            }
        }
        return game;
    }
    public static void printGameboard(String[][] gameboard) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < 10; j++) {


                System.out.print(gameboard[i][j]+" ");

            }
            System.out.println();

        }
        System.out.println();
    }
}
