/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
//check if the string contains only digits
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string. Returns true if the string is made of only digits, otherwise returns false:");
        String input = scanner.nextLine();
        System.out.println(input.matches("[0-9]+"));
        //[0-9] means numbers in the range of 0-9; the + means one or more times
        
        
        //alternative:
        System.out.println(input.matches("\\d+"));
        // \d means a digit; + means one or more times    
        
        //regex expressions take more time than the following alternatives:
        boolean isAllNumbers = !input.chars().anyMatch(n -> !Character.isDigit(n));
        System.out.println(isAllNumbers);
        
        //another way, faster than regex
        System.out.println(containsOnlyDigits(input));
    }
    
    public static boolean containsOnlyDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
