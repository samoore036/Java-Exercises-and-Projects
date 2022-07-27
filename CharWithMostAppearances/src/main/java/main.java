/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//find the char with the most appearances
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = scanner.nextLine();
        
        int[] count = new int[256];
        //size of 256 because this is the max number of extended ASCII table codes 

        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i)]++;
        }
        /*
        input.charAt(i) returns the char at the index. putting it in an int[] array will
        automatically convert it to its ASCII value. So 'a' would convert to 97 and 
        count[97] would equal 1, and then if 'a' is found again, count[97] would now equal 2
        */
        
        int max = 0;
        char maxChar = ' ';
        
        for (int i = 0; i < input.length(); i++) {
            if (max < count[input.charAt(i)]) {//traverse through only the index values corresponding to the input string
                max = count[input.charAt(i)];
                maxChar = input.charAt(i);
            }
        }
        
        System.out.println(String.format("The character with the highest occurence is %s, with %s occurrences.", maxChar, max));
    }
}
