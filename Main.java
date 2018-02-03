package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static final int length = 10;
    public static final int shots = 5;
    public static int shotsFired = 0;
    int[] sea = new int[length];
    int[] coorBoat = {3,4};
    public static int input;
    public static boolean hit;

    public static void main(String[] args) {

	    Boat boat = new Boat();
	    boat.coorBoat = 6;

	    do {
            System.out.println("input:");
            input = sc.nextInt();

            if (boat.coorBoat == input){
                hit = true;
                System.out.println("hit");
                break;
            }
            System.out.println("miss");
        } while (shotsFired < shots);


    }
}

class Boat{

    public int coorBoat;

}

class Sea{

}

class Location{

}