/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//count the occurrences of a given string in another given string
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
        System.out.println("Enter a substring to find");
        String substring = scanner.nextLine();
        int occurences = search(input, substring);
        System.out.println("The substring " + substring + " has been found " + occurences + " times");
    }
    
    public static int search(String s, String substring) {
        int index = findSubstring(s, substring, 0);//finds first iteration of substring 
        if (index == -1) {//if none found, return a count of 0 occurrences
            return 0;
        }
        int count = 1;//count would be 1 if it made it this far
        while (index < s.length()) {//now iterate through the rest of the string to find additional occurences
            index = findSubstring(s, substring, index + substring.length());//starts from first occurence + substring length
            if (index != -1) {//the .indexOf method returns -1 if the substring hasn't been found
                count++;
            } else {
                break;//break out of loop whenever an occurrence hasn't been found again 
            }
        }
        return count;
    }
    
    public static int findSubstring(String s, String substring, int beginning) {
        return s.indexOf(substring, beginning); 
    }
}
