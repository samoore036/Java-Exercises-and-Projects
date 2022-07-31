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
public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] game = setUpGame();
        printBoard(game);
        startGame(game, sc);
    }
    
    public static char[][] setUpGame() {
        char[][] game = new char[3][3];
        for (char[] row : game) {
            Arrays.fill(row, ' ');
        }
        return game;
    }
    
    public static void startGame(char[][] game, Scanner sc) {
        System.out.println("Player 1 uses X, Player 2 uses O. Enter coordinates (x y) to place your letter.");
        int turns = 1;
        char currentSymbol = ' ';
        while (turns < 10) {
            String input = sc.nextLine();
            if (!isDigits(input)) {
                System.out.println("Enter numbers only (ex: 2 3).");
                continue;
            }
            String[] split = input.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            if (!validNumbers(x, y)) {
                System.out.println("Invalid coordinates. Coordinates should be from 1 to 3.");
                continue;
            }
            x--;
            y--;
            if (isOccupied(game, x, y)) {
                System.out.println("This cell is occupied. Choose a different cell.");
                continue;
            } else {
                if (turns % 2 != 0) {
                    currentSymbol = 'X';
                    game[x][y] = currentSymbol;
                } else {
                    currentSymbol = 'O';
                    game[x][y] = currentSymbol;
                }
            }
            printBoard(game);
            if (evaluate(game, currentSymbol) == 1) {
                System.out.println("Impossible");
                continue;
            } 
            if (evaluate(game, currentSymbol) == 2) {
                System.out.println("Draw");
                break;
            }
            if (evaluate(game, currentSymbol) == 3) {
                System.out.println(currentSymbol + " wins");
                break;
            }
            if (evaluate(game, currentSymbol) == 4) {
                turns++;
            }        
        }
    }
    
    public static void printBoard(char[][] array) {
        System.out.println("---------");
   
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == '_') {
                    array[i][j] = ' ';
                }
            }
            System.out.printf("| %s %s %s |%n", array[i][0], array[i][1], array[i][2]);
        }
        System.out.println("---------");
    }
        
    public static boolean isDigits(String input) {
        String toEvaluate = input.replaceAll("\\s", "");
        for (int i = 0; i < toEvaluate.length(); i++) {
            if (!Character.isDigit(toEvaluate.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean validNumbers(int x, int y) {
        if (x > 3 || x < 1 || y > 3 || y < 1) {
            return false;
        }
        return true;
    }
    
    public static boolean isOccupied(char[][] array, int x, int y) {
        if (array[x][y] == 'X' || array[x][y] == 'O') {
            return true;
        }
        return false;
    }
    
    public static int evaluate(char[][] array, char symbol) {
        if (isImpossible(array) || impossibleCount(array)) {
            return 1; 
        } else if (countX(array) + countO(array) == 9) {
            return 2; 
        } else if (hasThreeInARow(array, symbol)) {
            return 3; 
        } else {
            return 4; 
        }
    }

    public static boolean isImpossible(char[][] array) {
        if (impossibleCount(array)) {
            return true;
        }
        
        if ((horizontal(array, 'X') || vertical(array, 'X') || diagonal(array, 'X')) && (horizontal(array, 'O') || vertical(array, 'O') || diagonal(array, 'O'))) {
            return true;
        }
        return false;
    }
    
    public static int countX(char[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int countO(char[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'O') {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static boolean impossibleCount(char[][] array) {
        int totalCount = Math.abs(countX(array) - countO(array));
        return totalCount >= 2;
    }
    
    public static boolean hasThreeInARow(char[][] array, char symbol) {
        String toReturn = "";
        if (horizontal(array, symbol) || vertical(array, symbol) || diagonal(array, symbol)) {
            return true;
        }
        return false;
    }
    
    public static boolean horizontal(char[][] array, char c) {
        if (array[0][0] == c && array[0][1] == c && array[0][2] == c) {
            return true;
        }
        if (array[1][0] == c && array[1][1] == c && array[1][2] == c) {
            return true;
        }
        if (array[2][0] == c && array[2][1] == c && array[2][2] == c) {
            return true;
        }
        return false;
    }
    
    public static boolean vertical(char[][] array, char c) {
        if (array[0][0] == c && array[1][0] == c && array[2][0] == c) {
            return true;
        }
        if (array[0][1] == c && array[1][1] == c && array[2][1] == c) {
            return true;
        }
        if (array[0][2] == c && array[1][2] == c && array[2][2] == c) {
            return true;
        }
        return false;
    }
    
    public static boolean diagonal(char[][] array, char c) {
        if (array[0][0] == c && array[1][1] == c && array[2][2] == c) {
            return true;
        }
        if (array[0][2] == c && array[1][1] == c && array[2][0] == c) {
            return true;
        }
        return false;
    }
}
