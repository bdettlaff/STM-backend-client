package com.company;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Game {

    public String[][] placingShips(String[][] gameboard){
        Scanner scanner = new Scanner(System.in);
        int numberOfShips=0;
        do{
            System.out.println("Podaj współrzędne środka kolejnego statku \"X Y\"");
            String temp=scanner.nextLine();
            try{
                int x=Integer.parseInt(temp.split(" ")[0]);
                int y=Integer.parseInt(temp.split(" ")[1]);

                if(x<=0 || x>9 || y<=0 || y>9){
                    System.out.println("Błędne współrzędne");
                }
                else{
                    if(numberOfShips==0){
                        gameboard[x][y]="S";
                        gameboard[x+1][y]="S";
                        gameboard[x-1][y]="S";
                    }
                    if(numberOfShips==1){
                        gameboard[x][y]="S";
                        gameboard[x][y-1]="S";
                        gameboard[x][y+1]="S";
                    }
                    if(numberOfShips==2){
                        gameboard[x][y]="S";
                        gameboard[x-1][y]="S";

                    }
                    numberOfShips++;

                }




            }catch (Exception e){
                System.out.println("Błędne współrzędne");
            }



        }while(numberOfShips!=1);
        return gameboard;
    }
    public String shot(){
        Scanner scanner = new Scanner(System.in);
        String temp;
        while(true) {
            try {
                System.out.println("Podaj współrzędne Strzału \"X.Y\"");
                temp = scanner.nextLine();
                int x = Integer.parseInt(temp.split(" ")[0]);
                int y = Integer.parseInt(temp.split(" ")[1]);
                if (x >= 0 && x < 9 && y >= 0 && y < 9) {

                    return temp;


                }
            } catch (Exception e) {
                System.out.println("Błędne współrzędne");
            }
        }

    }
}
