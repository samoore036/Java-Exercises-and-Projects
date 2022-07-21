/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
//count occurrences of a certain character
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a word or words");
            String input = scanner.nextLine();
            System.out.println("Enter the character you would like to track");
            String inputChar = scanner.nextLine();
            char c = inputChar.charAt(0);
            if (inputChar.length() != 1) {
                System.out.println("Enter one character only");
                continue;
            } else {
                System.out.println(String.format("Character first count: %s",characterCount(input, c)));
                System.out.println(String.format("Character stream count: %s", streamCharacterCount(input, c)));
                break;
            }
        }
        
    }
    
    public static int characterCount(String input, char c) {
        int charCount = 0;
        for (char ch : input.toCharArray()) {
            if (ch == c) {
                charCount++;
            }
        }
        return charCount;
    }
    
    public static long streamCharacterCount(String input, char c) {
        //String updatedInput = input.toLowerCase();
        long charCount = input.chars()
              .filter(ch -> ch == c)
              .count();
        return charCount;
    }
    
}
