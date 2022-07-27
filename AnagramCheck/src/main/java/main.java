/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*check whether two string are anagrams. an anagram 
  is when a word contains all the letters of another
  word, albeit in a different order
*/
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in first string");
        String first = scanner.nextLine();
        System.out.println("Type in second string");
        String second = scanner.nextLine();
        System.out.println(anagramCheck(first, second));
    }
    
    public static boolean anagramCheck(String first, String second) {
        String firstNoSpaces = first.toLowerCase().replaceAll("\\s", "");
        String secondNoSpaces = second.toLowerCase().replaceAll("\\s", "");
        if (firstNoSpaces.toCharArray().length != secondNoSpaces.toCharArray().length) {
            return false;
        }
        ArrayList<Character> firstChars = new ArrayList<>();
        for (char c : firstNoSpaces.toCharArray()) {
            firstChars.add(c);
        }
        ArrayList<Character> secondChars = new ArrayList<>();
        for (char c : secondNoSpaces.toCharArray()) {
            secondChars.add(c);
        }
        for (int i = 0; i < firstChars.size(); i++) {
            if (!secondChars.contains(firstChars.get(i))) {
                return false;
            }
        }
        return true;
    }
}
