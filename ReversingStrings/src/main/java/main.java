/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
//reverse the letters of each word and the words themselves
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or words");
        String input = scanner.nextLine();
        
        char[] array = input.toCharArray();
        char[] reverseOrder = new char[input.length()];
        for (int i = 0, j = array.length-1; i < input.length() && j >= 0; i++, j--) {
                reverseOrder[j] = array[i];
        }
        
        System.out.print("Reverse output: ");
        System.out.println(reverseOrder);
        
        //StringBuilder output
        System.out.println(reverse(input));
    } 
    
    
    //alternative way is to use StringBuilder
    public static String reverse (String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

