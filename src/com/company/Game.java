package com.company;

import java.util.Scanner;

public class Game {

    public String[][] placingShips(String[][] gameboard){
        Scanner scanner = new Scanner(System.in);
        int numberOfShips=0;

        String statement="Podaj współrzędne środka statku 3 masztowego pionowego \"X Y\"";
        do{
            ParsingGameboard.printGameboard(gameboard);
            System.out.println(statement);
            String temp=scanner.nextLine();
            try{
                int x=Integer.parseInt(temp.split(" ")[0]);
                int y=Integer.parseInt(temp.split(" ")[1]);

                if(x<0 || x>9 || y<0 || y>9){
                    System.out.println("Błędne współrzędne");
                }
                else{
                    if(numberOfShips==0){
                        if(x>=1 && x<=8 && y>=0 && y<=9) {
                            if(gameboard[x][y].equals("S") ||
                            gameboard[x + 1][y].equals("S") ||
                            gameboard[x - 1][y].equals("S")){
                                System.out.println("Błędne współrzędne");
                            }
                            else {
                                gameboard[x][y] = "S";
                                gameboard[x + 1][y] = "S";
                                gameboard[x - 1][y] = "S";
                                numberOfShips++;
                                statement = "Podaj współrzędne pierwszego masztu statku 4 masztowego poziomego \"X Y\"";
                            }
                        }
                        else{
                            System.out.println("Błędne współrzędne");
                        }
                    }
                    else if(numberOfShips==1){
                        if(x>=0 && x<=9 && y>=0 && y<=6) {
                            if(gameboard[x][y].equals("S") ||
                            gameboard[x][y + 1].equals("S") ||
                            gameboard[x][y + 2].equals("S") ||
                            gameboard[x][y + 3].equals("S")){
                                System.out.println("Błędne współrzędne");
                            }
                            else {
                                gameboard[x][y] = "S";
                                gameboard[x][y + 1] = "S";
                                gameboard[x][y + 2] = "S";
                                gameboard[x][y + 3] = "S";
                                numberOfShips++;
                                statement="Podaj współrzędne środka statku 3 masztowego poziomego \"X Y\"";
                            }
                        }
                        else{
                            System.out.println("Błędne współrzędne");
                        }
                    }
                    else if(numberOfShips==2){
                        if(x>=0 && x<=9 && y>=1 && y<=8) {
                            if(gameboard[x][y].equals("S") ||
                               gameboard[x][y-1].equals("S") ||
                               gameboard[x][y+1].equals("S")){
                                System.out.println("Błędne współrzędne");
                            }
                            else {
                                gameboard[x][y] = "S";
                                gameboard[x][y+1] = "S";
                                gameboard[x][y-1] = "S";
                                numberOfShips++;
                                statement = "Podaj współrzędne statku 1 masztowego \"X Y\"";
                            }
                        }
                        else{
                            System.out.println("Błędne współrzędne");
                        }

                    }
                    else if(numberOfShips==3){
                        if((x>=0 && x<=9 && y>=0 && y<=9)){
                            if(gameboard[x][y].equals("S")){
                                System.out.println("Błędne współrzędne");
                            }
                            else{
                                gameboard[x][y] = "S";
                                numberOfShips++;
                                statement = "Podaj współrzędne statku 1 masztowego \"X Y\"";
                            }
                        }
                        else{
                            System.out.println("Błędne współrzędne");
                        }
                    }

                    else if(numberOfShips==4){
                        if((x>=0 && x<=9 && y>=0 && y<=9)){
                            if(gameboard[x][y].equals("S")){
                                System.out.println("Błędne współrzędne");
                            }
                            else{
                                gameboard[x][y] = "S";
                                numberOfShips++;
                                statement = "Podaj współrzędne statku 1 masztowego \"X Y\"";//do zmiany w przypadku dodania next statku
                            }
                        }
                        else{
                            System.out.println("Błędne współrzędne");
                        }
                    }



                }
            }catch (Exception e){
                System.out.println("Błędne współrzędne ");
            }
        }while(numberOfShips!=5);
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
