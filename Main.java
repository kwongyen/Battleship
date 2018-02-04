package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static final int nRows = 4;
    public static final int nCols = 4;
    public static final int maxShots = 5;
    public static int shotsFired = 0;

    public static String input;
    public static int inputX;
    public static int inputY;

    public static int letterToNumber(char c){
        int number;
        switch(c){
            case 'A': number = 0;
                break;
            case 'B': number = 1;
                break;
            case 'C': number = 2;
                break;
            case 'D': number = 3;
                break;
            default: number = -1;
                break;
        }
        return number;
    }

    public static void initBoats(Sea sea){
        Boat b1 = new Boat(2);
        Boat b2 = new Boat(2);

        b1.setStartC(0,0);
        b1.setDirection(Boat.DOWN);
        b2.setStartC(2,3);
        b2.setDirection(Boat.RIGHT);

        sea.placeBoatinSea(b1);
        sea.placeBoatinSea(b2);
    }

    public static void main(String[] args) {

	    Sea sea = new Sea(nRows, nCols);
	    initBoats(sea);

	    for (int i = 0; i < maxShots; i++) {
            do {
                System.out.println("input:");
                input = sc.next();
                inputX = letterToNumber((input.charAt(0)));
                inputY = Character.getNumericValue(input.charAt(1)) - 1;
            } while (sea.sea[inputX][inputY].alreadyShot);

            System.out.println("new shot");
            shotsFired++;
            sea.sea[inputX][inputY].markShot();

            if (sea.sea[inputX][inputY].thereIsBoat) {
                System.out.println("Hit");
            } else {
                System.out.println("Miss");
            }
        }

    }
}

class Boat{

    public int length;
    public int startX;
    public int startY;
    public int direction;
    public boolean sunken;
    public int nHits;

    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    public static final int DOWN = 4;

    public Boat(int length) {
        this.length = length;
        this.startX = -1;
        this.startY = -1;
        this.direction = -1;
        this.sunken = false;
        this.nHits = 0;
    }

    public void setStartC(int x, int y){
        this.startX = x;
        this.startY = y;
    }

    public void setDirection(int d){
        this.direction = d;
    }

}

class Sea{

    public Location[][] sea;

    public static final int nRows = 4;
    public static final int nCols = 4;

    public Sea(int nRows, int nCols){
        sea = new Location[nRows][nCols];

        for (int row = 0; row < sea.length; row++)
        {
            for (int col = 0; col < sea[row].length; col++)
            {
                Location loc = new Location();
                sea[row][col] = loc;
            }
        }
    }

    public void placeBoatinSea(Boat b){
        int x = b.startX;
        int y = b.startY;
        sea[x][y].setBoat();

        for (int i = 1; i < b.length; i++){
            if (b.direction == Boat.LEFT){
                sea[x-1][y].setBoat();
            } else if (b.direction == Boat.UP){
                sea[x][y-1].setBoat();
            } else if (b.direction == Boat.RIGHT){
                sea[x+1][y].setBoat();
            } else if (b.direction == Boat.DOWN){
                sea[x][y+1].setBoat();
            }
        }
    }
    
}

class Location{

    public boolean thereIsBoat;
    public boolean alreadyShot;

    public Location(){
        thereIsBoat = false;
        alreadyShot = false;
    }

    public void setBoat(){
        thereIsBoat = true;
    }

    public void markShot(){
        alreadyShot = true;
    }

}