/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//check if a string is a palindrome
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to see if it a palindrome (T/F)");
        String input = scanner.nextLine();
        System.out.println(easyCheck(input));
        char[] word = input.toCharArray();
        System.out.println(check(word));
    }
    
    public static boolean check(char[] array) {
        for (int i = 0, j = array.length-1; i < array.length && j >= 0; i++, j--) {
            if (i == j) {
                continue;
            }
            if (array[i] == array[j]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static boolean easyCheck(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }
}
