/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class Theater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = Integer.valueOf(sc.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int columns = Integer.valueOf(sc.nextLine());
        
        char[][] theater = start(rows, columns);
        System.out.println("");

        while (true) {
            System.out.println(String.format("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit"));
            int selection = Integer.valueOf(sc.nextLine());
            switch (selection) {
                case 1: 
                    printSeats(theater);
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.println("");
                            System.out.println("Enter a row number: ");
                            int row = Integer.valueOf(sc.nextLine());
                            System.out.println("Enter a seat number in that row: ");
                            int seat = Integer.valueOf(sc.nextLine());
                            if (seatAvailable(theater, row-1, seat-1)) {
                                buy(theater, row, seat);
                                System.out.println("");
                                break;
                            } 
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("");
                            System.out.println("Wrong input!");
                            continue;
                        }
                    }
                    break;
                case 3:
                    printStatistics(rows, columns);
                    break;
                case 0:
                    return;
            }
        } 
    }
    
    public static double ticketsBought = 0;
    public static int income = 0;
    
    public static void printSeats(char[][] cinema) {
        System.out.println("");
        System.out.println("Cinema: ");
        System.out.print("  ");
        for (int i = 0; i < cinema[0].length; i++) {
            System.out.printf("%d ", (i+1));
        }
        System.out.println("");
        
        int column = 1;
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(column + " ");
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            column++;
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static char[][] start(int rows, int columns) {
        char[][] theater = new char[rows][columns];
        for (char[] row : theater) {
            Arrays.fill(row, 'S');
        }
        return theater;
    }
    
    public static void buy(char[][] array, int row, int column) {
        array[row-1][column-1] = 'B';

        if (array.length * array[0].length <= 60) {
            System.out.println("");
            System.out.println("Ticket price: $10");
            income += 10;
            ticketsBought += 1;
        } else {
            if (row <= array.length/2) {
                System.out.println("");
                System.out.println("Ticket price: $10");
                income += 10;
                ticketsBought += 1;
            } else {
                System.out.println("");
                System.out.println("Ticket price: $8");
                income += 8;
                ticketsBought += 1;
            }
        } 
    }
    
    public static boolean seatAvailable(char[][] array, int row, int seat) {
        if (array[row][seat] != 'B') {
            return true;
        }
        System.out.println("That ticket has already been purchased!");
        return false;
    }
    
    public static void printStatistics(int rows, int columns) {
        System.out.println("");
        System.out.println(String.format("Number of purchased tickets: %.0f", ticketsBought));
        double tickets = (double) ticketsBought;
        double percentBought = (tickets/(rows * columns)) * 100.00;
        System.out.println(String.format("Percentage: %.2f%%", percentBought));
        System.out.println(String.format("Current income: $%d", income));
        System.out.println(String.format("Total income: $%d", getTotalIncome(rows, columns)));
        System.out.println("");
    }
    
    public static int getTotalIncome(int rows, int seats) {
        int totalSeats = rows * seats;
        if (totalSeats <= 60) {
            return 10 * totalSeats;
        } else {
            return ((rows/2) * seats * 10) + ((rows - (rows/2)) * seats * 8);
        } 
    }
}
